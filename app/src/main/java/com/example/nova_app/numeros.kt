package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityFamiliaBinding
import com.example.nova_app.databinding.ActivityNumerosBinding

class numeros : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityNumerosBinding = ActivityNumerosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.numbers_categoria)

        //cambio de paginas
        binding.btnComenzarLeccion.setOnClickListener {
            openone()
            finish()
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }}
    //funciones privadas para mover entre pestañas
    private fun openone(){
        var intent = Intent(this,one::class.java)
        startActivity(intent)
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}