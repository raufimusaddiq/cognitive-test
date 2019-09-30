package com.hepicar.listeneverything.model

import android.os.Parcel
import android.os.Parcelable

class NBack(var timestampString: Long) : Parcelable {
    var value: Int = 0
    var testCode : Int = 0

    constructor(parcel: Parcel) : this(parcel.readLong()) {
        value = parcel.readInt()
        testCode = parcel.readInt()
    }

    override fun toString(): String {
        return "timestamp:$timestampString , value:$value, test_code:$testCode\n"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(timestampString)
        parcel.writeInt(value)
        parcel.writeInt(testCode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NBack> {
        override fun createFromParcel(parcel: Parcel): NBack {
            return NBack(parcel)
        }

        override fun newArray(size: Int): Array<NBack?> {
            return arrayOfNulls(size)
        }
    }
}