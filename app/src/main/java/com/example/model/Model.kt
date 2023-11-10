package com.example.model

import android.media.Image
import android.service.quicksettings.Tile

data class User (
    val id: String,
    val username: String,
    val displayName: String,
    val email: String,
    val passWord: String,
    val avatar: Image,
)

data class Repassword (
    val id: String,
    val passWord: String,
    val rePassWord: String,
)
data class Signup (
    val userName: String,
    val displayName: String,
    val email: String,
    val passWord: String,
    val rePassWord: String,
)

data class Signin (
    val email: String,
    val passWord: String,
)

data class Slider (
    val img: Image,
    val name: String,
    val intro: String,
)

data class Even (
    val img: Image,
    val name: String,
    val time: String,
    val location: String,
)
data class Location (
    val id: String,
    val name: String,
    val nameInMap: String,
    val latitude: String,
    val longtitude: String,
)
data class Quiz (
    val id: String,
    val question: String,
    val point: Int,
    val correctAnwer: Boolean,
)

data class Answer (
    val id: String,
    val quizId: String,
    val content: String,
)

data class Artifact (
    val id: String,
    val name: String,
    val time: String,
    val locationId: Location,
    val images: Array<Image>
)

data class Fact (
    val id: String,
    val content: String,
    val quizId: Quiz,
    val row: String,
)

data class Point (
    val id: String,
    val userId: String,
    val point: Int,
)

data class Currency (
    val uniqueId: String,
    val name: String,
    val unit: String,
)

data class Staff (
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

//data class SearchsData(
//    val locations: List<Location>,
//    val artifacts: List<Artifact>,
//)

data class SearchData(
    val title: String,
    val logo: Int
)

