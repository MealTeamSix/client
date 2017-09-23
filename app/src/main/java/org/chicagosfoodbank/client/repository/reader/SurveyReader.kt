package org.chicagosfoodbank.client.repository.reader

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import org.chicagosfoodbank.client.model.Survey

/**
 * Created by nick.cruz on 9/23/17
 */
object SurveyReader : ChildEventListener {

    val surveyMap = mutableMapOf<Int, Survey>()

    override fun onCancelled(databaseError: DatabaseError) {
        // Do nothing
    }

    override fun onChildMoved(dataSnapshot: DataSnapshot, previousChildName: String) {
        // Do nothing
    }

    override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String) {
        // Do nothing
    }

    override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String) {
        val newSurvey = dataSnapshot.getValue(Survey::class.java)
        if (newSurvey is Survey) {
            with (newSurvey) {
                surveyMap[newSurvey.surveyId] = newSurvey
            }
        }
    }

    override fun onChildRemoved(dataSnapshot: DataSnapshot) {
        surveyMap.remove(dataSnapshot.key.toInt())
    }
}