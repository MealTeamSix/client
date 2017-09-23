package org.chicagosfoodbank.client

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.chicagosfoodbank.client.surveys.SurveyListActivity

class LoginActivity : AppCompatActivity() {

    val basicLogin = BasicLogin()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener {
            basicLogin.setCredentials(editTextUsername.text.toString(), editTextPassword.text.toString())
            if (basicLogin.login()) {
                goToSurvey()
            }
        }
    }

    fun goToSurvey() {
        startActivity(SurveyListActivity.getStartIntent(this))
    }
}
