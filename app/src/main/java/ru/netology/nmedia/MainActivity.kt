package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.util.postLikeCounter
import ru.netology.nmedia.util.postShareCounter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val post = Post(
            header = "Нетология. Университет интернет профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов " +
                    "по онлайн - маркетингу. Затем появились курсы по дизайну, разработке аналитике " +
                    "и управлению. Мы растём сами и помогаем расти студентам: от новичков до " +
                    "уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в " +
                    "каждом уже есть сила, которая заставляет хотеть больше, целиться выше, " +
                    "бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен",
            published = "21 мая 18:36",
            likedByMe = false,
            sharedByMe = false,
            likes = 999,
            shares = 990
        )

        with(binding) {
            headerTitle.text = post.header
            postContent.text = post.content
            publishedData.text = post.published
            favouriteCount.text = post.likes.toString()
            shareCount.text=post.shares.toString()

            if (post.likedByMe) {
                favourite?.setImageResource(R.drawable.favourite_liked)
            }
            favourite?.setOnClickListener {
                post.likedByMe = !post.likedByMe
                post.likes = if (post.likedByMe) {
                    post.likes + 1
                } else post.likes - 1
                favouriteCount.text = postLikeCounter(post)
                favourite.setImageResource(
                    if (post.likedByMe) {
                        R.drawable.favourite_liked
                    } else R.drawable.favourite
                )
            }
            shareView?.setOnClickListener {
                post.shares = post.shares + 1
                shareCount.text = postShareCounter(post)
            }
        }
    }
}












