package com.example.customXfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.customview.dp
import com.example.mykotlin.R

class AvatorView(context: Context, attrs: AttributeSet) : View(context, attrs) {


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val avatarWidth = 200f.dp

    private val paddingLeft = 100f.dp
    private val paddingTop = 100f.dp

    val rectF = RectF(paddingLeft, paddingTop, paddingLeft + avatarWidth, paddingTop + avatarWidth)


    override fun onDraw(canvas: Canvas) {

        //画出bitmap
        val count = canvas.saveLayer(rectF, paint)
        canvas.drawOval(rectF, paint)

        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN))

        canvas.drawBitmap(getAvatar(avatarWidth.toInt()), paddingLeft, paddingTop, paint)
        canvas.restoreToCount(count)
    }


    fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.avatar_rengwuxian, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.mipmap.avatar_rengwuxian, options)
    }
}