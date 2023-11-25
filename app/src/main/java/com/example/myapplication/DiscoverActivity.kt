package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.http.apiArtifact.ItemsManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.common.utils.MyApp.Companion.context
import com.example.model.Item
import com.example.model.ItemResp
import com.example.popup.ItemPopup
import java.util.Timer


open class DiscoverActivity : AppCompatActivity() {
    private var listItems = ArrayList<Item>()
    val list : MutableList<Int> = mutableListOf(1,2,3,4,5)
    val listIndex = list.shuffled()
    val timer : Timer? = null
    private var handler: Handler = Handler()
    private var runnable: Runnable? = null
    private var delay = 5000

    private var itemManager = ItemsManager()
    private lateinit var image1 : ImageView
    private lateinit var image2 : ImageView
    private lateinit var image3 : ImageView
    private lateinit var image4 : ImageView
    private lateinit var image5 : ImageView
    val showPopup = ItemPopup()
    var id : String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)
        val btn : Button = findViewById(R.id.back)

        image1 = findViewById(R.id.item1)
        image2 = findViewById(R.id.item2)
        image3 = findViewById(R.id.item3)
        image4 = findViewById(R.id.item4)
        image5 = findViewById(R.id.item5)
        val extras: Bundle? = intent.extras
        if (extras != null) {
            id = extras.get("locationId").toString()
            println(id)
        }

//        fetchData()
        addData()
        addImage()
//        setTimer()
        startTimer()
        btn.setOnClickListener {
            stopTimer()
            finish()
        }
    }
    fun startTimer(){
        var index = 0;
        var l = 3000
        var r = 10000
        var delay : Long = (l until r).random().toLong()
        handler.postDelayed(Runnable {
            delay = (l until r).random().toLong()
            handler.postDelayed(runnable!!, delay)
                val item = listIndex[index]
                foundItem(item)
                index++
                if(index < 5) {
                    Toast.makeText(
                        this@DiscoverActivity, "Đi càng lâu nhận càng nhiều vật phẩm đó",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else {
                    Toast.makeText(
                        this@DiscoverActivity, "Bạn đã nhận hết vật phẩm rùi",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if(index == 5) {
                    stopTimer()
                }
        }.also { runnable = it }, delay)
    }

    fun stopTimer() {
        handler.removeCallbacks(runnable!!);
    }

    fun foundItem(i: Int){
        println("i " + i)
        showPopup.setImagePopup(listItems[i-1].itemImage)
        showPopup.show((this as AppCompatActivity).supportFragmentManager, "")
        chooseItem(i)
    }
    fun chooseItem(i : Int){
        when(i){
            1 -> setItem(image1, listItems[i - 1].itemImage )
            2 -> setItem(image2, listItems[i - 1].itemImage )
            3 -> setItem(image3, listItems[i - 1].itemImage )
            4 -> setItem(image4, listItems[i - 1].itemImage )
            5 -> setItem(image5, listItems[i - 1].itemImage )
        }
    }
    fun setItem(image : ImageView, bitmap: Bitmap) {
        image?.setImageBitmap(bitmap)
    }
    private fun fetchData() {
        itemManager.getItemsWithLocationId(id ,{ data: List<ItemResp> ->
            for(item in data) {
                listItems.add(Item(item.id, id, item.hintImage.data.toBitMap(),item.itemImage.data.toBitMap()))
            }
        }, { error ->
            println(error)
        })
    }
    fun addData(){
        listItems.add(Item("blabla","idL", BitmapFactory.decodeResource(context?.resources,
            R.drawable.item1), BitmapFactory.decodeResource(context?.resources,
            R.drawable.hint1)))
        listItems.add(Item("blabla","idL", BitmapFactory.decodeResource(context?.resources,
            R.drawable.item2), BitmapFactory.decodeResource(context?.resources,
            R.drawable.hint2)))
        listItems.add(Item("blabla","idL", BitmapFactory.decodeResource(context?.resources,
            R.drawable.item3), BitmapFactory.decodeResource(context?.resources,
            R.drawable.hint3)))
        listItems.add(Item("blabla","idL", BitmapFactory.decodeResource(context?.resources,
            R.drawable.item4), BitmapFactory.decodeResource(context?.resources,
            R.drawable.hint4)))
        listItems.add(Item("blabla","idL", BitmapFactory.decodeResource(context?.resources,
            R.drawable.item5), BitmapFactory.decodeResource(context?.resources,
            R.drawable.hint5)))
    }
    fun addImage(){
        image1.setImageBitmap(listItems[0].hintImage)
        image2.setImageBitmap(listItems[1].hintImage)
        image3.setImageBitmap(listItems[2].hintImage)
        image4.setImageBitmap(listItems[3].hintImage)
        image5.setImageBitmap(listItems[4].hintImage)

    }
}

