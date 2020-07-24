package com.example.customedittext

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.EditText
import androidx.core.content.contentValuesOf
import com.example.customview.dp

class MaterialEditText(context: Context, attrs: AttributeSet) :
    androidx.appcompat.widget.AppCompatEditText(context, attrs) {
    private val TEXT_SIZE = 12f.dp
    private val TEXT_MARGIN = 8f.dp
    private val HOR_OFFSET = 8f.dp
    private val VER_OFFSET = 23f.dp

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        textSize = TEXT_SIZE
    }

    init {
        setPadding(
            paddingLeft,
            paddingTop + TEXT_SIZE.toInt() + TEXT_MARGIN.toInt(),
            paddingRight,
            paddingBottom
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (!text.isNullOrEmpty()) {
            canvas.drawText(hint.toString(), HOR_OFFSET, VER_OFFSET, paint)
        }
    }

}