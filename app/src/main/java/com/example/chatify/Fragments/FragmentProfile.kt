package com.example.chatify.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.chatify.MainActivity

import com.example.chatify.R
import com.example.chatify.UserEditInfo
import com.google.firebase.auth.FirebaseAuth


class FragmentProfile:Fragment(R.layout.fragment_profile) {
    private lateinit var logOut: Button
    private lateinit var infoChange: Button

    private lateinit var mAuth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logOut=view.findViewById(R.id.logOutButton)
        infoChange=view.findViewById(R.id.changeinfoButton)

        mAuth= FirebaseAuth.getInstance()

        infoChange.setOnClickListener {
            startActivity(Intent(activity, UserEditInfo::class.java))
        }
        logOut.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(activity,MainActivity::class.java))
        }


    }

}