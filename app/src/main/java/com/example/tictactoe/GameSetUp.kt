package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_set_up.*

class GameSetUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_set_up)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

//        val turnsArr = arrayOf("First Turn", "Second Turn")
//        val adapter = ArrayAdapter<String>(this, R.layout.turn_selection_layout, turnsArr)
//        selectturntext.setAdapter(adapter)

    }

    fun GoMainActivity(view: View)
    {
        val intent = Intent(this, MainActivity::class.java)
        val playerName = WriteNameEditText.text.toString()
        if (playerName.isBlank())
        {
            Toast.makeText(this, "Name field cannot be empty " , Toast.LENGTH_SHORT).show()

        }else
        {
            intent.putExtra("player_name", playerName)
            startActivity(intent)
            finish()
        }

    }
}