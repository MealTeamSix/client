package org.chicagosfoodbank.client.surveys

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_survey_list.*
import org.chicagosfoodbank.client.R
import org.chicagosfoodbank.client.model.Survey
import org.chicagosfoodbank.client.surveys.survey.SurveyActivity

class SurveyListActivity : AppCompatActivity(), SurveyAdapter.SurveyAdapterListener {

    val surveyRepository : SurveyRepository = SurveyRepositoryImpl

    companion object {
        fun getStartIntent(context: Context) : Intent {
            return Intent(context, SurveyListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_list)

        val surveyAdapter = SurveyAdapter(this, this)

        surveyAdapter.surveys = surveyRepository.getSurveys()

        recyclerViewSurveys.adapter = surveyAdapter
        recyclerViewSurveys.layoutManager = LinearLayoutManager(this)
    }

    override fun onSurveyClicked(survey: Survey) {
        startActivity(SurveyActivity.getStartIntent(this, survey))
    }
}
