package com.example.pantomim

import com.example.pantomim.fragments.game.CORRECT_BUZZ_PATTERN
import com.example.pantomim.fragments.game.GAME_OVER_BUZZ_PATTERN
import com.example.pantomim.fragments.game.NO_BUZZ_PATTERN
import com.example.pantomim.fragments.game.PANIC_BUZZ_PATTERN


    enum class BuzzTypeEnum(val pattern: LongArray) {
        CORRECT(CORRECT_BUZZ_PATTERN),
        GAME_OVER(GAME_OVER_BUZZ_PATTERN),
        SKIP(PANIC_BUZZ_PATTERN),
        NO_BUZZ(NO_BUZZ_PATTERN)

}