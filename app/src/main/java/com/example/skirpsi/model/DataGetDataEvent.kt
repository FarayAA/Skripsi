package com.example.skirpsi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataGetDataEvent(

	@field:SerializedName("no_hp")
	val noHp: String? = null,

	@field:SerializedName("id_event")
	val idEvent: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("id_user")
	val idUser: String? = null,

	@field:SerializedName("nama_user")
	val namaUser: String? = null,

	@field:SerializedName("id_daftarevent")
	val idDaftarevent: String? = null,

	@field:SerializedName("nama_event")
	val namaEvent: String? = null
) : Parcelable