package com.example.pantomim.fragments.start

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pantomim.MAX_SCORE_KEY
import com.example.pantomim.databinding.FragmentStartBinding
import com.example.pantomim.fragments.SharedViewModel
import org.koin.android.ext.android.inject

class StartFragment : Fragment() {

    lateinit var binding : FragmentStartBinding
    lateinit var shareViewModel: SharedViewModel
    val sharedPrefs : SharedPreferences by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        shareViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding = FragmentStartBinding.inflate(inflater)
        binding.shareViewModel = shareViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.tvRecord.text=sharedPrefs.getInt(MAX_SCORE_KEY,0).toString()

        binding.btnStart.setOnClickListener{
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToGameFragment())
         }

        return binding.root
    }
}