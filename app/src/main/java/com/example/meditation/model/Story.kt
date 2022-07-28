package com.example.meditation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Story (  //data!!
    val image : Int, //küçük harf!!!
    val name : String?,
    val description : String?,
    val longDescription : String? = null
) : Parcelable