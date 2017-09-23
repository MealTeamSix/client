package org.chicagosfoodbank.client

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import org.chicagosfoodbank.client.surveys.SurveyListActivity
import java.util.*


class LoginActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()
    val databaseReference = FirebaseDatabase.getInstance().getReference()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (firebaseAuth.currentUser != null) {
            buttonLogin.visibility = View.GONE
            goToSurvey()

            println("Current User: ${firebaseAuth.currentUser.toString()}")
        } else {
            buttonLogin.visibility = View.VISIBLE

            buttonLogin.setOnClickListener {
                firebaseAuth.signInAnonymously().addOnCompleteListener {
                    val task = it
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        println("Sign in success!")
                        goToSurvey()
                    } else {
                        // If sign in fails, display a message to the user.
                        println("Sign in broke!")
                    }
                }
            }
        }

    }

    fun goToSurvey() {
        val currentTime = Date()
        databaseReference.child("AppUsers").child(firebaseAuth.currentUser?.uid).setValue("logged in: $currentTime")
        startActivity(SurveyListActivity.getStartIntent(this))
    }
}
