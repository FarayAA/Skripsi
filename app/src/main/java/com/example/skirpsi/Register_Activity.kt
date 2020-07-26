package com.example.skirpsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.skirpsi.model.ResponseRegister
import com.example.skirpsi.network.ApiCall
import com.example.skirpsi.network.ApiInterface
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_register_.*
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_)

        btnregis.setOnClickListener {
            requestregister()
        }
    }

    fun requestregister() {
        val nama = RequestBody.create(MediaType.parse("text/plain"), etNama.text.toString())
        val email = RequestBody.create(MediaType.parse("text/plain"), etEmail.text.toString())
        val nohp = RequestBody.create(MediaType.parse("text/plain"), etUsername.text.toString())
        val password = RequestBody.create(MediaType.parse("text/plain"), etPassword.text.toString())
        val jeniskelamin = RequestBody.create(MediaType.parse("text/plain"), etJkelamin.text.toString())
        val apiInterface: ApiInterface = ApiCall().client().create(ApiInterface::class.java)
        val call: Call<ResponseRegister> = apiInterface.daftarUser(nama,email,nohp,password,jeniskelamin)
        call.enqueue(object : Callback<ResponseRegister> {
            override fun onFailure(call: Call<ResponseRegister>?, t: Throwable?) {
                Toast.makeText(applicationContext, "gagal mendaftar", Toast.LENGTH_SHORT).show()
                if (t != null) {
                    Log.i("autolog", "t: " + t.message)

                }
                if (t != null) {
                    Log.i("autolog", "t: " + t.getLocalizedMessage())
                }
            }
            override fun onResponse(call: Call<ResponseRegister>?, response: Response<ResponseRegister>?) {
                if (response != null) {
                    if (response.body()!!.status === true) {
                        val json = Gson().toJson(response)
                        Log.i("autolog", "t: $json")
                        Toast.makeText(this@Register_Activity, "Berhasil Daftar", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@Register_Activity,Login_Activity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@Register_Activity, "Gagal Daftar", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}