package org.chicagosfoodbank.client.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.chicagosfoodbank.client.model.Field
import org.chicagosfoodbank.client.model.Survey
import org.chicagosfoodbank.client.repository.reader.SurveyReader

/**
 * Created by nick.cruz on 9/23/17
 */
object FirebaseRepository : SurveyRepository {

    val CLIENT_DATA = "Surveys"

    val currentUser = FirebaseAuth.getInstance().currentUser
    val dbReference : DatabaseReference = FirebaseDatabase.getInstance().getReference(CLIENT_DATA)
    val surveyReader = SurveyReader

    init {
        dbReference.child(Survey.EMPTY_SURVEYS)
                .addChildEventListener(surveyReader)
    }

    override fun uploadSurvey(survey: Survey) {
        Log.v("SurveyResults", "Name: ${survey.name}")
        Log.v("SurveyResults", "Fields:")
        survey.fields.forEach {
            Log.v("SurveyResults", "    ${it.title}, ${it.answer}")
        }

        currentUser?.uid ?: return

        dbReference
                .child(survey.name)
                .child(currentUser.uid)
                .setValue(survey)
    }

    override fun getSurveys(): List<Survey> {
        return listOf(
                Survey(1, "Empty Survey", mutableListOf()),
                Survey(2, "Basic Survey", mutableListOf(
                        Field(21, "Name", ""),
                        Field(22, "Location", ""),
                        Field(23, "Zip Code", ""))),
                Survey(3, "Motivation Survey", mutableListOf(
                        Field(31, "What would make it easier for you to get the food you need?", ""),
                        Field(32, "Any other comments?", "")
                ))
        )
    }
}