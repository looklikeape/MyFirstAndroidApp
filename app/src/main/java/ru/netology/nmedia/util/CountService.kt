package ru.netology.nmedia.util

import ru.netology.nmedia.dto.Post
import kotlin.math.floor

fun postLikeCounter (post:Post):String {
        val pl = when (post.likes) {
            in 0..999 -> post.likes.toString()
            in 1000..999999 -> (floor(post.likes.toDouble()/100)/10).toString() + "K"
            else -> {
                (floor(post.likes.toDouble() / 100000)/10).toString() + "M"
            }
        }
        return pl
    }
fun postShareCounter (post:Post):String{
    val ps = when(post.shares) {
        in 0..999 -> post.shares.toString()
        in 1000..999999 -> (floor(post.shares.toDouble()/100)/10).toString() + "K"
        else -> {
            (floor(post.shares.toDouble() / 100000)/10).toString() + "M"
        }
    }
        return ps
    }

