package tomaszkopacz.meetbam.interactor

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser

class AuthService(private val auth: FirebaseAuth) {

    fun loginUser(mail: String, password: String, listener: LoginListener?){
        auth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener{
                    if (listener != null)
                        when {
                            it.isSuccessful -> {
                                listener.loginSucceed()
                            }

                            else -> {
                                listener.loginFailed()
                            }
                        }
                }
    }

    fun registerUser(mail: String, password: String, listener: RegisterListener?){
        auth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener {
                    if (listener != null)
                        when {
                            it.isSuccessful -> {
                                listener.registerSucceed()
                            }

                            it.exception is FirebaseAuthUserCollisionException -> {
                                listener.mailIsOccupied()
                            }

                            else -> {
                                listener.registerFailed()
                            }
                        }
                }
    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun logout(){
        auth.signOut()
    }
}