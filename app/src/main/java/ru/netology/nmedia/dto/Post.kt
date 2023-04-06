package ru.netology.nmedia.dto

import android.widget.TextView


data class Post(
    val id: Long = 0,
    val header: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean = false,
    var sharedByMe: Boolean = false,
    var likes:Int,
    var shares:Int


    )
