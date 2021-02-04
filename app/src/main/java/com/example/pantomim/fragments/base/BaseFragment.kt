package com.example.pantomim.fragments.base

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showMessage(msg:String){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
    }

    fun showError(error:String){
        Toast.makeText(context,error,Toast.LENGTH_LONG).show()
    }

}