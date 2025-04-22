package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityFinFamiliaBinding

class fin_familia : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityFinFamiliaBinding = ActivityFinFamiliaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.fin_familia)

        //agg los binding para moverse

        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
        binding.irMenu.setOnClickListener {
            finish()
        }
    }
    //funciones privadas para mover entre pestañas
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}