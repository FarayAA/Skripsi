package com.example.skirpsi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skirpsi.model.DataEvent
import com.example.skirpsi.model.ResponseEvent
import com.example.skirpsi.network.ApiCall
import com.example.skirpsi.network.ApiInterface
import com.example.skripsi.adapter.EventListAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class User : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapters: EventListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        profil.setOnClickListener {
            val intent = Intent(this, ProfilUser::class.java)
            startActivity(intent)
        }

        initViews()
    }


    private fun initViews() {
        recyclerView = findViewById(R.id.recpemeriksaan) as RecyclerView
        recyclerView?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(getApplicationContext())
        recyclerView?.setLayoutManager(layoutManager)
        loadGson()
    }

    private fun loadGson() {

//        val session = SessionManager(this.requireContext())
//        Log.i("autolog", "sm.getLevel(): " + sm.getLevel())
//        val dataLevel=Gson().fromJson<DataLevel>(sm.getLevel(), object :TypeToken<DataLevel>() {}.type)

//        var id = session.getId()
        val datacek = intent?.getStringExtra("id").toString()
        var apiInterface: ApiInterface = ApiCall().client().create(ApiInterface::class.java)
        var call = apiInterface.getevent()
        call.enqueue(object : Callback<ResponseEvent> {
            override fun onFailure(call: Call<ResponseEvent>?, t: Throwable?) {
                Toast.makeText(this@User, "Gagal", Toast.LENGTH_SHORT).show();
                Log.i("autolog", "t: " + t!!.message);
                Log.i("autolog", "t: " + t!!.getLocalizedMessage());
            }

            override fun onResponse(
                call: Call<ResponseEvent>?,
                response: Response<ResponseEvent>?
            ) {
                val anu = Gson().toJson(response)
                Log.d("ANU", anu)
                if (response!!.isSuccessful) {
                    if (response!!.body()!!.status!!) {
                        adapters = EventListAdapter(
                            this,
                            (response!!.body()!!.data as List<DataEvent>?)!!
                        )

                        val recyclerContacts = findViewById(R.id.recpemeriksaan) as RecyclerView
                        recyclerContacts.adapter = adapters
                        recyclerContacts.layoutManager = LinearLayoutManager(this@User)
                    } else {

                        Toast.makeText(
                            this@User,
                            "Gagal " + response.message(),
                            Toast.LENGTH_SHORT
                        )
                            .show();

                    }
                } else
                    Toast.makeText(
                        this@User,
                        "gagal" + response.message(),
                        Toast.LENGTH_SHORT
                    ).show()


            }


        })
    }

}
