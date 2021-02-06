package com.example.chatify

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class PostAdapter(private var posts: List<updatePost>,private var context:Context):
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postImage: ImageView = itemView.findViewById(R.id.iconView)
        var postView: TextView = itemView.findViewById(R.id.postViewText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_list, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val p = posts[position]
        holder.postView.text = p.post
        var snapshotTask = FirebaseDatabase.getInstance().getReference("userEnteredInfo").child(
            FirebaseAuth.getInstance().currentUser?.uid!!
        ).get()
        snapshotTask.addOnSuccessListener {
            var user = it.value

            if (user != null) {
                var info = user as HashMap<String, String>

                Glide.with(context)
                    .load(info["url"])
                    .centerCrop()
                    .into(holder.postImage)


            }
        }


    }

    override fun getItemCount(): Int = posts.size
}

