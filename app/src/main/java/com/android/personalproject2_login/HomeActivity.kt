package com.android.personalproject2_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var btn_exit = findViewById<ConstraintLayout>(R.id.btn_exit)
        btn_exit.setOnClickListener {
            finish()
        }

        var strData = intent.getStringExtra("loginId")
        var textviewId = findViewById<TextView>(R.id.textView3)
        textviewId.setText("아이디 : ${strData}")



        var imageView2 = findViewById<ImageView>(R.id.imageView2)
        val random = Random()
        var randomTier = random.nextInt(9)

        when(randomTier){
            0 -> imageView2.setImageResource(R.drawable.iron)
            1 -> imageView2.setImageResource(R.drawable.bronze)
            2 -> imageView2.setImageResource(R.drawable.silver)
            3 -> imageView2.setImageResource(R.drawable.gold)
            4 -> imageView2.setImageResource(R.drawable.platinum)
            5 -> imageView2.setImageResource(R.drawable.dia)
            6 -> imageView2.setImageResource(R.drawable.master)
            7 -> imageView2.setImageResource(R.drawable.grandmaster)
            8 -> imageView2.setImageResource(R.drawable.challenger)
        }
    }
}