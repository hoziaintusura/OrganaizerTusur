package com.danil.ogranizertusur.workspace.viewmodel

import android.content.Context

object Graph {

    lateinit var appContext: Context
    fun provide(context: Context){
        appContext = context
    }
}