package com.example.model

import android.graphics.Bitmap
import android.media.Image
import com.example.common.utils.Extensions.Companion.toBitMap

data class User(
    val id: String,
    val username: String,
    val displayName: String,
    val email: String,
    val rankingPoint: Int,
    val balance: Int
)
data class Signup(
    val id: String,
    val username: String,
    val displayName: String,
    val email: String,
)

data class SignupRequest(
    val username: String,
    val displayName: String,
    val email: String,
    val password: String,
    val rePassword: String,
)

data class Location(
    val id: String,
    val name: String,
    val nameInMap: String,
    val latitude: Double,
    val longtitude: Double,
    val image: Bitmap,
    val fact: String
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
    val fact: String
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
    val correctAnswer: String,
    val image: ImageBitmap,
    val answers: List<Answer>,
    val description: String
)
data class Quiz(
    val id: String,
    val locationId: String,
    val question: String,
    val point: Int,
    val correctAnswer: String,
    val image: Bitmap,
    val answers: List<Answer>,
    val description: String
) {
    constructor(quizResp: QuizResp): this(
        id = quizResp.id,
        locationId = quizResp.locationId,
        question = quizResp.question,
        point = quizResp.point,
        correctAnswer = quizResp.correctAnswer,
        image = quizResp.image.data.toBitMap(),
        answers = quizResp.answers,
        description = quizResp.description
    )
}


data class Answer(
    val id: String,
    val quizId: String,
    val answer: String,
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
    val itemImage: Bitmap,
    val description: String
)
//data class Item(
//    val id: String,
//    val locationId: String,
//    val hintImage: Bitmap,
//    val itemImage: Bitmap
//)

data class ItemResp(
    val id: String,
    val name: String,
    val locationId: String,
    val unfoundedImage: ImageBitmap,
    val foundImage: ImageBitmap,
    val description: String
)


