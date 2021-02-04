package com.example.chatify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var registerButton: Button
    private lateinit var sign: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerButton = findViewById(R.id.registrationButton)
        sign = findViewById(R.id.signupButton)

        registerButton.setOnClickListener {
            startActivity(Intent(this,RegistrationActivity::class.java))
        }
        sign.setOnClickListener {
            startActivity(Intent(this,NavigationActivity::class.java))
        }


    }
}