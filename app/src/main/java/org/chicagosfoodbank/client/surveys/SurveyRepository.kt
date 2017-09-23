package org.chicagosfoodbank.client.surveys

import android.util.Log
import org.chicagosfoodbank.client.model.Field
import org.chicagosfoodbank.client.model.Survey

/**
 * Created by nick.cruz on 9/23/17
 */
interface SurveyRepository {
    fun getSurveys() : List<Survey>

    fun uploadSurvey(survey: Survey)
}

object SurveyRepositoryImpl : SurveyRepository {

    override fun uploadSurvey(survey: Survey) {
        // Print for now
        Log.v("SurveyResults", "Name: ${survey.name}")
        Log.v("SurveyResults", "Fields:")
        survey.fields.forEach {
            Log.v("SurveyResults", "    ${it.title}, ${it.answer}")
        }
    }

    override fun getSurveys(): List<Survey> {
        return listOf(
                Survey(1, "Empty Survey", mutableListOf()),
                Survey(2, "Basic Survey", mutableListOf(
                        Field(21, "Name", "Empty", "email@example.com"),
                        Field(22, "Location", "Empty", "email@example.com"),
                        Field(23, "Zip Code", "Empty", "email@example.com")
                ))
        )
    }
}