package org.chicagosfoodbank.client.repository

import org.chicagosfoodbank.client.model.Survey

/**
 * Created by nick.cruz on 9/23/17
 */
interface SurveyRepository {
    fun getSurveys() : List<Survey>

    fun uploadSurvey(survey: Survey)
}