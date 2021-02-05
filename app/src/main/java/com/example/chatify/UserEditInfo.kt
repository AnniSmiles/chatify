package com.example.chatify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UserEditInfo : AppCompatActivity() {
    private lateinit var saveButton: Button
    private lateinit var urlEdit: EditText
    private lateinit var ageEdit: EditText
    private lateinit var nameEdit: EditText
    private lateinit var mAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit_info)

        mAuth= FirebaseAuth.getInstance()
        urlEdit= findViewById(R.id.urlEditText)
        ageEdit= findViewById(R.id.ageEditText)
        nameEdit= findViewById(R.id.nameEditText)

        database=FirebaseDatabase.getInstance().getReference("userEnteredInfo")

        saveButton=findViewById(R.id.saveInfo)

        saveButton.setOnClickListener {
            val name = nameEdit.text.toString()
            val age= ageEdit.text.toString()
            val url = urlEdit.text.toString()
            val info = userEnteredInfo(name, age, url)

            if(mAuth.currentUser?.uid != null){
                database.child(mAuth.currentUser?.uid!!).setValue(info).addOnCompleteListener { task->
                    if(task.isSuccessful){
                        nameEdit.text=null
                        ageEdit.text=null
                        urlEdit.text=null
                        startActivity(Intent(this,NavigationActivity::class.java))


                    }else{
                        Toast.makeText(this,"Failed!!", Toast.LENGTH_SHORT).show()
                    }

                }
            }



        }
    }
}