package com.example.animator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.view.MotionEventCompat.getPointerId
import com.example.customview.dp

class PaintView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 4f.dp

    }
    private var loadPath = Path()

    private var pointIndex = 0

    private var paths = mutableListOf<Path>()

    private var pathMap = mutableMapOf<Int, Path>()
    override fun onDraw(canvas: Canvas) {
        for ((index, path) in paths.withIndex()) {
            canvas.drawPath(path, paint)
        }
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                val eventId = event.getPointerId(pointIndex)
                paths.add(Path())
                val downX = event.x
                val downY = event.y
                paths[pointIndex].moveTo(downX, downY)
                pathMap[eventId] = paths[pointIndex]
            }
            MotionEvent.ACTION_MOVE -> {
                for (pIndex in 0 until event.pointerCount) {
                    val eventId = event.getPointerId(pIndex)
                    pathMap[eventId]?.lineTo(event.getX(pIndex), event.getY(pIndex))
                }
                invalidate()
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                pointIndex++
                val eventId = event.getPointerId(pointIndex)
                paths.add(Path())
//                pathMap[pointIndex]={eventId->paths[pointIndex]}
                paths[pointIndex].moveTo(event.getX(pointIndex), event.getY(pointIndex))
                pathMap[eventId] = paths[pointIndex]

            }

            MotionEvent.ACTION_POINTER_UP->{
                pointIndex--
            }

        }
        return true
    }
}