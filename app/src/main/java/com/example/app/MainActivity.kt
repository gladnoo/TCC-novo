package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        setContentView(R.layout.activity_main)

        val botao1 = findViewById<Button>(R.id.buttonPaciente)
         botao1.setOnClickListener {
             val intent = Intent(this, TelaEscolhaPacienteActivity::class.java)
            startActivity(intent)
         }

        val botao2 = findViewById<Button>(R.id.buttonMedico)
        botao2.setOnClickListener {
            val intent = Intent(this, TelaEscolhaMedicoActivity::class.java)
             startActivity(intent)
        }
    }
}