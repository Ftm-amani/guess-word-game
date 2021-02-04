package com.example.pantomim.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel  : ViewModel(){

    val score = MutableLiveData(0)
}