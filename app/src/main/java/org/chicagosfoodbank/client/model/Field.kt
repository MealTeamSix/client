package org.chicagosfoodbank.client.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nick.cruz on 9/23/17
 */
data class Field(
        val fieldId: Int,
        val title: String,
        val answer: String) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Field> = object : Parcelable.Creator<Field> {
            override fun createFromParcel(source: Parcel): Field = Field(source)
            override fun newArray(size: Int): Array<Field?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readLong().toInt(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(fieldId.toLong())
        dest.writeString(title)
        dest.writeString(answer)
    }
}
