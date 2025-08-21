package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaEscolhaMedicoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolhamedico)

        val botao1 = findViewById<Button>(R.id.buttonLoginMedico)
        botao1.setOnClickListener {
            val intent = Intent(this, TelaLoginMedicoActivity::class.java)
            startActivity(intent)
        }

        val botao2 = findViewById<Button>(R.id.buttonCriarContaMedico)
        botao2.setOnClickListener {
            val intent = Intent(this, TelaCriarContaMedicoActivity::class.java)
            startActivity(intent)
        }
    }
}
