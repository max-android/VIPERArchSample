package com.my_project.viperarchsample.model.data_holder

import android.content.Context
import android.content.SharedPreferences
import com.my_project.viperarchsample.view.common.CONST


class LocalHolder(context: Context) {

    private var preferences: SharedPreferences = context.getSharedPreferences(CONST.HOLDER, Context.MODE_PRIVATE)
    private lateinit var editor: SharedPreferences.Editor

    fun setToken(token: String) {
        createEditor()
        editor.putString(CONST.TOKEN_KEY, token)
        editor.apply()
    }

    fun token() = preferences.getString(CONST.TOKEN_KEY, CONST.DEFAULT_TOKEN)

    fun deleteToken() {
        createEditor()
        editor.remove(CONST.TOKEN_KEY)
        editor.apply()
    }

    private fun createEditor() {
        editor = preferences.edit()
    }
}