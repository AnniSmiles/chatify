package com.example.chatify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.widget.Button

class UserEditInfo : AppCompatActivity() {
    private lateinit var saveButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit_info)

        saveButton=findViewById(R.id.saveInfo)

        saveButton.setOnClickListener {
            startActivity(Intent(this,NavigationActivity::class.java))
        }
    }
}