package ru.netology.nmedia.adapter

import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.util.postLikeShareCounter

class PostViewHolder(
    private val binding: CardPostBinding,
    private val listener: PostListener
) : ViewHolder(binding.root) {
    fun bind(post: Post) {
        with(binding) {
            headerTitle.text = post.header
            postContent.text = post.content
            publishedData.text = post.published
            shareView.isChecked = post.sharedByMe
            shareView.text = postLikeShareCounter(post.shares)
            favourite.isChecked= post.likedByMe
            favourite.text = postLikeShareCounter(post.likes)
            favourite.setOnClickListener {
                listener.onLike(post)
            }
            shareView.setOnClickListener {
                listener.onShare(post)
            }
            more.setOnClickListener {
                PopupMenu(it.context, it).apply {
                    inflate(R.menu.post_options)
                    setOnMenuItemClickListener { it ->
                        when (it.itemId) {
                            R.id.remove -> {
                                listener.onRemove(post)
                            }
                            R.id.edit -> {
                                listener.onEdit(post)
                                true
                            }
                        }
                        false
                    }
                }.show()
            }
        }
    }

}