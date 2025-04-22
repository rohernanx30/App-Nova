package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityOneBinding


class one : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityOneBinding = ActivityOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.one)

        //cambio de paginas
        binding.next.setOnClickListener {
            next()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }}
    //funciones privadas para mover entre pestañas
    private fun next(){
        var intent = Intent(this,dos::class.java)
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}