package com.example.pantomim.fragments.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel : ViewModel() {

    val name = MutableLiveData("")
    val imgURL = "https://i.pinimg.com/600x315/7d/49/8e/7d498ec59ee3ecdd265da31c5f48f759.jpg"
}