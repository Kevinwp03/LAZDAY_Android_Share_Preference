package com.example.androidsharepreferenceslazday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidsharepreferenceslazday.helper.Constant
import com.example.androidsharepreferenceslazday.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    lateinit var sharedpref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sharedpref = PreferencesHelper(this)
        textUsername.text = sharedpref.getString( Constant. PREF_USERNAME ) // untuk mendapatkan data username

        buttonLogout.setOnClickListener {
            sharedpref.clear()
            shortMassage("Keluar")
            moveIntent()
        }

    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun shortMassage(massage: String){
        Toast.makeText(applicationContext, massage, Toast.LENGTH_SHORT).show()
    }

}