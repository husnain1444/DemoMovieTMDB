package com.example.movies.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.utils.Constants

//@BindingAdapter("textWithHeading")// For Single Value
@BindingAdapter("title", "text") // Multiple Attribute Binding
fun textWithHeading(textView: TextView, title: String, text: String?) {
        textView.setText("$title: $text")
}


//If you want some attributes to be optional, you can handle null values:

//@BindingAdapter(value = ["heading", "text"], requireAll = false)
//fun textWithHeading(textView: TextView, heading: String?, text: String?) {
//        val headingPart = heading ?: "Default Heading"
//        val textPart = text ?: "No Text"
//        textView.text = "$headingPart: $textPart"
//}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
                Glide.with(view.context)
                        .load(Constants.IMAGE_URL + url)
                        .placeholder(R.drawable.poster_place_holder)   // shown while loading
                        .error(R.drawable.poster_place_holder)
                        .into(view)
        } else {
                Glide.with(view.context)
                        .load(R.drawable.poster_place_holder)
                        .placeholder(R.drawable.poster_place_holder)   // shown while loading
                        .error(R.drawable.poster_place_holder)
                        .into(view)
        }
}