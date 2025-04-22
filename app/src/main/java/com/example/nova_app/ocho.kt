package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityOchoBinding

class ocho : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityOchoBinding = ActivityOchoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.ocho)

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
        var intent = Intent(this,nueve::class.java)
        startActivity(intent)
        finish()
    }
    private fun atras(){
        var intent = Intent(this,siete::class.java)
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}