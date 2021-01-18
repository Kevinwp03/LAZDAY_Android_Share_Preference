package com.example.androidsharepreferenceslazday.helper

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper (context: Context){
    private val PREFS_NAME = "sharedprefkotlin12345" // di rekomendasi harus ada penamaan agar tidak bertabrakan dengan data yang lain
    private val sharedpref: SharedPreferences // share Preferences membutuhkan context

    val editor: SharedPreferences.Editor // semua data disimpan disini

    init { // ketika kelas helper ini dipanggil secara otomatis yg terdapat dalam init akan dijalankan
        sharedpref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedpref.edit()
    }
    // cara menyimpan data pada Share Prefenrences
    fun put(key: String, value: String){
        editor.putString(key, value) // kunci dan value akan disimpan di line ini
            .apply()
    }

    // Untuk mendapatkan nilainya
    fun getString(key: String) : String? {
        return sharedpref.getString(key, null) // ini default value, jadi misalkan keynya belum ada maka valuenya akan diisi data null
    }

    // Bagaimana misalnya nilainya INT atau Boolean?
    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value) // kunci dan value akan disimpan di line ini
            .apply()
    }

    // Untuk mendapatkan nilainya
    fun getBoolean(key: String) : Boolean? {
        return sharedpref.getBoolean(key, false) // ini default value, jadi misalkan keynya belum ada maka valuenya akan diisi data null
    }

    // menghapus data di sharePreference saat Logout
    fun clear() {
        editor.clear()
            .apply()
    }

}