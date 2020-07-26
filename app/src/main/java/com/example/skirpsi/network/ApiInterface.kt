package com.example.skirpsi.network

import com.example.skirpsi.model.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
//    //untuk Login
    @FormUrlEncoded
    @POST("loginuser")
    fun loginUser(
        @Field("no_hp") no_hp: String,
        @Field("password") password: String
    ): Call<ResponseLogin>
//
//    //mendaftar
    @FormUrlEncoded
//    @Multipart
    @POST("register")
    fun daftarUser(
        @Part("nama_user") nama_user: RequestBody,
        @Part("email") email: RequestBody,
        @Part("no_hp") no_hp: RequestBody,
        @Part("password") password: RequestBody,
        @Part("jenis_kelamin") jenis_kelamin: RequestBody
        // @Part image : MultipartBody.Part

    ): Call<ResponseRegister>

    @FormUrlEncoded
//    @Multipart
    @POST("daftarevent")
    fun daftarEvent(
        @Field("id_event") id_event: String,
        @Field("nama_event") nama_event: String,
        @Field("tanggal") tanggal: String,
        @Field("id_user") id_user: String,
        @Field("nama_user") nama_user: String,
        @Field("no_hp") no_hp: String
        // @Part image : MultipartBody.Part

    ): Call<ResponseDaftarEvent>

//    @Multipart
//    @POST("barang/tambah")
//    fun addProduk(@PartMap param: Map<String, @JvmSuppressWildcards RequestBody>, @Part foto: MultipartBody.Part): Observable<Response<ResponseAkik>>
//
//    @POST("pembayaran/{id}/status/terkonfirmasi")
//    fun updateOrderStatus(@Path("id") id: String): Call<ResponseTambahPemeriksaan>

//    @FormUrlEncoded
//    @POST("cekkesehatan")
//    fun tambahperiksa(
//        @Field("id_moms") id_moms: String,
//        @Field("tgl_pemeriksaan") tgl_pemeriksaan: String,
//        @Field("berat_badan") berat_badan: String,
//        @Field("tekanan_darah") tekanan_darah: String,
//        @Field("tinggi_fundus") tinggi_fundus: String,
//        @Field("denyut_jantung_janin") denyut_jantung_janin: String,
//        @Field("lingkar_lengan_atas") lingkar_lengan_atas: String,
//        @Field("keluhan") keluhan: String
//    ): Call<ResponseTambahPemeriksaan>
//
    @GET("event")
    fun getevent(): Call<ResponseEvent>

    @GET("daftarevent/{id_user}")
    fun getdaftarevent(@Path("id_user")id_user: String):  Call<ResponseGetDaftarEvent>
//
//    @GET("soal/{id}")
//    fun getsoal(@Path("id")id:String): Call<ResponseSoal>
//
//    @GET("soalmateri/{id}")
//    fun getsoalmateri(@Path("id")id:String): Call<ResponseSoalMateri>
//
//    @GET("level")
//    fun getlevel(): Call<ResponseLevel>
//

//    @GET("register")
//    fun getregis(): Call<ResponseIbuHamil>
//
//    @GET("janin")
//    fun getBayi(): Call<ResponseJanin>
//
//    @GET("keluhan")
//    fun getKeluhan(): Call<ResponseKeluhan>
//
//
//    @GET("cekkesehatan/{id}")
//    fun getCek(@Path("id") id: String): Call<ResponseCekKesehatan>
//
//    @GET("submateri/{id}")
//    fun getsubmateri(@Path("id")id: String): Call<ResponseSubmateri>
//
//    @GET("penilaian/{id}")
//    fun getnilai(@Path("id") id: String): Call<ResponsePenilaian>
//
//    @FormUrlEncoded
//    @POST("penilaian")
//    fun addnilaiii(@Header("Content-Type")head:String, @FieldMap param: Map<String,String>
//    ): Call<ResponsePenilaian>

}