package com.example.meditation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Story (
    val Image : Int,
    val Name : String?,
    val Description : String?,
    val LongDescription : String? = null
) : Parcelable