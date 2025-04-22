package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityMamaBinding

class mama : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        var binding:ActivityMamaBinding= ActivityMamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.mom)

        //Mover entre entre pantallas
        binding.next.setOnClickListener {
            siguiente()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
    }
    //Funciones privadas para cambiar pantallas
    private fun siguiente() {
        var intent= Intent(this,papa::class.java)
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}
