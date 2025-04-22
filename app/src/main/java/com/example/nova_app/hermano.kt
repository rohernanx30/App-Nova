package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityHermanoBinding

class hermano : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        var binding: ActivityHermanoBinding = ActivityHermanoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.brother)

        //Mover entre entre pantallas
        binding.next.setOnClickListener {
            siguiente()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.atras.setOnClickListener {
            atras()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
    }
    //Funciones privadas para cambiar pantallas
    private fun siguiente() {
        var intent= Intent(this,abuela::class.java)
        startActivity(intent)
        finish()
    }
    private fun atras() {
        var intent= Intent(this,hermana::class.java)
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}