package tomaszkopacz.meetbam.interactor

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File

class StorageService (private val firebaseStorage: FirebaseStorage) {

    companion object {
        private const val POSTS = "posts"
        private const val AVATARS = "avatars"
    }

    fun uploadPostPhoto(file: File, listener: TaskListener?): String {
        val generalRef = firebaseStorage.reference
        val avatarsRef = generalRef.child("$POSTS/${file.name}")

        avatarsRef.putFile(Uri.fromFile(file))
                .addOnFailureListener { listener?.onFailed() }
                .addOnSuccessListener { listener?.onSucceed() }

        return avatarsRef.path
    }

    fun getReference(url: String): StorageReference {
        return firebaseStorage.reference.child(url)
    }
}