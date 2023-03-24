package com.example.geeksfit.data.local

import android.content.Context

class Pref(context: Context) {

    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveAccessToken(name: String) {
        pref.edit().putString(ACCESS_TOKEN, name).apply()
    }

    fun getAccessToken(): String? {
        return pref.getString(ACCESS_TOKEN, "")
    }

    fun saveToken(name: String) {
        pref.edit().putString(TOKEN, name).apply()
    }

    fun getToken(): String? {
        return pref.getString(TOKEN, "")
    }

    fun saveImage(image: String) {

        pref.edit().putString(IMAGE_PROFILE, image).apply()
    }

    fun getImage(): String? {
        return pref.getString(IMAGE_PROFILE, "")
    }

    fun saveName(name: String) {
        pref.edit().putString(SAVE_NAME, name).apply()
    }

    fun getName(): String? {
        return pref.getString(SAVE_NAME, "")
    }
    fun saveEmail(name: String) {
        pref.edit().putString(SAVE_EMAIL, name).apply()
    }

    fun getEmail(): String? {
        return pref.getString(SAVE_EMAIL, "")
    }

    companion object {
        private const val TOKEN = "token"
        private const val ACCESS_TOKEN = "access_token"
        private const val IMAGE_PROFILE = "image.profile"
        private const val PREF_NAME = "geeks_fit"
        private const val SAVE_NAME = "save_name"
        private const val SAVE_EMAIL = "save_email"


    }

}