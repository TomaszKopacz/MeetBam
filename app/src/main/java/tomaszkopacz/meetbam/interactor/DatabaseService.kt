package tomaszkopacz.meetbam.interactor

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import tomaszkopacz.meetbam.entity.Post

class DatabaseService(private val database: FirebaseDatabase) {

    companion object {
        private const val POSTS_REFERENCE = "posts"
    }

    fun getPostsReference(): DatabaseReference {
        return database.getReference(POSTS_REFERENCE)
    }

    fun putPost(post: Post, listener: TaskListener){
        database.getReference(POSTS_REFERENCE).push().setValue(post)
                .addOnCompleteListener{
            when {
                it.isSuccessful -> {
                    listener.onSucceed()
                }

                it.isCanceled -> {
                    listener.onFailed()
                }
            }
        }
    }
}