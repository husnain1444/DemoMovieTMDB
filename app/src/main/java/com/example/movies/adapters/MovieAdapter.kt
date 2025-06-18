package com.example.movies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.databinding.MoviesItemBinding
import com.example.movies.models.Result

class MovieAdapter(private val moviesList: MutableList<Result>, private val onItemClicked: (Result) -> Unit):
    RecyclerView.Adapter<MovieAdapter.UserViewHolder>() {

    private var list: MutableList<Result> = moviesList

    fun updateData(newMoviesList: List<Result>) {
        list. clear()
        list.addAll(newMoviesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: MoviesItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movies_item,
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener(View.OnClickListener {
            onItemClicked(list[position])
        })
    }

    override fun getItemCount(): Int = list.size

    class UserViewHolder(private val binding: MoviesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result) {
            binding.movie = item
            binding.executePendingBindings() // Ensures immediate binding updates
        }
    }

}