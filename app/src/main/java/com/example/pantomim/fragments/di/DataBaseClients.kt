package com.example.pantomim.fragments.di

import android.content.Context
import android.content.SharedPreferences

fun provideSharedPrefs(context:Context):SharedPreferences{

    return context.getSharedPreferences("wordScope",Context.MODE_PRIVATE)

}