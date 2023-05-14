package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post


interface PostRepository {
    fun getData(): LiveData<List<Post>>
    fun likeById(id: Long)
    fun share(id: Long)
    fun removeById(id: Long)
    fun save(it: Post)


}

class PostRepositoryInMemoryImpl : PostRepository {
    private var nextId = 0L
    private var posts = listOf(
        Post(
            id = ++nextId,
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
            shares = 990_999
        ),
        Post(
            id = ++nextId,
            header = "Нетология. Университет интернет профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов " +
                    "по онлайн - маркетингу. Затем появились курсы по дизайну, разработке аналитике " +
                    "и управлению. Мы растём сами и помогаем расти студентам: от новичков до " +
                    "уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в " +
                    "каждом уже есть сила, которая заставляет хотеть больше, целиться выше, " +
                    "бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен",
            published = "21 мая 18:34",
            likedByMe = false,
            sharedByMe = false,
            likes = 1,
            shares = 3
        ),
        Post(
            id = ++nextId,
            header = "Нетология. Университет интернет профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов " +
                    "по онлайн - маркетингу. Затем появились курсы по дизайну, разработке аналитике " +
                    "и управлению. Мы растём сами и помогаем расти студентам: от новичков до " +
                    "уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в " +
                    "каждом уже есть сила, которая заставляет хотеть больше, целиться выше, " +
                    "бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен",
            published = "21 мая 18:33",
            likedByMe = false,
            sharedByMe = false,
            likes = 14,
            shares = 991_923
        ),
        Post(
            id = ++nextId,
            header = "Нетология. Университет интернет профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов " +
                    "по онлайн - маркетингу. Затем появились курсы по дизайну, разработке аналитике " +
                    "и управлению. Мы растём сами и помогаем расти студентам: от новичков до " +
                    "уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в " +
                    "каждом уже есть сила, которая заставляет хотеть больше, целиться выше, " +
                    "бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен",
            published = "21 мая 18:32",
            likedByMe = false,
            sharedByMe = false,
            likes = 1_111_999,
            shares = 1_111_999
        ),
        Post(
            id = ++nextId,
            header = "Нетология. Университет интернет профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов " +
                    "по онлайн - маркетингу. Затем появились курсы по дизайну, разработке аналитике " +
                    "и управлению. Мы растём сами и помогаем расти студентам: от новичков до " +
                    "уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в " +
                    "каждом уже есть сила, которая заставляет хотеть больше, целиться выше, " +
                    "бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен",
            published = "21 мая 18:30",
            likedByMe = false,
            sharedByMe = false,
            likes = 1_111_520,
            shares = 990_014
        ),
        Post(
            id = ++nextId,
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
            likes = 1_111_520,
            shares = 990_014
        )
    ).reversed()

    private val data = MutableLiveData(posts)

    override fun getData(): LiveData<List<Post>> = data

    override fun likeById(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(
                    likedByMe = !post.likedByMe,
                    likes = if (post.likedByMe) post.likes - 1 else post.likes + 1
                )
            } else {
                post
            }
        }
        data.value = posts
    }

    override fun share(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(shares = post.shares + 1)
            } else {
                post
            }
        }
        data.value = posts
    }

    override fun removeById(id: Long) {
        posts = posts.filter {
            it.id != id
        }
        data.value = posts
    }

    override fun save(post: Post) {
        if (post.id == 0L) {
            posts = listOf(
                post.copy(
                    id = ++nextId,
                    header = "Me",
                    likedByMe = false,
                    published = "now"
                )) + posts
            data.value = posts
            return
        }
        posts = posts.map {
            if (it.id != post.id) it else it.copy(content = post.content)
        }
        data.value = posts
    }
}

