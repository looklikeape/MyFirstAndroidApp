package ru.netology.nmedia.util

import kotlin.math.floor


fun postLikeShareCounter(x: Int): String {
    val count = when (x) {
        in 0..999 -> x.toString()
        in 1000..9_999 -> if (x % 1000 < 100) {
            (x / 1000).toString() + "K"
        } else (floor(x.toDouble() / 100) / 10).toString() + "K"
        in 10_000..999_999 -> (x / 1000).toString() + "K"
        else -> if (x % 1_000_000 < 100_000) {
            (x / 1_000_000).toString() + "M"
        } else (floor(x.toDouble() / 100000) / 10).toString() + "M"
    }
    return count
}


