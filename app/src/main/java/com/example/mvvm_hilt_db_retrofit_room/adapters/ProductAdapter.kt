package com.example.mvvm_hilt_db_retrofit_room.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_hilt_db_retrofit_room.R
import com.example.mvvm_hilt_db_retrofit_room.databinding.ProductItemBinding
import com.example.mvvm_hilt_db_retrofit_room.models.ProductsItem

class ProductAdapter(private val productList: MutableList<ProductsItem>, private val onItemClicked: (ProductsItem) -> Unit):
    RecyclerView.Adapter<ProductAdapter.UserViewHolder>() {

    private var list: MutableList<ProductsItem> = productList

    fun updateData(newProductList: List<ProductsItem>) {
        list. clear()
        list.addAll(newProductList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: ProductItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.product_item,
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

    class UserViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductsItem) {
            binding.product = item
            binding.executePendingBindings() // Ensures immediate binding updates
        }
    }

}