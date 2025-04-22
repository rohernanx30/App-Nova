package com.example.nova_app

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nova_app.databinding.ActivityBienvenidaBinding

class Bienvenida : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityBienvenidaBinding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.nombre)


        var usuario: EditText =findViewById<EditText>(R.id.nombre_usuario)
        var btnComenzar: Button = findViewById<Button>(R.id.btn_comenzar)

        binding.btnNova.setOnClickListener {
            mediaPlayer?.start()
        }

        btnComenzar.setOnClickListener {

            val nombreUsuario = usuario.text
            if (nombreUsuario.isEmpty()){
                Toast.makeText(this,"Debes de ingresar tu nombre", Toast.LENGTH_SHORT).show()
            }
            else{
                openmenu(nombreUsuario.toString())
            }
        }
    }
    private fun openmenu(nombreUsuario:String){
        var intent = Intent(this,Menu::class.java)
        intent.putExtra("nombre_usuario",nombreUsuario)
        startActivity(intent)
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}