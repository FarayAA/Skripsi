package com.example.skirpsi

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.budiardian.moms.activity.session.SessionManager
import com.example.skirpsi.model.DataEvent
import com.example.skirpsi.model.ResponseDaftarEvent
import com.example.skirpsi.model.ResponseEvent
import com.example.skirpsi.model.ResponseRegister
import com.example.skirpsi.network.ApiCall
import com.example.skirpsi.network.ApiInterface
import com.example.skripsi.adapter.EventListAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail__event.*
import kotlinx.android.synthetic.main.activity_profil__user.*
import kotlinx.android.synthetic.main.activity_register_.*
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Detail_Event : AppCompatActivity() {

    var event: DataEvent? = null
//    var imagee: ImageView? = null

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail__event)
        event = intent.getParcelableExtra(Detail_Event.EXTRA_MOVIE)
        getMovieData(
            event!!.idEvent.toString(),
            event!!.namaEvent!!.toString(),
            event!!.deskripsi!!.toString(),
            event!!.tanggal!!.toString()
        )
        joinevnt.setOnClickListener {
            requestdaftar()
        }
//        val actionBar = supportActionBar
//        actionBar!!.title = "Detail Keluhan"
//        actionBar.setDisplayHomeAsUpEnabled(true)
//        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    private fun getMovieData(idevent: String, judul: String, deskripsi: String, tanggal: String) {

        txid.text = idevent
        txjdl.text = judul
        txdesk.text = deskripsi
        txtgl.text = tanggal
//        Glide.with(this).load(ApiCall.ImageUrl + image).into(imagedetailkeluhan)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun requestdaftar() {
//        val nama = RequestBody.create(MediaType.parse("text/plain"), etNama.text.toString())
//        val email = RequestBody.create(MediaType.parse("text/plain"), etEmail.text.toString())
//        val nohp = RequestBody.create(MediaType.parse("text/plain"), etUsername.text.toString())
//        val password = RequestBody.create(MediaType.parse("text/plain"), etPassword.text.toString())
//        val jeniskelamin = RequestBody.create(MediaType.parse("text/plain"), etJkelamin.text.toString())
        val session = SessionManager(this)
        val apiInterface: ApiInterface = ApiCall().client().create(ApiInterface::class.java)
        val call: Call<ResponseDaftarEvent> = apiInterface.daftarEvent(txid.text.toString(),txjdl.text.toString(),txtgl.text.toString(),
            session.getId(),session.getNamaUser(),session.getNoHP())
        call.enqueue(object : Callback<ResponseDaftarEvent> {
            override fun onFailure(call: Call<ResponseDaftarEvent>?, t: Throwable?) {
                Toast.makeText(applicationContext, "gagal mendaftar", Toast.LENGTH_SHORT).show()
                if (t != null) {
                    Log.i("autolog", "t: " + t.message)

                }
                if (t != null) {
                    Log.i("autolog", "t: " + t.getLocalizedMessage())
                }
            }
            override fun onResponse(call: Call<ResponseDaftarEvent>?, response: Response<ResponseDaftarEvent>?) {
                if (response != null) {
                    if (response.body()!!.status === true) {
                        val json = Gson().toJson(response)
                        Log.i("autolog", "t: $json")
                        Toast.makeText(this@Detail_Event, "Berhasil Daftar", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@Detail_Event,MyEvent::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@Detail_Event, "Gagal Daftar", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

}
