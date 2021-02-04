package com.example.pantomim.fragments.score

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.pantomim.MAX_SCORE_KEY

class ScoreViewModel(val sharedPrefs : SharedPreferences):ViewModel(){
    var score = 0

    fun saveData(){
    sharedPrefs.edit().putInt(MAX_SCORE_KEY,score)
}
}