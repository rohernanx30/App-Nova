package com.example.nova_app

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityCancionesBinding

class canciones : AppCompatActivity() {
    private var currentPlayer: MediaPlayer? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = ActivityCancionesBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Botón para reproducir canción de familia
            binding.songFamilia.setOnClickListener {
                playAudio(R.raw.song_family)
            }

            // Botón para reproducir canción de números
            binding.songNumeros.setOnClickListener {
                playAudio(R.raw.song_number)
            }

            // Botón para volver al menú
            binding.irMenu.setOnClickListener {
                finish()
            }
        }

        private fun playAudio(resId: Int) {
            // Detener el audio actual si se está reproduciendo
            currentPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
                it.release()
            }

            // Crear y reproducir el nuevo audio
            currentPlayer = MediaPlayer.create(this, resId)
            currentPlayer?.start()
        }

        override fun onPause() {
            super.onPause()
            // Detener el audio si se cambia de pantalla
            currentPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
                it.release()
            }
            currentPlayer = null
        }
}
