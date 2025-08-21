package com.example.app


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Deixa a tela em fullscreen
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        // Usa o layout com o VideoView
        setContentView(R.layout.activity_splash)

        // Conecta o VideoView com o layout
        videoView = findViewById(R.id.abertura)

        // Cria o caminho para o vídeo no res/raw
        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.abertura}")
        videoView.setVideoURI(videoUri)

        // Quando o vídeo terminar, inicia a tela principal
        videoView.setOnCompletionListener {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()  // Finaliza a SplashActivity para que o usuário não volte nela
        }

        // Inicia o vídeo
        videoView.start()
    }
}

