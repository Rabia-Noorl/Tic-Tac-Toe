package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class WinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val palyAgainBtn : Button= findViewById<Button>(R.id.PlayAgainBttton)
        val ExitGameButton : Button = findViewById<Button>(R.id.ExitGameButton)

        palyAgainBtn.setOnClickListener {
            // your code to perform when the user clicks on the button
            Toast.makeText(this, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

    }


}