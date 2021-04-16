package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_winner.*

class WinnerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN)
        var playerName : String?= intent.getStringExtra("player_name")
        val winner_player_name = findViewById<TextView>(R.id.winner_player_name)
        winner_player_name.setText(playerName)
        winnerAnimHandler()
    }

    fun playAgainGame(view: View)
    {
        val intent = Intent(this,GameSetUp::class.java)
        startActivity(intent)
    }
    fun exitGame()
    {
        finish()
    }
        private fun winnerAnimHandler()
    {


        val congraguation_text = findViewById<TextView>(R.id.congraguation_text)
        val winnerLogo: ImageView=findViewById(R.id.winnerLogo)

        val top_Anim: Animation= AnimationUtils.loadAnimation(this, R.anim.top_anim)
        val bottom_Anim: Animation= AnimationUtils.loadAnimation(this, R.anim.bottom_anim)

        winner_player_name.startAnimation(top_Anim)
        congraguation_text.startAnimation(top_Anim)
        winnerLogo.startAnimation(top_Anim)

        ExitGameButton.startAnimation(bottom_Anim)
        PlayAgainBttton.startAnimation(bottom_Anim)

    }

}