package com.example.luissancar.imageviewurl

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import android.os.AsyncTask
import android.widget.ImageView
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { pulsar() }
   }
    fun getBitmapFromURL(imgUrl: String): Bitmap? {
        try {
            val url = URL(imgUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.setDoInput(true)
            connection.connect()
            val input = connection.getInputStream()
            return BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            // Log exception
            return null
        }

    }

    fun pulsar() {
        imageView.loadUrl("https://lh6.googleusercontent.com/-Ew2vNI6UA0g/AAAAAAAAAAI/AAAAAAAAAIM/ScssuBTSU5M/photo.jpg?sz=32")



        //imageView.setImageBitmap(getBitmapFromURL("https://lh6.googleusercontent.com/-Ew2vNI6UA0g/AAAAAAAAAAI/AAAAAAAAAIM/ScssuBTSU5M/photo.jpg?sz=32"))

    }

    // Es necesario añadir la libreria Picasso en :
    // build.gradle (Module: app)
    // compile 'com.squareup.picasso:picasso:2.5.0'
    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }

}
