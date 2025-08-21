package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class TelaLoginPacienteActivity : AppCompatActivity() {

    private lateinit var EmaileditText: EditText
    private lateinit var SenhaeditText: EditText
    private lateinit var botaoLogin: Button
    private lateinit var auth: FirebaseAuth
    private fun login(email: String, senha: String) {
        botaoLogin.isEnabled = false
        auth.signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener(this) { task ->
                botaoLogin.isEnabled = true
                if (task.isSuccessful) {
                    Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    // criar nova tela
                } else {
                    val exception = task.exception
                    if (exception is FirebaseAuthInvalidUserException) {
                        Toast.makeText(
                            this,
                            "Usuário não encontrado. Você não possui uma conta.",
                            Toast.LENGTH_LONG
                        ).show()
                        //val intent = Intent(this, TelaCadastroMedicoActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this,
                            "Falha no login: ${exception?.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
    }

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpaciente)

        EmaileditText = findViewById(R.id.UsuarioPaciente)
        SenhaeditText = findViewById(R.id.SenhaPaciente)
        botaoLogin = findViewById(R.id.buttonLoginPaciente)


        auth = FirebaseAuth.getInstance()

        botaoLogin.setOnClickListener {
            val email = EmaileditText.text.trim().toString()
            val senha = SenhaeditText.text.trim().toString()

            var tudoCerto = true

            if (email.isEmpty()) {
                EmaileditText.error = "Preencha o e-mail"
                tudoCerto = false
            } else if (!isValidEmail(email)) {
                EmaileditText.error = "Email inválido"
                tudoCerto = false
            }

            if (senha.isEmpty()) {
                SenhaeditText.error = "Preencha a senha"
                tudoCerto = false
            } else if (senha.length < 6) {
                SenhaeditText.error = "A senha deve ter no mínimo 6 caracteres"
                tudoCerto = false
            }

            if (tudoCerto) {
                login(email, senha)
            }
        }
    }
}
