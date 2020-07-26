package com.example.skirpsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.budiardian.moms.activity.session.SessionManager
import kotlinx.android.synthetic.main.activity_profil__user.*

class ProfilUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil__user)
        val session = SessionManager(this)
        val nama_user = session.getNamaUser()
        var email = session.getEmail()
        val no_hp = session.getNoHP()
        val jenis_kelamin = session.getJeniskelamin()

        txnama.text = nama_user
        txemail.text = email
        txnohp.text = no_hp
        txjeniskelamin.text = jenis_kelamin

        btnlogout.setOnClickListener {
            session.logoutUser()
        }

    }
}
