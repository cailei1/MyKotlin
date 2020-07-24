package com.example.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.mykotlin.R

class TestView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val camera = Camera().apply {
        this.rotateX(30f)
    }


    var radius = 100f.dp;
    override fun onDraw(canvas: Canvas) {
        camera.applyToCanvas(canvas)
        canvas.drawBitmap(getAvatar(200f.dp.toInt()),100f.dp,100f.dp,paint)
    }


    private fun getAvatar(width: Int): Bitmap {
        val option = BitmapFactory.Options()
        option.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.avatar_rengwuxian, option)
        option.inJustDecodeBounds = false
        //原来bitmap的宽
        option.inDensity = option.outWidth
        //目标bitmap的宽
        option.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.mipmap.avatar_rengwuxian, option)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)

    }
}