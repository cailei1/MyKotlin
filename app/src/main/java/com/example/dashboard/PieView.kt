package com.example.dashboard

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.customview.dp

class PieView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val radius = 100f.dp
    private val paint1 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GREEN
    }
    private val paint3 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas) {


        canvas.save()
        canvas.translate(5f.dp,5f.dp)
        canvas.drawArc(
            width / 2 - radius,
            height / 2 - radius,
            width / 2 + radius,
            height / 2 + radius,
            0f,
            120f,
            true,
            paint1
        )
        canvas.restore()
        canvas.drawArc(
            width / 2 - radius,
            height / 2 - radius,
            width / 2 + radius,
            height / 2 + radius,
            120f,
            90f,
            true,
            paint2
        )
        canvas.drawArc(
            width / 2 - radius,
            height / 2 - radius,
            width / 2 + radius,
            height / 2 + radius,
            210f,
            150f,
            true,
            paint3
        )
    }
}