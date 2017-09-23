package org.chicagosfoodbank.client.survey

/**
 * Created by nick.cruz on 9/23/17
 */
interface SurveyRepository {
    fun getSurveys() : List<Survey>
}

class SurveyRepositoryImpl : SurveyRepository {

    override fun getSurveys(): List<Survey> {
        return listOf(
                Survey(1, "Food Insecurity Survey"),
                Survey(2, "Basic Survey")
        )
    }
}