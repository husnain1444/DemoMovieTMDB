package com.example.movies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.databinding.MoviesItemBinding
import com.example.movies.models.Result

class ChildAdapter(private val items: List<Result>, private val onItemClicked: (Result) -> Unit) :
    RecyclerView.Adapter<ChildAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = MoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.bind(item)

        holder.itemView.setOnClickListener(View.OnClickListener {
            onItemClicked(item)
        })

//        holder.binding.tvTitle.text = item.title ?: item.name ?: "No Title"
//
//        Glide.with(holder.itemView.context)
//            .load("https://image.tmdb.org/t/p/w500${item.poster_path}")
//            .into(holder.binding.ivPoster)
    }

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(val binding: MoviesItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result) {
            binding.movie = item
            binding.executePendingBindings() // Ensures immediate binding updates
        }
    }

}
