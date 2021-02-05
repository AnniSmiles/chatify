package com.example.chatify.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.chatify.MainActivity

import com.example.chatify.R
import com.example.chatify.UserEditInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text


class FragmentProfile:Fragment(R.layout.fragment_profile) {
    private lateinit var logOut: Button
    private lateinit var infoChange: Button
    private lateinit var nameChange: TextView
    private lateinit var ageChange: TextView


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
        nameChange=view.findViewById(R.id.viewName)
        ageChange=view.findViewById(R.id.viewAge)

        var snapshotTask = FirebaseDatabase.getInstance().getReference("userEnteredInfo").child(FirebaseAuth.getInstance().currentUser?.uid!!).get()

        snapshotTask.addOnSuccessListener {
            var user = it.value

            if (user != null) {
                var info = user as HashMap<String, String>
                nameChange.text=info["name"]
                ageChange.text=info["age"]


            }
        }
    }

}