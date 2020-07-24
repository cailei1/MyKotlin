package com.example.animator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.customview.dp
import java.util.jar.Attributes

class CircleImageView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    val paint=Paint(Paint.ANTI_ALIAS_FLAG)

    private var radius=100f.dp
    set(value){
        field=value
        invalidate()
    }
    init {
        paint.color= Color.RED
        paint.style=Paint.Style.FILL
    }
    override fun onDraw(canvas: Canvas) {
         canvas.drawCircle(width/2f,height/2f,radius,paint)
    }
}