package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val header: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean = false,
    val sharedByMe: Boolean = false,
    val likes: Int = 0,
    val shares: Int = 0
)
