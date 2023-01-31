package com.example.daysofwellness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    @StringRes val dayPhrase: Int,
    @DrawableRes val imageRes: Int
)
