package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buClick (view: View )
    {
       val btnSelected = view as Button
        // var btnSelected = view as Button
        var cellID = 0
        when (btnSelected.id)
        {
            R.id.bu1 -> cellID =1
            R.id.bu2 -> cellID =2
            R.id.bu3 -> cellID =3
            R.id.bu4 -> cellID =4
            R.id.bu5 -> cellID =5
            R.id.bu6 -> cellID =6
            R.id.bu7 -> cellID =7
            R.id.bu8 -> cellID =9
            R.id.bu9 -> cellID =8

        }
        Toast.makeText(this, "Cell ID$cellID", Toast.LENGTH_LONG).show()

    }
}