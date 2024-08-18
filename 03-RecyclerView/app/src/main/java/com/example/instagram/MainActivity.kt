package com.example.instagram

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storiesRecyclerView = findViewById<RecyclerView>(R.id.storiesRecyclerView)
        val postsRecyclerView = findViewById<RecyclerView>(R.id.postsRecyclerView)

        // Lista de prueba para historias (URLs de imágenes de ejemplo)
        val storiesList = listOf(
            "https://www.socialpilot.co/wp-content/uploads/2021/07/instagram-story-size.jpg",
            "https://www.socialpilot.co/wp-content/uploads/2021/07/instagram-story-size.jpg",
            "https://www.socialpilot.co/wp-content/uploads/2021/07/instagram-story-size.jpg"
        )

        // Lista de prueba para publicaciones
        val postsList = listOf(
            Post("https://wplook.com/wp-content/uploads/2018/03/instagram-photo-size-square-1080.jpg", "Descripción del Post 1"),
            Post("https://wplook.com/wp-content/uploads/2018/03/instagram-photo-size-square-1080.jpg", "Descripción del Post 2"),
            Post("https://wplook.com/wp-content/uploads/2018/03/instagram-photo-size-square-1080.jpg", "Descripción del Post 3")
        )

        // Configura el RecyclerView de historias
        storiesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val storiesAdapter = StoriesAdapter(storiesList)
        storiesRecyclerView.adapter = storiesAdapter

        // Configura el RecyclerView de publicaciones
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        val postsAdapter = PostsAdapter(postsList)
        postsRecyclerView.adapter = postsAdapter
    }
}

data class Post(val imageUrl: String, val description: String)
