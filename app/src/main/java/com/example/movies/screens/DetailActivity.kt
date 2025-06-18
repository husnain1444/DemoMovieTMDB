package com.example.movies.screens

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.databinding.ActivityDetailBinding
import com.example.movies.models.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val movie = intent.getParcelableExtra<Result>("movie")
        loadData(movie!!)
    }

    private fun loadData(movie: Result) {
        binding.textTitle.text = movie.title ?: movie.name ?: "N/A"
        binding.textReleaseDate.text = "Release Date: ${movie.release_date?.ifEmpty { movie.first_air_date }}"
        binding.textRating.text = "Rating: ${movie.vote_average}/10"
        binding.textOverview.text = movie.overview

        if (!movie.poster_path.isNullOrEmpty()) {
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
                .into(binding.imagePoster)
        } else {
            Glide.with(this)
                .load(R.drawable.poster_place_holder)
                .into(binding.imagePoster)
        }

        // Show play button only if it's a movie or tv
        if (movie.media_type == "movie" || movie.media_type == "tv") {
            binding.btnPlay.visibility = View.VISIBLE
            binding.btnPlay.setOnClickListener {
                Toast.makeText(this, "Playback started", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PlayerScreen::class.java)
                intent.putExtra("movie_poster", movie.poster_path)
                startActivity(intent)
            }
        }

    }
}