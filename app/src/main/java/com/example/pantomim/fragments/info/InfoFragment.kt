package com.example.pantomim.fragments.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pantomim.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private lateinit var viewModel: InfoViewModel
    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(InfoViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnSubmit.setOnClickListener {
            findNavController().navigate(
                InfoFragmentDirections
                    .actionInfoFragmentToStartFragment(binding.etName.text.toString())
            )
        }

        //showing image with glide
        Glide.with(this).load(viewModel.imgURL).into(binding.imgAvatar)

        //in case wanna show img with VM
//            viewModel.name.observe(viewLifecycleOwner, Observer {
//                Log.i(TAG, "onCreateView: ${viewModel.name.value} ")
//            })


        //simple showing img
//       binding.imgAvatar.loadImage(viewModel.imgURL)

        return binding.root
    }
}