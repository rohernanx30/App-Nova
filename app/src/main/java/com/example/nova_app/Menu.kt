package com.example.nova_app

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nova_app.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    companion object {
        //Asegurarse que si a variable no esta bien escrita de igual forma la identificara
        const val NOMBRE_USUARIO_KEY = "nombre_usuario"
    }
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMenuBinding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bundle:Bundle= intent.extras!!
        var nombre_usuario=bundle.getString(NOMBRE_USUARIO_KEY) ?: ""
        binding.name.text="Hi "+ nombre_usuario

        mediaPlayer = MediaPlayer.create(this, R.raw.menu)
        //agg los binding para moverse
        //familia
        binding.btnMovFamilia.setOnClickListener {
            openfamilia(nombre_usuario)
        }
        //numeros
        binding.btnNumeros.setOnClickListener {
            opennumeros(nombre_usuario)
        }
        //movimiento
        binding.btnMovimiento.setOnClickListener {
            openmovimiento(nombre_usuario)
        }
        //canciones
        binding.btnCanciones.setOnClickListener {
            opensong(nombre_usuario)
        }
        //salir
        binding.btnSalir.setOnClickListener {
            showExitConfirmationDialog()
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
    }
    private fun openmovimiento(nombreUsuario: String) {
        // Detener el audio si está sonando
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
                it.release()
                mediaPlayer = null
            }
        }
        var intent = Intent(this,movimiento_robot::class.java)
        intent.putExtra("nombre_usuario",nombreUsuario)
        startActivity(intent)
    }

    //funciones privadas para mover entre pestañas
    private fun openfamilia(nombreUsuario:String){
        // Detener el audio si está sonando
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
                it.release()
                mediaPlayer = null
            }
        }
        var intent = Intent(this,familia::class.java)
        intent.putExtra("nombre_usuario",nombreUsuario)
        startActivity(intent)
    }
    private fun opennumeros(nombreUsuario:String){
        // Detener el audio si está sonando
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
                it.release()
                mediaPlayer = null
            }
        }
        var intent = Intent(this,numeros::class.java)
        intent.putExtra("nombre_usuario",nombreUsuario)
        startActivity(intent)
    }
    private fun opensong(nombreUsuario:String){
        // Detener el audio si está sonando
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
                it.release()
                mediaPlayer = null
            }
        }
        var intent = Intent(this,canciones::class.java)
        intent.putExtra("nombre_usuario",nombreUsuario)
        startActivity(intent)
    }
    //funcion privada para pestaña de salir
    private fun showExitConfirmationDialog(){
        // Crea un AlertDialog.Builder y configura el mensaje y los botones
        AlertDialog.Builder(this).apply {
            setTitle("Confirmación de salida")
            setMessage("¿Estás seguro de que quieres salir de la aplicación?")
            setPositiveButton("Aceptar") { dialog, which ->
                // Acción al hacer clic en "Aceptar"
                finishAffinity() // Cierra la aplicación
            }
            setNegativeButton("Cancelar") { dialog, which ->
                // Acción al hacer clic en "Cancelar"
                dialog.dismiss() // Cierra el diálogo
            }
            create()
            show()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
    override fun onResume() {
        super.onResume()
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.menu)
        }
    }
}