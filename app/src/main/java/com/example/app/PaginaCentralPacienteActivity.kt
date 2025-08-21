package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class PaginaCentralPacienteActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_centralpaciente) // seu layout aqui

        //drawerLayout = findViewById(R.id.drawer_layout)
        //navigationView = findViewById(R.id.navigation_view)

        // Ações de clique no menu
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dados -> { /* Abrir tela de Meus Dados */ }
                R.id.nav_medico -> { /* Abrir Fale com seu médico */ }
                R.id.nav_calendario -> { /* Abrir calendário */ }
                R.id.nav_duvidas -> { /* Abrir Chat IA */ }
                R.id.nav_batepapo -> { /* Abrir bate-papo */ }
            }
            drawerLayout.closeDrawers()
            true
        }
    }
}
