package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    companion object {
        var player_turn = 1

        var winner = -1
    }


    private var TIME_OUT:Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN)
        var playerName : String?= intent.getStringExtra("player_name")
        player_turn.setText(playerName)
        animHandler()
    }
    fun buClick(view: View)
    {
       val btnSelected = view as Button
        var cellID = 0
        when (btnSelected.id)
        {
            R.id.bu1 -> cellID=1
            R.id.bu2 -> cellID=2
            R.id.bu3 -> cellID=3
            R.id.bu4 -> cellID=4
            R.id.bu5 -> cellID=5
            R.id.bu6 -> cellID=6
            R.id.bu7 -> cellID=7
            R.id.bu8 -> cellID=8
            R.id.bu9 -> cellID=9

        }
        playGame(cellID, btnSelected)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    private fun playGame(cellID: Int, btnSelected: Button) {
        if (MainActivity.player_turn == 1){
            val mp: MediaPlayer = MediaPlayer.create(this, R.raw.buttonclicksound)
            mp.start()
            btnSelected.setBackgroundColor(Color.WHITE)
            btnSelected.setBackgroundResource(R.drawable.circle)
            player1.add(cellID)
            MainActivity.player_turn = 2
            autoPlay()

        }else{
            btnSelected.setBackgroundColor(Color.WHITE)
            val mp: MediaPlayer = MediaPlayer.create(this, R.raw.buttonclicksound)
            mp.start()
            btnSelected.setBackgroundResource(R.drawable.close)
            player2.add(cellID)
            MainActivity.player_turn = 1
        }
        btnSelected.isEnabled = false

        winnarPlayer()

    }

    private fun winnarPlayer() {
        if(player1.contains(1) && player1.contains(2) && player1.contains(3) ||
            player1.contains(4) && player1.contains(5) && player1.contains(6) ||
            player1.contains(7) && player1.contains(8) && player1.contains(9) ||

            player1.contains(1) && player1.contains(4) && player1.contains(7) ||
            player1.contains(2) && player1.contains(5) && player1.contains(8) ||
            player1.contains(3) && player1.contains(6) && player1.contains(9) ||
            player1.contains(1) && player1.contains(5) && player1.contains(9) ||
            player1.contains(3) && player1.contains(5) && player1.contains(7) )

            {
                MainActivity.winner = 1
            } else if (player2.contains(1) && player2.contains(2) && player2.contains(3) ||
            player2.contains(4) && player2.contains(5) && player2.contains(6) ||
            player2.contains(7) && player2.contains(8) && player2.contains(9) ||
            player2.contains(1) && player2.contains(4) && player2.contains(7) ||

            player2.contains(2) && player2.contains(5) && player2.contains(8) ||
            player2.contains(3) && player2.contains(6) && player2.contains(9) ||
            player2.contains(1) && player2.contains(5) && player2.contains(9) ||
            player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            MainActivity.winner = 2
        }else
        {
            winner = -1
        }
//        if(player2.contains(1) && player1.contains(2) && player1.contains(3))
//        {
//            winner = 2
//        }
//        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
//        {
//            winner = 1
//        }
//        if(player2.contains(4) && player1.contains(5) && player1.contains(6))
//        {
//            winner = 2
//        }
//        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
//        {
//            winner = 1
//        }
//        if(player2.contains(7) && player1.contains(8) && player1.contains(9))
//        {
//            winner = 2
//        }
//        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
//        {
//            winner = 1
//        }
//        if(player2.contains(1) && player1.contains(4) && player1.contains(7))
//        {
//            winner = 2
//        }
//        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
//        {
//            winner = 1
//        }
//        if(player2.contains(2) && player1.contains(5) && player1.contains(8))
//        {
//            winner = 2
//        }
//        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
//        {
//            winner = 1
//        }
//        if(player2.contains(3) && player1.contains(6) && player1.contains(9))
//        {
//            winner = 2
//        }
//        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
//        {
//            winner = 1
//        }
//        if(player2.contains(1) && player1.contains(5) && player1.contains(9))
//        {
//            winner = 2
//        }
//        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
//        {
//            winner = 1
//        }
//        if(player2.contains(3) && player1.contains(5) && player1.contains(7))
//        {
//            winner = 2
//        }

        if (MainActivity.winner == -1)
        {


            Toast.makeText(this, "No one is winner" , Toast.LENGTH_SHORT)
        }

        else
        {
            if (MainActivity.winner == 1)
            {
                var playerName : String?= intent.getStringExtra("player_name")
                Toast.makeText(this, "$playerName is winner!  ", Toast.LENGTH_SHORT).show()
                loadWinnerScreen(playerName)
            } else if (MainActivity.winner == 2)
            {
                Toast.makeText(this, "Computer is winner", Toast.LENGTH_SHORT).show()
                loadWinnerScreen("Computer")
            }

        }
    }
    private fun autoPlay()
    {
        var emptycell = ArrayList<Int>()
        for (cellID in 1..9 )
        {
            if (!(player1.contains(cellID)) && !(player2.contains(cellID)) == true )
            {
                emptycell.add(cellID)

            }

        }
        val r = java.util.Random()
        val randIndx = r.nextInt(emptycell.size - 0)+0
        val cellID = emptycell[randIndx]

        val btnSelected: Button
        when(cellID)
        {
            1 -> btnSelected=bu1
            2 -> btnSelected=bu2
            3 -> btnSelected=bu3
            4 -> btnSelected=bu4
            5 -> btnSelected=bu5
            6 -> btnSelected=bu6
            7 -> btnSelected=bu7
            8 -> btnSelected=bu8
            9 -> btnSelected=bu9
            else -> btnSelected = bu1
        }
        playGame(cellID, btnSelected)

    }
    private fun animHandler() {

        val game_name = findViewById<TextView>(R.id.game_name)
        val player_turn = findViewById<TextView>(R.id.player_turn)
        val yourturn = findViewById<TextView>(R.id.yourturn)

        val game_table = findViewById<TableLayout>(R.id.game_table)

        val top_Anim: Animation= AnimationUtils.loadAnimation(this, R.anim.top_anim)
        val bottom_Anim: Animation= AnimationUtils.loadAnimation(this, R.anim.bottom_anim)

        game_name.startAnimation(top_Anim)
        player_turn.startAnimation(top_Anim)
        yourturn.startAnimation(top_Anim)
        game_table.startAnimation(bottom_Anim)


    }
    private fun loadWinnerScreen( name: String?){
        Handler().postDelayed({
            // You can declare your desire activity here to open after finishing splash screen. Like MainActivity
            val intent = Intent(this,WinnerActivity::class.java)
            intent.putExtra("player_name", name)
            startActivity(intent)
            finish()
        },TIME_OUT)
    }

}

