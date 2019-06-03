package com.example.basketballscore.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Puntuacion_table")
data class ContadorP(
    var grupo1: String,
    var grupo2: String,
    var puntuacion1: Int,
    var puntuacion2: Int,
    var date: String,
    var time: String,
    var ganador: String
): Parcelable
{
    @PrimaryKey(autoGenerate = true) var id : Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
        id = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(grupo1)
        parcel.writeString(grupo2)
        parcel.writeInt(puntuacion1)
        parcel.writeInt(puntuacion2)
        parcel.writeString(date)
        parcel.writeString(time)
        parcel.writeString(ganador)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContadorP> {
        override fun createFromParcel(parcel: Parcel): ContadorP {
            return ContadorP(parcel)
        }

        override fun newArray(size: Int): Array<ContadorP?> {
            return arrayOfNulls(size)
        }
    }
}