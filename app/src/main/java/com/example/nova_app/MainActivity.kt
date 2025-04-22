package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.bienvenida)

        binding.btnInicio.setOnClickListener {
            openBienvenida()
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
    }

    private fun openBienvenida(){
        var intent = Intent(this,Bienvenida::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}
