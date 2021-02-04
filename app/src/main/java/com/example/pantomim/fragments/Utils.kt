package com.example.pantomim.fragments

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url:String){
    Glide.with(context).load(url).into(this)
}

@BindingAdapter("isVisible")
fun View.isVisible(isVisible:Boolean){
    if(isVisible) this.visibility = View.VISIBLE
    else this.visibility = View.INVISIBLE
}