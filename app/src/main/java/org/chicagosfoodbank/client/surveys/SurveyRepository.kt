package org.chicagosfoodbank.client.surveys

import org.chicagosfoodbank.client.model.Field
import org.chicagosfoodbank.client.model.Survey

/**
 * Created by nick.cruz on 9/23/17
 */
interface SurveyRepository {
    fun getSurveys() : List<Survey>

    fun uploadSurveyResults(survey: Survey)
}

object SurveyRepositoryImpl : SurveyRepository {

    override fun uploadSurveyResults(survey: Survey) {
        // Do nothing for now
    }

    override fun getSurveys(): List<Survey> {
        return listOf(
                Survey(1, "Empty Survey", mutableListOf()),
                Survey(2, "Basic Survey", mutableListOf(
                        Field(21, "Name", "", "email@example.com"),
                        Field(21, "Location", "", "email@example.com"),
                        Field(21, "Zip Code", "", "email@example.com")
                ))
        )
    }
}