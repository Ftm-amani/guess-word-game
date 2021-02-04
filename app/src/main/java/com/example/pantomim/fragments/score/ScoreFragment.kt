package com.example.pantomim.fragments.score
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.pantomim.databinding.FragmentScoreBinding
//import com.example.pantomim.fragments.ScoreFragmentArgs
//import com.example.pantomim.fragments.ScoreFragmentDirections
import com.example.pantomim.fragments.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScoreFragment : Fragment() {

    lateinit var binding : FragmentScoreBinding
     val shareViewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentScoreBinding.inflate(inflater)

        binding.shareViewModel = shareViewModel
        binding.lifecycleOwner = viewLifecycleOwner


        arguments?.let {
            shareViewModel.score.value = ScoreFragmentArgs.fromBundle(
                it
            ).score
        }

        binding.btnAgain.setOnClickListener{
            findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToStartFragment())
        }

        return binding.root
        }
}