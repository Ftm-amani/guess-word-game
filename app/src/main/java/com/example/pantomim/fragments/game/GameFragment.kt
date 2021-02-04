package com.example.pantomim.fragments.game

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pantomim.BuzzTypeEnum
import com.example.pantomim.MAX_SCORE_KEY
import com.example.pantomim.databinding.FragmentGameBinding
import com.example.pantomim.fragments.base.BaseFragment
import org.koin.android.ext.android.inject

class GameFragment : BaseFragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var binding: FragmentGameBinding
    private val sharedPrefs : SharedPreferences by inject()

    override fun onCreateView(inflater: LayoutInflater,  container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer {
            if(it == true){
                goToNextPage()
                viewModel. gameFinishCalled()
            }
        })


        viewModel.buzzType.observe(viewLifecycleOwner, Observer {
            if (it != BuzzTypeEnum.NO_BUZZ){
                startVibrate(it)
                viewModel.onGameBuzzComplete()
            }
        })

        return binding.root
    }

    private fun startVibrate(buzzType: BuzzTypeEnum?) {
        val buzzer = requireActivity()
            .getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            buzzer.vibrate(VibrationEffect.createWaveform(buzzType?.pattern,-1))
        }else{
            buzzer.vibrate(buzzType?.pattern,-1)
        }
    }

    private fun goToNextPage() {

        if(sharedPrefs.getInt(MAX_SCORE_KEY, 0)<viewModel.score.value?:0) {
            sharedPrefs.edit().putInt(MAX_SCORE_KEY, viewModel.score.value ?: 0).apply()
        }

        findNavController()
            .navigate(
                GameFragmentDirections.actionGameFragmentToScoreFragment(
                    viewModel.score.value ?: 0
                )
            )
        viewModel.onGameFinishedComplete()
    }
}
