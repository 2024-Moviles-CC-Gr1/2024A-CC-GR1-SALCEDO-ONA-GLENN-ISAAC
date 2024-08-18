package com.example.instagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StoriesAdapter(private val storiesList: List<String>) :
    RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder>() {

    class StoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val storyImage: ImageView = itemView.findViewById(R.id.storyImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story, parent, false)
        return StoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        // Aquí deberías cargar las imágenes de las historias, usando Glide o Picasso
        Glide.with(holder.itemView.context)
            .load(storiesList[position])
            .into(holder.storyImage)
    }

    override fun getItemCount(): Int = storiesList.size
}
