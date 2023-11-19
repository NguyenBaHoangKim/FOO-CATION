package com.example.common.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream

class Extensions {
    companion object {
        fun Bitmap.toByteArray(): ByteArray {
            val stream = ByteArrayOutputStream()
            this.compress(Bitmap.CompressFormat.PNG, 100, stream)
            return stream.toByteArray()
        }

        fun ByteArray.toBitmap(): Bitmap {
            return BitmapFactory.decodeByteArray(this, 0, this.size)
        }

        fun String.toBitMap(): Bitmap {
            val byteArray = Base64.decode(this, Base64.DEFAULT)
            return byteArray.toBitmap()
        }
    }
}