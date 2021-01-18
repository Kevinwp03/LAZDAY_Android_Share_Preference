package com.example.androidsharepreferenceslazday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidsharepreferenceslazday.helper.Constant
import com.example.androidsharepreferenceslazday.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var  sharedPref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) { // apapun yang ada di onCreate akan dijaankan
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = PreferencesHelper(this)

        buttonLogin.setOnClickListener {
            if (editUsername.text.isNotEmpty() && editUsername.text.isNotEmpty()){
                saveSession(editUsername.text.toString(), editPassword.text.toString())
                shortMassage("Berhasil Masuk")
                moveIntent()

                //sharedPref.put( Constant.PREF_USERNAME, editUsername.text.toString()) // put digunakan untuk menyimpan data
                //sharedPref.put( Constant.PREF_PASSWORD, editPassword.text.toString())
                //sharedPref.put( Constant.PREF_IS_LOGIN, true)
            }
        }
    }

    private fun saveSession ( username: String, password: String){
        sharedPref.put( Constant.PREF_USERNAME, editUsername.text.toString()) // put digunakan untuk menyimpan data
        sharedPref.put( Constant.PREF_PASSWORD, editPassword.text.toString())
        sharedPref.put( Constant.PREF_IS_LOGIN, true)
    }


    // menggunakan onStart untuk melakukan Pengecekan
    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN) == true) {
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this, UserActivity::class.java))
    }


    // Pesan singkat login telah berhasil
    private fun shortMassage(massage: String){
        Toast.makeText(applicationContext, massage, Toast.LENGTH_SHORT).show()
    }

}