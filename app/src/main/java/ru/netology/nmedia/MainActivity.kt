package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.util.postLikeShareCounter
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                headerTitle.text = post.header
                postContent.text = post.content
                publishedData.text = post.published
                favouriteCount.text = postLikeShareCounter(post.likes)
                shareCount.text = postLikeShareCounter(post.shares)
                favourite.setImageResource(
                    if (post.likedByMe) R.drawable.favourite_liked else R.drawable.favourite
                )
            }
        }
        binding.favourite.setOnClickListener {
            viewModel.like()
        }
        binding.shareView.setOnClickListener {
            viewModel.share()
        }
    }
}











