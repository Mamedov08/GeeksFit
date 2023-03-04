package com.example.geeksfit.ui
import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide



fun Context.showToast(text : String){
    Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(url : String?){
    Glide.with(this.context).load(url).into(this)
}





