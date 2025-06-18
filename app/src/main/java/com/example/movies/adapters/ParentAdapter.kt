package com.example.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.databinding.MoviesClosureItemBinding
import com.example.movies.models.MoviesClosure
import com.example.movies.models.Result

class ParentAdapter(private val groups: List<MoviesClosure>, private val onItemClicked: (Result) -> Unit) :
    RecyclerView.Adapter<ParentAdapter.GroupViewHolder>() {

    inner class GroupViewHolder(val binding: MoviesClosureItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val binding = MoviesClosureItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val group = groups[position]
        holder.binding.tvGroupTitle.text = group.mediaType.uppercase()

        holder.binding.rvGroupItems.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

        holder.binding.rvGroupItems.adapter = ChildAdapter(group.items, onItemClicked)
    }

    override fun getItemCount(): Int = groups.size
}
