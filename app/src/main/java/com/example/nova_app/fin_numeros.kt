package com.example.nova_app

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityFinNumerosBinding

class fin_numeros : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityFinNumerosBinding = ActivityFinNumerosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.fin_numeros)

        //agg los binding para moverse

        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
        binding.btnIrMenu.setOnClickListener {
            finish()
        }
    }
    //funciones privadas para mover entre pestañas
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}