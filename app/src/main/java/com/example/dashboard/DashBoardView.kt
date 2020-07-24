package com.example.dashboard

import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.customview.dp
import kotlin.math.cos
import kotlin.math.sin


class DashBoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val OPEN_ANGEL: Float = 120f

    private val radius = 100f.dp

    //虚线的path
    private val dash = Path()
    private val ciclePath = Path()
    private val dashWidth = 2f.dp
    private val dashHeight = 5f.dp
    private val intervalNum = 20f
    private var intervalLength = 50f.dp

    private lateinit var pathEffect: PathDashPathEffect

    var listPointEnd = mutableListOf<PointF>()


    private var end: PointF = PointF(0f, 0f)
        set(value) {
            field = value
            invalidate()
        }

    private val pointLength = radius - 20f.dp


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        strokeWidth = 3f.dp
        style = Paint.Style.STROKE
        dash.addRect(0f, 0f, dashWidth, dashHeight, Path.Direction.CCW)
        //给你画的线设置效果 dash line 虚线 patheffect 画线效果
        //advance 是否要空一个再开始画 phase 间隔多少画一个

    }

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        strokeWidth = 3f.dp
        style = Paint.Style.STROKE
        dash.addRect(0f, 0f, dashWidth, dashHeight, Path.Direction.CCW)
        //给你画的线设置效果 dash line 虚线 patheffect 画线效果
        //advance 是否要空一个再开始画 phase 间隔多少画一个

    }

    private var count=0
    set(value) {
        field=value
        end=listPointEnd[value]
        invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        ciclePath.reset()
        ciclePath.addArc(
            width / 2 - radius,
            height / 2 - radius,
            width / 2 + radius,
            height / 2 + radius, 150f, 240f
        )
        val pathMeasure = PathMeasure(ciclePath, false)
        intervalLength = (pathMeasure.length - dashWidth) / intervalNum
        Log.e("lei", intervalLength.toString())
        pathEffect = PathDashPathEffect(dash, intervalLength, 0f, PathDashPathEffect.Style.ROTATE)
        paint.pathEffect = pathEffect

        end.x = calEndX(0)
        end.y = calEndY(0)

        for (i in 0 until 20) {
            listPointEnd.add(PointF(calEndX(i), calEndY(i)))
            Log.e("lei", "${listPointEnd[i].x}${listPointEnd[i].y}")
        }
    }


    override fun onDraw(canvas: Canvas) {
//        canvas.drawRect(RectF(width / 2 - radius, height / 2 - radius, width / 2 + radius, height / 2 + radius), paint)
        //先画一个圆弧
        canvas.drawPath(
            ciclePath, paint
        )
        canvas.drawPath(
            ciclePath, mPaint
        )

        Log.e("lei ", "${end.x},${end.y}")
        canvas.drawLine(width / 2f, height / 2f, end.x, end.y, paint)


    }

    fun calEndX(n: Int): Float {
        return width / 2 + pointLength * cos(Math.toRadians((150 + n * (240 / 20)).toDouble())).toFloat()
    }

    fun calEndY(n: Int): Float {
        return height / 2 + pointLength * sin(Math.toRadians((150 + n * (240 / 20)).toDouble())).toFloat()
    }


    inner class PointTypeEvaluator : TypeEvaluator<PointF> {
        override fun evaluate(fraction: Float, startValue: PointF?, endValue: PointF?): PointF {
            val start = 0;
            val end = listPointEnd.indexOf(endValue)
            var i = start + (end - start) * fraction.toInt()
            return listPointEnd[i]
        }
    }


}