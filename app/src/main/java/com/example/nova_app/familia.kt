package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityFamiliaBinding

class familia : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityFamiliaBinding = ActivityFamiliaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.categoria_familia)

        //cambio de paginas
        binding.btnComenzarLeccion.setOnClickListener {
            openmama()
            finish()
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }}
        //funciones privadas para mover entre pestañas
        private fun openmama(){
            var intent = Intent(this,mama::class.java)
            startActivity(intent)
        }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}