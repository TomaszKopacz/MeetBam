package tomaszkopacz.meetbam.view

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class TEST {

    private val auth = FirebaseAuth.getInstance()
    private val activity = LoginActivity()

    private fun test() {
        auth.createUserWithEmailAndPassword("DUPA", "KUPA").addOnCompleteListener(activity) { Toast.makeText(activity, "CYCKI", Toast.LENGTH_LONG).show() }
    }
}
