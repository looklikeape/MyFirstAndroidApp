package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            header = findViewById(R.id.header_title),
            content = findViewById(R.id.post_content),
            published = findViewById(R.id.published_data),
            likedByMe = false,
            sharedByMe = false,
            likes = 9999,
            shares = 990
        )

        with(binding){
            headerTitle.text= post.header.text
            postContent.text = post.content.text
            publishedData.text = post.published.text


            if (post.likedByMe){
                favourite?.setImageResource(R.drawable.favourite_liked)
            }
            favourite?.setOnClickListener{
                post.likedByMe = !post.likedByMe
                post.likes = if(post.likedByMe) {
                    post.likes + 1
                } else post.likes -1
                val pl = when(post.likes){
                    in 0..999 -> post.likes.toString()
                    in 1000..999999-> (post.likes.toDouble()/1_000).toString() +"K"
                    else -> {(post.likes.toDouble()/1000000).toString()+"M"}
                }
                favouriteCount.text = pl

                favourite.setImageResource(
                    if (post.likedByMe) {
                        R.drawable.favourite_liked
                    }
                    else R.drawable.favourite)
            }
            shareView?.setOnClickListener {
                post.shares = post.shares+1
                val ps = when(post.shares){
                    in 0..999 -> post.shares.toString()
                    in 1000..999999-> (post.shares.toDouble()/1_000).toString() +"K"
                    else -> {(post.shares.toDouble()/1000000).toString()+"M"}
                }

                shareCount.text = ps
            }
            }
        }
    }











