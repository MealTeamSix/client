package org.chicagosfoodbank.client.surveys

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nick.cruz on 9/23/17.
 */
data class Survey(val surveyId: Int,
                  val name: String,
                  val fields: List<String>) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Survey> = object : Parcelable.Creator<Survey> {
            override fun createFromParcel(source: Parcel): Survey = Survey(source)
            override fun newArray(size: Int): Array<Survey?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readLong().toInt(),
            source.readString(),
            mutableListOf()
    ) {
        source.readStringList(fields)
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(surveyId.toLong())
        dest.writeString(name)
        dest.writeStringList(fields)
    }

}