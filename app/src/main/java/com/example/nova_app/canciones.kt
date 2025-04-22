package com.example.nova_app

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityCancionesBinding

class canciones : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var mediaPlayer2: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityCancionesBinding = ActivityCancionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.song_family)
        mediaPlayer2 = MediaPlayer.create(this, R.raw.song_number)

        //agg los binding para moverse
        binding.songFamilia.setOnClickListener {
            mediaPlayer?.start()
        }
        binding.songNumeros.setOnClickListener {
            mediaPlayer2?.start()
        }
        binding.irMenu.setOnClickListener {
            finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer2?.release()
    }
}