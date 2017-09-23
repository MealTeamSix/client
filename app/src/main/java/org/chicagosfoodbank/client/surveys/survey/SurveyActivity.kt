package org.chicagosfoodbank.client.surveys.survey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_survey.*
import org.chicagosfoodbank.client.R
import org.chicagosfoodbank.client.model.Field
import org.chicagosfoodbank.client.model.Survey
import org.chicagosfoodbank.client.surveys.SurveyRepository
import org.chicagosfoodbank.client.surveys.SurveyRepositoryImpl

class SurveyActivity : AppCompatActivity() {

    companion object {
        val EXTRA_SURVEY = "survey"

        fun getStartIntent(context: Context, survey: Survey) : Intent {
            val intent = Intent(context, SurveyActivity::class.java)
            intent.putExtra(EXTRA_SURVEY, survey)
            return intent
        }
    }

    lateinit var survey: Survey
    val surveyRepository : SurveyRepository = SurveyRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        survey = intent.getParcelableExtra(EXTRA_SURVEY)

        setUpSurvey()

        buttonSubmit.setOnClickListener { upload() }
    }

    private fun setUpSurvey() {
        textViewSurveyTitle.text = survey.name
        survey.fields.forEach {
            val editText : EditText = LayoutInflater.from(this).inflate(R.layout.edit_text_field, null, false) as EditText
            editText.hint = it.title
            linearLayoutFields.addView(editText)

            editText.tag = it
        }
    }

    private fun upload() {
        survey.fields.clear()

        for (i in 1..linearLayoutFields.childCount) {
            val childEditText = linearLayoutFields.getChildAt(i)
            if (childEditText is EditText) {
                val newField = childEditText.tag
                if (newField is Field) {
                    with (newField) {
                        survey.fields.add(Field(
                                fieldId,
                                title,
                                childEditText.text.toString(),
                                email))
                    }
                }
            }
        }

        surveyRepository.uploadSurvey(survey)
    }
}
