package ru.netology.nmedia.dto

data class Post(
    val id: Long = 0,
    val header: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean = false,
    val sharedByMe: Boolean = false,
    val likes:Int,
    val shares:Int
    )
