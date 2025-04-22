package com.example.nova_app

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityMovimientoRobotBinding

class movimiento_robot : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var mediaPlayer1: MediaPlayer? = null
    var mediaPlayer2: MediaPlayer? = null
    var mediaPlayer3: MediaPlayer? = null
    var mediaPlayer4: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMovimientoRobotBinding = ActivityMovimientoRobotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.movimiento)
        mediaPlayer1 = MediaPlayer.create(this, R.raw.adelante)
        mediaPlayer2 = MediaPlayer.create(this, R.raw.atras)
        mediaPlayer3 = MediaPlayer.create(this, R.raw.derecha)
        mediaPlayer4 = MediaPlayer.create(this, R.raw.izquierda)

        //agg los binding para moverse
        binding.inicio.setOnClickListener {
           finish()
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
        //Sonido de los botones de movimiento
        binding.arriba.setOnClickListener {
            mediaPlayer1?.start()
        }
        binding.abajo.setOnClickListener {
            mediaPlayer2?.start()
        }
        binding.derecha.setOnClickListener {
            mediaPlayer3?.start()
        }
        binding.izquierda.setOnClickListener {
            mediaPlayer4?.start()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer2?.release()
        mediaPlayer1?.release()
        mediaPlayer3?.release()
        mediaPlayer4?.release()
    }
}