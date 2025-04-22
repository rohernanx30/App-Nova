package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivitySieteBinding

class siete : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivitySieteBinding = ActivitySieteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.siete)

        //cambio de paginas
        binding.next.setOnClickListener {
            next()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.backA.setOnClickListener {
            atras()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }}
    //funciones privadas para mover entre pestañas
    private fun next(){
        var intent = Intent(this,ocho::class.java)
        startActivity(intent)
        finish()
    }
    private fun atras(){
        var intent = Intent(this,seis::class.java)
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}