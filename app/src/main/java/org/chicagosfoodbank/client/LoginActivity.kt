package org.chicagosfoodbank.client

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*



class LoginActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()

    val basicLogin = BasicLogin()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (firebaseAuth.currentUser != null) {
            buttonLogin.visibility = View.GONE

            println("Current User: ${firebaseAuth.currentUser.toString()}")
        } else {
            buttonLogin.visibility = View.VISIBLE

            buttonLogin.setOnClickListener {
                firebaseAuth.signInAnonymously().addOnCompleteListener {
                    val task = it
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        println("Sign in success!")
                        val user = firebaseAuth.getCurrentUser()
                        goToSurvey()
                    } else {
                        // If sign in fails, display a message to the user.
                        println("Sign in broke!")
                    }
                }
//                basicLogin.setCredentials(editTextUsername.text.toString(), editTextPassword.text.toString())
//                if (basicLogin.login()) {
//                    goToSurvey()
//                }
            }
        }

    }

    fun goToSurvey() {
        Toast.makeText(this, "login", Toast.LENGTH_LONG).show()
    }
}
