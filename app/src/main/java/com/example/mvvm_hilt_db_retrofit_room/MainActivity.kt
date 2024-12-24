package com.example.mvvm_hilt_db_retrofit_room

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_hilt_db_retrofit_room.adapters.ProductAdapter
import com.example.mvvm_hilt_db_retrofit_room.databinding.ActivityMainBinding
import com.example.mvvm_hilt_db_retrofit_room.models.ProductsItem
import com.example.mvvm_hilt_db_retrofit_room.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

//    @Inject
//    lateinit var mainViewModelFactory: MainViewModelFactory

//    val products: TextView
//        get() = findViewById(R.id.products)

    lateinit var binding: ActivityMainBinding
    lateinit private var adapter: ProductAdapter

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

//        (application as DemoApplication).applicationComponent.inject(this)
// No need to call dagger inject and factory in case of Hilt ***
//        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Set up RecyclerView
        binding.productRV.layoutManager = LinearLayoutManager(this)

        mainViewModel.productsLiveData.observe(this, Observer {
//            binding.products.text = it.joinToString { x-> x.title + '\n'} // To Show Data in String
           if (::adapter.isInitialized) {
               adapter.updateData(it)
           } else {
               adapter = ProductAdapter(it.toMutableList()) { productsItem ->
                   showProductDetailDialog(this,productsItem)
               }
               binding.productRV.adapter = adapter
           }
        })

        mainViewModel.loadDataFromAPI() // Call After Setting Adapter and observer
    }

    fun showProductDetailDialog(context: Context, product: ProductsItem) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(product.title)
        builder.setMessage(
            """
        ID: ${product.id}
        Price: $${product.price}
        Description: ${product.description}
        Rating: ${product.rating.rate}
        """.trimIndent()
        )
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}