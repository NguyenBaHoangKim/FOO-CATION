package com.example.model

import android.graphics.Bitmap
import android.media.Image

data class User(
    val id: String,
    val username: String,
    val displayName: String,
    val email: String,
//    val passWord: String,
//    val avatar: Image,
)

data class Repassword(
    val id: String,
    val passWord: String,
    val rePassWord: String,
)

data class Signup(
    val userName: String,
    val displayName: String,
    val email: String,
    val passWord: String,
    val rePassWord: String,
)

data class Signin(
    val email: String,
    val passWord: String,
)

data class Slider(
    val img: Image,
    val name: String,
    val intro: String,
)

data class Even(
    val img: Image,
    val name: String,
    val time: String,
    val location: String,
)

data class Location(
    val id: String,
    val name: String,
    val nameInMap: String,
    val latitude: Double,
    val longtitude: Double,
    val image: Bitmap
)

data class LocationResp(
    val id: String,
    val name: String,
    val nameInMap: String,
    val latitude: Double,
    val longitude: Double,
    val image: ImageBitmap,
    val description: String,
    val artifacts: List<Artifact>,
)
data class Artifact(
    val id: String,
    val name: String,
    val time: String,
    val locationId: String,
    val image: ImageBitmap,
    val description: String,
)
data class ImageBitmap (
    val type: String,
    val data: String,
)

data class QuizResp(
    val id: String,
    val locationId: String,
    val question: String,
    val point: Int,
    val correctAnwer: String,
    val image: ImageBitmap,
    val answers: Answer
)
data class Quiz(
    val id: String,
    val locationId: String,
    val question: String,
    val point: Int,
    val correctAnwer: String,
    val image: Bitmap,
    val answers: Answer
)


data class Answer(
    val id: String,
    val quizId: String,
    val answer: String,
)

data class Fact(
    val id: String,
    val content: String,
    val quizId: QuizResp,
    val row: String,
)

data class Point(
    val id: String,
    val userId: String,
    val point: Int,
)

data class Currency(
    val uniqueId: String,
    val name: String,
    val unit: String,
)

data class Staff(
    val id: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val userName: String,
    val passWord: String,
    val locationId: Location,
    val role: String,
)
data class AnswerInformation(
    val img: Image,
    val info: String
)

data class SearchsData(
    val locations: List<Location>,
    val artifacts: List<Artifact>
)

//data class SearchsData(
//    val id: String,
//    val name: String,
//    val nameInMap: String,
//    val latitude: String,
//    val longtitude: String,
//    val image: Image,
//
//)

data class SearchData(
    val id: String,
    val title: String,
    val logo: Bitmap,
    val type: String
)

data class ArchiveData(
    val id: String,
    val  title: String,
    val  logo: Bitmap
)

data class EventResp(
    val eventName: String,
    val time: String,
    val address: String,
    val image: ImageBitmap,
)
data class Event(
    val eventName: String,
    val time: String,
    val address: String,
    val image: Bitmap,
)

data class Item(
    val id: String,
    val locationId: String,
    val hintImage: Bitmap,
    val itemImage: Bitmap
)

data class ItemResp(
    val id: String,
    val locationId: String,
    val hintItem: ImageBitmap,
    val itemImage: ImageBitmap,
)


