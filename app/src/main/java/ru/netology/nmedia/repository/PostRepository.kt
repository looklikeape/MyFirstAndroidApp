package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post


interface PostRepository {
    fun getData(): LiveData<Post>
    fun like()
    fun share()
}

class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
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
        likes = 100_298_002,
        shares = 990_614
    )
    private val data = MutableLiveData(post)
    override fun getData(): LiveData<Post> = data
    override fun like() {
        post = post.copy(
            likedByMe = !post.likedByMe,
            likes = if (post.likedByMe) post.likes - 1 else post.likes + 1,
        )
        data.value = post
    }

    override fun share() {
        post = post.copy(
            shares = post.shares + 1
        )
        data.value = post
    }
}