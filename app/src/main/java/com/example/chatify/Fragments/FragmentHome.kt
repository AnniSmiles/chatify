package com.example.chatify.Fragments


// import android.os.Bundle
// import android.widget.Button
// import android.widget.EditText
import androidx.fragment.app.Fragment
// import androidx.recyclerview.widget.LinearLayoutManager
// import androidx.recyclerview.widget.RecyclerView
// import com.example.chatify.PostAdapter
import com.example.chatify.R
// import com.example.chatify.updatePost
// import com.google.firebase.auth.FirebaseAuth
// import com.google.firebase.database.FirebaseDatabase
// import java.util.ArrayList

class FragmentHome:Fragment(R.layout.fragment_home) {
//     private lateinit var recyclerView: RecyclerView
//     private lateinit var postTyped: EditText
//     private lateinit var postButton: Button
//     private lateinit var database: FirebaseDatabase
//     private lateinit var mAuth: FirebaseAuth
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         postTyped = requireView().findViewById(R.id.postEditText)
//         recyclerView= requireView().findViewById(R.id.recycle)
//         postButton = requireView().findViewById(R.id.postButton)
//         mAuth= FirebaseAuth.getInstance()
//         database=FirebaseDatabase.getInstance()
//         // ToDo i cant add getReference("updatePost") because of error, hence no new hash map will be created in database




//        postButton.setOnClickListener {
//            var snapshotTask = FirebaseDatabase.getInstance().getReference("updatePost").child(
//                FirebaseAuth.getInstance().currentUser?.uid!!
//            ).get()

//            snapshotTask.addOnSuccessListener {
//                var user = it.value
//                var postList = ArrayList<updatePost>()

//                if (user != null) {
//                    var info = user as HashMap<String, String>
//                    var userP = info["post"]
//                    var url = info["urlView"]

//                    postList.add(updatePost(post = userP,urlView = url))

//                }
//                val adapter = PostAdapter(postList)
//                recyclerView.layoutManager = LinearLayoutManager(activity)
//                recyclerView.adapter = adapter
//            }
//        }






//     }
}
