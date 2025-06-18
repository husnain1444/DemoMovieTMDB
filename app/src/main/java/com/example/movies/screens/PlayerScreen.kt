package com.example.movies.screens

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.databinding.PlayerScreenBinding
import com.example.movies.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerScreen : AppCompatActivity() {

    lateinit var binding: PlayerScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.player_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.playerScreen)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val poster_path = intent.getStringExtra("movie_poster") ?: ""


        Glide.with(this)
            .load(Constants.IMAGE_URL + poster_path)
            .placeholder(R.drawable.poster_place_holder)
            .into(binding.posterImageView)
    }
}
