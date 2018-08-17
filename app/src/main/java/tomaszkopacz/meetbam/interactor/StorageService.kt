package tomaszkopacz.meetbam.interactor

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File

class StorageService (private val firebaseStorage: FirebaseStorage) {

    companion object {
        private const val POSTS_PHOTOS = "posts"
        private const val PROFILE_PHOTOS = "profile"
    }

    fun uploadPostPhoto(file: File, listener: TaskListener?): String {
        val generalRef = firebaseStorage.reference
        val photoRef = generalRef.child("$POSTS_PHOTOS/${file.name}")

        photoRef.putFile(Uri.fromFile(file))
                .addOnFailureListener { listener?.onFailed() }
                .addOnSuccessListener { listener?.onSucceed() }

        return photoRef.path
    }

    fun uploadProfilePhoto(file: File, listener: TaskListener?): String{
        val generalRef = firebaseStorage.reference
        val photoRef = generalRef.child("$PROFILE_PHOTOS/${file.name}")

        photoRef.putFile(Uri.fromFile(file))
                .addOnFailureListener { listener?.onFailed() }
                .addOnSuccessListener { listener?.onSucceed() }

        return photoRef.path
    }

    fun getReference(url: String): StorageReference {
        return firebaseStorage.reference.child(url)
    }
}