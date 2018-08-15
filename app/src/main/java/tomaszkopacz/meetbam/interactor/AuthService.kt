package tomaszkopacz.meetbam.interactor

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthService(private val auth: FirebaseAuth) {

    fun loginUser(mail: String, password: String, listener: TaskListener?) {
        auth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener {
                    when {
                        it.isSuccessful -> {
                            listener?.onSucceed()
                        }

                        else -> {
                            listener?.onFailed()
                        }
                    }
                }
    }

    fun registerUser(mail: String, password: String, listener: TaskListener?) {
        auth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener {

                    when {
                        it.isSuccessful -> {
                            listener?.onSucceed()
                        }

                        else -> {
                            listener?.onFailed()
                        }
                    }
                }
    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun logout() {
        auth.signOut()
    }
}