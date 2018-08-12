package tomaszkopacz.meetbam.interactor

import com.google.firebase.database.FirebaseDatabase
import tomaszkopacz.meetbam.entity.Post

class DatabaseService(private val database: FirebaseDatabase) {

    companion object {
        private const val POSTS_REFERENCE = "posts"
    }

    fun putPost(post: Post){
        database.getReference(POSTS_REFERENCE).push().setValue(post)
    }
}