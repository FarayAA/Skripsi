package com.example.skirpsi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseUsers(

    @field:SerializedName("data")
	val data: List<DataUsers?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Boolean? = null
) : Parcelable