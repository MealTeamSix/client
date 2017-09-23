package org.chicagosfoodbank.client.survey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_survey.*
import org.chicagosfoodbank.client.R

class SurveyListActivity : AppCompatActivity(), SurveyAdapter.SurveyAdapterListener {

    val surveyRepository = SurveyRepositoryImpl()

    companion object {
        fun getStartIntent(context: Context) : Intent {
            return Intent(context, SurveyListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        val surveyAdapter = SurveyAdapter(this, this)

        surveyAdapter.surveys = surveyRepository.getSurveys()

        recyclerViewSurveys.adapter = surveyAdapter
        recyclerViewSurveys.layoutManager = LinearLayoutManager(this)
    }

    override fun onSurveyClicked(survey: Survey) {
        Toast.makeText(this, "survey Clicked: ${survey.name}", Toast.LENGTH_LONG).show()
    }
}
