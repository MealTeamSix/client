package org.chicagosfoodbank.client.surveys.survey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_survey.*
import org.chicagosfoodbank.client.R
import org.chicagosfoodbank.client.surveys.Survey

class SurveyActivity : AppCompatActivity() {

    companion object {
        val EXTRA_SURVEY = "survey"

        fun getStartIntent(context: Context, survey: Survey) : Intent {
            val intent = Intent(context, SurveyActivity::class.java)
            intent.putExtra(EXTRA_SURVEY, survey)
            return intent
        }
    }

    val fields : List<Pair<String, String>> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        val survey: Survey = intent.getParcelableExtra(EXTRA_SURVEY)

        textViewSurveyTitle.text = survey.name
        survey.fields.forEach {
            val editText : EditText = EditText(this)
            editText.hint = it
            linearLayoutFields.addView(editText)
        }
    }
}
