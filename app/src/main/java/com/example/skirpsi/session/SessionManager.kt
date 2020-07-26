package com.budiardian.moms.activity.session

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.skirpsi.Login_Activity
import com.example.skirpsi.MainActivity

class
SessionManager(val contextK: Context) {
    val key_name = "username"
    val id_level = "level"
//    val id_materi = "materi"
//    val id_submateri = "submateri"
//    val id_modul = "modul"


    private val pref_name = "Admin"
    private val is_login = "islogin"

    internal var pref: SharedPreferences? = null
    internal var editor: SharedPreferences.Editor? = null
    internal var context: Context? = null
    internal var mode = 0

    init {
        this.context = contextK
        pref = context!!.getSharedPreferences(pref_name, mode)
        editor = pref!!.edit()
    }

    fun createSession(username: String) {
        editor!!.putBoolean(is_login, true)
        editor!!.putString(id_level, username)
        editor!!.commit()
    }

    //set level
//
//    fun setReminder(data: String) {
//        editor!!.putString("dataGetReminder", data)
//        editor!!.commit()
//    }
//
//    fun getReminder(): String {
//        return pref!!.getString("dataGetReminder", "")
//    }
//
//    //setsubmateri
//    init {
//        this.context = contextK
//        pref = context!!.getSharedPreferences(pref_name, mode)
//        editor = pref!!.edit()
//
//    }
//
//
//    fun createSessionSubMateri(username: String) {
//        editor!!.putBoolean(is_login, true)
//        editor!!.putString(id_submateri, username)
//        editor!!.commit()
//    }
//
//    fun setSubMateri(data: String) {
//        editor!!.putString("dataSubMateri", data)
//        editor!!.commit()
//    }
//
//    fun getSubMateri(): String {
//        return pref!!.getString("dataSubMateri", "")
//    }
//    //setmateri
//
//    init {
//        this.context = contextK
//        pref = context!!.getSharedPreferences(pref_name, mode)
//        editor = pref!!.edit()
//    }
//
//    fun createSessionMateri(username: String) {
//        editor!!.putBoolean(is_login, true)
//        editor!!.putString(id_materi, username)
//        editor!!.commit()
//    }
//
//    fun setCekk(data: String) {
//        editor!!.putString("dataMateri", data)
//        editor!!.commit()
//    }
//
//    fun getCekk(): String {
//        return pref!!.getString("dataMateri", "")
//    }
//
//    //setmodul
//    init {
//        this.context = contextK
//        pref = context!!.getSharedPreferences(pref_name, mode)
//        editor = pref!!.edit()
//    }
//
//    fun createSessionEvent(id_event: String) {
//        editor!!.putBoolean(is_login, true)
//        editor!!.putString(key_name, id_event)
//        editor!!.commit()
//    }
//
//    fun setEvent(data: String) {
//        editor!!.putString("dataEvent", data)
//        editor!!.commit()
//    }
//
//    fun getEvent(): String {
//        return pref!!.getString("dataEvent", "")!!
//
//    }

    init {
        this.context = contextK
        pref = context!!.getSharedPreferences(pref_name, mode)
        editor = pref!!.edit()
    }

    fun createSessionLevel(id: String) {
        editor!!.putBoolean(is_login, true)
        editor!!.putString(key_name, id)
        editor!!.commit()
    }

    //set user
    fun setNama(
        id_user: String,
        nama_user: String,
        email: String,
        no_hp: String,
        jenis_kelamin: String
    ) {
        editor!!.putString("id_user", id_user)
        editor!!.putString("nama_user", nama_user)
        editor!!.putString("email", email)
        editor!!.putString("no_hp", no_hp)
        editor!!.putString("jenis_kelamin", jenis_kelamin)
        editor!!.commit()
    }


    fun setId(id_user: String) {
        editor!!.putString("id_user", id_user)
        editor!!.commit()
    }



    fun checkLogin() {
        if (!this.isLogin()) {
            val i = Intent(context, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context!!.startActivity(i)
        } else {
            val i = Intent(context, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context!!.startActivity(i)
        }
    }

    fun isLogin(): Boolean {
        return pref!!.getBoolean(is_login, false)
    }





    fun logoutUser() {
        // Clearing all data from Shared Preferences
        editor!!.clear()
        editor!!.commit()

        // After logout redirect user to Loing Activity
        val i = Intent(context, Login_Activity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        context!!.startActivity(i)
    }

//    fun getIdEvent(): String {
//        return pref!!.getString("id_event", "")!!
//    }

    fun getId(): String {
        return pref!!.getString("id_user", "")!!
    }

    fun getNamaUser(): String {
        return pref!!.getString("nama_user", "")!!
    }

    fun getEmail(): String {
        return pref!!.getString("email", "")!!
    }
    fun getNoHP(): String {
        return pref!!.getString("no_hp", "")!!
    }
    fun getJeniskelamin(): String {
        return pref!!.getString("jenis_kelamin", "")!!
    }
}