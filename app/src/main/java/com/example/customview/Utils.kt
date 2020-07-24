package com.example.customview

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

class Utils {
    companion object {
        fun dp2px(value: Float): Float {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                Resources.getSystem().displayMetrics
            )
        }
    }
}