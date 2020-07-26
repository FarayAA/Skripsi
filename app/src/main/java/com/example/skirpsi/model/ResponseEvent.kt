package com.example.skirpsi.model

import com.google.gson.annotations.SerializedName

data class ResponseEvent(

	@field:SerializedName("data")
	val data: List<DataEvent?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)