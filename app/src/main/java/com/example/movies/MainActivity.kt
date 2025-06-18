package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.adapters.MovieAdapter
import com.example.movies.adapters.ParentAdapter
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.models.MoviesClosure
import com.example.movies.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    lateinit var binding: ActivityMainBinding
    lateinit private var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Set up RecyclerView
        binding.closureRV.layoutManager = LinearLayoutManager(this)

        mainViewModel.moviesLiveData.observe(this, Observer {
//            Log.i("Checking API Data....",it.toString())
//           if (::adapter.isInitialized) {
//               adapter.updateData(it)
//           } else {
//               adapter = MovieAdapter(it.toMutableList()) { movieResult ->
//                   mainViewModel.setResult(movieResult)
//
//                   val intent = Intent(this, DetailActivity::class.java)
//                   startActivity(intent)
//               }
//               binding.closureRV.adapter = adapter
//           }
        })

        mainViewModel.moviesClosureLiveData.observe(this, Observer {
            Log.e("Movies Closure:", it.toString())
            Log.e("Movies Closure:", it.size.toString())
            val groupedList = it.map { MoviesClosure(it.key, it.value) }
            binding.closureRV.adapter = ParentAdapter(groupedList) { movieResult ->
                mainViewModel.setResult(movieResult)

                Log.e("Clicked Items:", movieResult.toString())
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("movie", movieResult)
                startActivity(intent)
            }
        })

        binding.searchEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val query = v.text.toString()
                // handle search
                mainViewModel.loadDataFromAPI(query) // Call After Setting Adapter and observer
                true
            } else {
                false
            }
        }
        binding.searchEditText.text
    }
}