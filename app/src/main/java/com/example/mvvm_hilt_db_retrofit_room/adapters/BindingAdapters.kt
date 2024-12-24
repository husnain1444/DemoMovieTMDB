package com.example.mvvm_hilt_db_retrofit_room.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

//@BindingAdapter("textWithHeading")// For Single Value
@BindingAdapter("heading", "text") // Multiple Attribute Binding
fun textWithHeading(textView: TextView, heading: String, text: String) {
        textView.setText("$heading: $text")
}


//If you want some attributes to be optional, you can handle null values:

//@BindingAdapter(value = ["heading", "text"], requireAll = false)
//fun textWithHeading(textView: TextView, heading: String?, text: String?) {
//        val headingPart = heading ?: "Default Heading"
//        val textPart = text ?: "No Text"
//        textView.text = "$headingPart: $textPart"
//}