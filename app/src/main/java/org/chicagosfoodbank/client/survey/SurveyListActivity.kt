package org.chicagosfoodbank.client.survey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.chicagosfoodbank.client.R

class SurveyListActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) : Intent {
            return Intent(context, SurveyListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
    }
}
