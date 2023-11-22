package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.model.Item
import com.example.model.SearchData
import java.util.Timer
import kotlin.concurrent.schedule

class DiscoverActivity : AppCompatActivity() {
    private var listItems = ArrayList<Item>()
    val listIndex : List<Int> = listOf(1,2,3,4,5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)
        listIndex.shuffled()
//        createHintItems()
//        createListItems()

        val image : ImageView = findViewById(R.id.item1)

    }
    fun createItem(index : Int) {
        var delay : Long = (1000 until 2000).random().toLong()
        println(delay)
//        Handler().postDelayed({
//                              println("hello" + delay)
//        }, delay)
//        Timer("SettingUp", false).schedule(delay){
//            val image : ImageView = findViewById(hintItems[index])
//            println(image)
//            println("id item" + listItems[index])
//            image.setImageResource(listItems[index])
//            println("change item" + image)
//        }
    }


}