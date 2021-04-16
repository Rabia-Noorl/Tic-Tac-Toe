package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashScreen : AppCompatActivity() {

    private var TIME_OUT:Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        animHandler()
        loadSplashScreen()
    }

    private fun loadSplashScreen(){
        Handler().postDelayed({
            // You can declare your desire activity here to open after finishing splash screen. Like MainActivity
            val intent = Intent(this,GameSetUp::class.java)
            startActivity(intent)
            finish()
        },TIME_OUT)
    }
    private fun animHandler() {
        val image: ImageView=findViewById<ImageView>(R.id.strat_logo)
        val sloganGameName = findViewById<TextView>(R.id.sloganGameName)
        val slogen_wellcomeText = findViewById<TextView>(R.id.slogen_wellcomeText)

        val top_Anim: Animation= AnimationUtils.loadAnimation(this, R.anim.top_anim)
        val bottom_Anim: Animation= AnimationUtils.loadAnimation(this, R.anim.bottom_anim)

        image.startAnimation(top_Anim)
        sloganGameName.startAnimation(bottom_Anim)
        slogen_wellcomeText.startAnimation(bottom_Anim)

    }

}