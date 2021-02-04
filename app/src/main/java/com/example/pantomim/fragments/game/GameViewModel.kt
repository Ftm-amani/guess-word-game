package com.example.pantomim.fragments.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.pantomim.BuzzTypeEnum

val CORRECT_BUZZ_PATTERN = longArrayOf(100, 100, 100, 100, 100, 100)
val PANIC_BUZZ_PATTERN = longArrayOf(0, 200)
val GAME_OVER_BUZZ_PATTERN = longArrayOf(0, 2000)
val NO_BUZZ_PATTERN = longArrayOf(0)

class GameViewModel : ViewModel() {


    lateinit var wordList: MutableList<String>
    lateinit var timer : CountDownTimer

    private val _buzzType = MutableLiveData(BuzzTypeEnum.NO_BUZZ)
    val buzzType: LiveData<BuzzTypeEnum>
        get() = _buzzType

    private val _word =  MutableLiveData<String>()
    val word :LiveData<String?>
    get() = _word

    private val _score = MutableLiveData<Int>()
    val score : LiveData<Int>
    get() = _score

    private val _currentTime = MutableLiveData<Long>()

     val formatedCurrentTime: LiveData<String> = Transformations.map(_currentTime){
         _currentTime.value?.let{
        DateUtils.formatElapsedTime(_currentTime.value  ?:0)
    }}

    private val _eventGameFinish = MutableLiveData(false)
    val eventGameFinish : LiveData<Boolean>
        get() = _eventGameFinish

    init{
        _score.value = 0
        createWordList()
        nextWord()

        timer = object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                _eventGameFinish.value = true
            }
            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished/1000
            }
        }
        timer.start()
    }

     fun createWordList(){
        wordList = mutableListOf<String>(
            "پاپیروس",
            "دادگاه تجدید نظر",
            "دادستان عمومی",
            "چهار شنبه سوری پارسال",
            "روح اموات",
            "سفرنامه مارکوپلو",
            "نازک نارنجی",
            "رستوران مکزیکی",
            "گل گاو زبان",
            "ناتالی پرتمن",
            "سگ اقای پتی بل",
            "مخبر الدوله سر سعدی",
            "شتر گاو پلنگ",
            "کروموزوم",
            "محلول",
            "لر",
            "دار المجانین",
            "محسن چاوشی",
            "نراق",
            "سازمان ملل متحد"
        )
        wordList.shuffle()
    }

    fun onCorrect() {
        _score.value = _score.value?.plus(1)
        _buzzType.value = BuzzTypeEnum.CORRECT
        nextWord()
    }

    fun onWrong() {
        _score.value = _score.value?.minus(1)
        _buzzType.value = BuzzTypeEnum .SKIP
        nextWord()
    }

    fun onGameFinishedComplete() {
        _buzzType.value = BuzzTypeEnum.GAME_OVER
        _eventGameFinish.value = false
    }

    fun onGameBuzzComplete(){
        _buzzType.value = BuzzTypeEnum.NO_BUZZ
    }

     private fun nextWord() {
        if (wordList.isEmpty()){
            createWordList()
        }else{
            _word.value = wordList.removeAt(0)
        }
    }
    fun gameFinishCalled(){
        _eventGameFinish.value= false
    }

}