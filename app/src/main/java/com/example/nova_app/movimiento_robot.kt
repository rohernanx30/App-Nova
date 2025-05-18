package com.example.nova_app

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityMovimientoRobotBinding

class movimiento_robot : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMovimientoRobotBinding = ActivityMovimientoRobotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.movimiento)

        //agg los binding para moverse
        binding.inicio.setOnClickListener {
           finish()
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
        //Sonido de los botones de movimiento
        binding.btnAdelante.setOnClickListener {

        }
        binding.btnatras.setOnClickListener {

        }
        binding.btnIzquierda.setOnClickListener {

        }
        binding.btnDerecha.setOnClickListener {

        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()

    }
}