package ru.netology.nmedia.dto

import android.widget.TextView


data class Post(
    val id: Long = 0,
    val header: TextView,
    val content: TextView,
    val published: TextView,
    var likedByMe: Boolean = false,
    var sharedByMe: Boolean = false,
    var likes:Int,
    var shares:Int


    )
