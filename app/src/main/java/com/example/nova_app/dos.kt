package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityDosBinding

class dos : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityDosBinding = ActivityDosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.two)

        //cambio de paginas
        binding.next.setOnClickListener {
            next()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.back.setOnClickListener {
            atras()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }}
    //funciones privadas para mover entre pestañas
    private fun next(){
        var intent = Intent(this,tres::class.java)
        startActivity(intent)
        finish()
    }
    private fun atras(){
        var intent = Intent(this,one::class.java)
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}