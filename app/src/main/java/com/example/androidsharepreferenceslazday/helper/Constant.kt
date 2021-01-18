package com.example.androidsharepreferenceslazday.helper

class Constant { // data"yang dibutuhkan key ada disini

companion object { // tanpa companion object, makan akan bermasalah di class main
    val PREF_IS_LOGIN = "PREF_IS_LOGIN" // nilai pakai Boolean, untuk mendeteksi sudah Login atau belum
    val PREF_USERNAME = "PREF_USERNAME" // menyimpan username
    val PREF_PASSWORD = "PREF_PASSWORD" // menyimpan password
    }
}