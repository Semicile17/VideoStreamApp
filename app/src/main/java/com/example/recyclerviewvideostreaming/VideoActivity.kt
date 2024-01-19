package com.example.recyclerviewvideostreaming

import android.content.Intent
import android.media.browse.MediaBrowser.MediaItem
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class VideoActivity : AppCompatActivity() {
    private lateinit var exoplayer:ExoPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_video)
        var videoUrl = intent.getStringExtra("videoSource")
        val bClose = findViewById<ImageView>(R.id.bClose)
        val playerview =findViewById<StyledPlayerView>(R.id.playerView)
        bClose.setOnClickListener{
            exoplayer.stop()
            exoplayer.release()
            val kit= Intent(this,MainActivity::class.java)
            startActivity(kit)
        }
        //building the exoplayer
         exoplayer=ExoPlayer.Builder(this).build()
        playerview.player = exoplayer


        exoplayer.setMediaItem(com.google.android.exoplayer2.MediaItem.fromUri((Uri.parse(videoUrl))))
        exoplayer.prepare()
        exoplayer.play()


    }

    override fun onStop() {
        super.onStop()
        exoplayer.stop()
        exoplayer.release()
        Log.i("MYTAG", "yeah")
    }
}