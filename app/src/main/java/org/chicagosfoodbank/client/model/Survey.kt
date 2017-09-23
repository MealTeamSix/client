package org.chicagosfoodbank.client.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nick.cruz on 9/23/17
 */
data class Survey(val surveyId: Int,
                  val name: String,
                  val fields: MutableList<Field>) : Parcelable {

    companion object {
        val EMPTY_SURVEYS = "EmptySurveys"
        val FILLED_SURVEYS = "FilledSurveys"

        @JvmField val CREATOR: Parcelable.Creator<Survey> = object : Parcelable.Creator<Survey> {
            override fun createFromParcel(source: Parcel): Survey = Survey(source)
            override fun newArray(size: Int): Array<Survey?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readLong().toInt(),
            source.readString(),
            mutableListOf<Field>()
    ) {
        val numFields = source.readInt()
        for (i in 1..numFields) {
            fields.add(source.readParcelable<Field>(Field::class.java.classLoader))
        }
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(surveyId.toLong())
        dest.writeString(name)
        dest.writeInt(fields.size)
        fields.forEach {
            dest.writeParcelable(it, 0)
        }
    }

}