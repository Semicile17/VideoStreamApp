package com.example.recyclerviewvideostreaming

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewvideostreaming.R.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        recyclerView = findViewById<RecyclerView>(id.recycleView)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(datalist,this){ selectedItem :dataList ->

            listItemClicked(selectedItem)
        }



    }
    fun listItemClicked(video:dataList){
        val intent= Intent(this,VideoActivity::class.java)
        intent.putExtra("videoSource",video.vSource)
        Log.i("MYTAG", video.vSource)
        startActivity(intent)
    }

}