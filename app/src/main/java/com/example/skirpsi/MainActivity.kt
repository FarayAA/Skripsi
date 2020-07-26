package com.example.skirpsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btevn.setOnClickListener {
            val intent = Intent(this, User::class.java)
            startActivity(intent)
        }

        btmvn.setOnClickListener {
            val intent = Intent(this, MyEvent::class.java)
            startActivity(intent)
        }
    }
}
