package tomaszkopacz.meetbam.interactor

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class StorageService (private val firebaseStorage: FirebaseStorage) {

    companion object {
        private const val AVATARS = "avatars"
    }

    fun uploadFile(file: File, listener: TaskListener): String {
        val generalRef = firebaseStorage.reference
        val avatarsRef = generalRef.child("$AVATARS/${file.name}")

        avatarsRef.putFile(Uri.fromFile(file))
                .addOnFailureListener { listener.onFailed() }
                .addOnSuccessListener { listener.onSucceed() }

        return avatarsRef.path
    }

}