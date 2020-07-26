package com.example.skirpsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.budiardian.moms.activity.session.SessionManager
import com.example.skirpsi.adapter.DaftarEventAdapter
import com.example.skirpsi.model.*
import com.example.skirpsi.network.ApiCall
import com.example.skirpsi.network.ApiInterface
import com.example.skripsi.adapter.EventListAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyEvent : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapters: DaftarEventAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_event)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.rvevent) as RecyclerView
        recyclerView?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(getApplicationContext())
        recyclerView?.setLayoutManager(layoutManager)
        loadGson()
    }

    private fun loadGson() {

        val session = SessionManager(this)
//        Log.i("autolog", "sm.getLevel(): " + sm.getLevel())
//        val dataLevel=Gson().fromJson<DataLevel>(sm.getLevel(), object : TypeToken<DataLevel>() {}.type)

        var id = session.getId()
        val datacek = intent?.getStringExtra("id").toString()
        var apiInterface: ApiInterface = ApiCall().client().create(ApiInterface::class.java)
        var call = apiInterface.getdaftarevent(id)
        call.enqueue(object : Callback<ResponseGetDaftarEvent> {
            override fun onFailure(call: Call<ResponseGetDaftarEvent>?, t: Throwable?) {
                Toast.makeText(this@MyEvent, "Gagal", Toast.LENGTH_SHORT).show();
                Log.i("autolog", "t: " + t!!.message);
                Log.i("autolog", "t: " + t!!.getLocalizedMessage());
            }

            override fun onResponse(
                call: Call<ResponseGetDaftarEvent>?,
                response: Response<ResponseGetDaftarEvent>?
            ) {
                val anu = Gson().toJson(response)
                Log.d("ANU", anu)
                if (response!!.isSuccessful) {
                    if (response!!.body()!!.status!!) {
                        adapters = DaftarEventAdapter(
                            this,
                            (response!!.body()!!.data as List<DataGetDataEvent>?)!!
                        )

                        val recyclerContacts = findViewById(R.id.rvevent) as RecyclerView
                        recyclerContacts.adapter = adapters
                        recyclerContacts.layoutManager = LinearLayoutManager(this@MyEvent)
                    } else {

                        Toast.makeText(
                            this@MyEvent,
                            "Gagal " + response.message(),
                            Toast.LENGTH_SHORT
                        )
                            .show();

                    }
                } else
                    Toast.makeText(
                        this@MyEvent,
                        "gagal" + response.message(),
                        Toast.LENGTH_SHORT
                    ).show()


            }


        })
    }

}