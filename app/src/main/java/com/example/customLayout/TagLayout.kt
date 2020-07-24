package com.example.customLayout

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import androidx.core.view.children
import java.util.Collections.max
import java.util.Collections.swap
import kotlin.math.max

class TagLayout(context: Context, attrs: AttributeSet) : ViewGroup(context, attrs) {

    //保存每个子View的具体的摆放位置
    private val childBounds = mutableListOf<Rect>()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSuggest = MeasureSpec.getSize(widthMeasureSpec)
        var widthUsed = 0
        var heighUsed = 0
        var lineWidthUsed = 0
        var lineMaxHeigh = 0
        var viewHeigh = 0
        var lastHeighUsed = 0
        var lastWidthUsed = 0
        var widthMaxUsed = 0
        //测量自己 自己的测量宽度和高度需要子View来确定 子View的宽度和高度加起来就是父布局的宽度和高度
        for ((index, child) in children.withIndex()) {
            val layoutParams = child.layoutParams

            measureChildWithMargins(
                child,
                widthMeasureSpec,
                0,
                heightMeasureSpec,
                heighUsed
            )

            if (lineWidthUsed + child.measuredWidth > widthSuggest) {
                lastWidthUsed = lineWidthUsed
                lineWidthUsed = 0
                heighUsed = lineMaxHeigh
                measureChildWithMargins(
                    child,
                    widthMeasureSpec,
                    0,
                    heightMeasureSpec,
                    heighUsed
                )
            }

            if (index >= childBounds.size) {
                childBounds.add(Rect())
            }
            val childBound = childBounds[index]


            childBound.set(
                lineWidthUsed,
                heighUsed,
                lineWidthUsed + child.measuredWidth,
                heighUsed + child.measuredHeight
            )
            if (index > 0) {
                lineMaxHeigh = max(heighUsed + child.measuredHeight, childBounds[index - 1].bottom)
            } else {
                lineMaxHeigh = heighUsed + child.measuredHeight
            }

            lineWidthUsed += child.measuredWidth

            widthMaxUsed = max(lastWidthUsed, lineWidthUsed)

        }


        val selfWidth = widthMaxUsed
        val selfHeight = lineMaxHeigh
        Log.e("lei", "${selfWidth},${selfHeight}")
        setMeasuredDimension(selfWidth, selfHeight)
//            //需要计算的是childWidthSpec 由以下两种拼凑而成
//            var childWidthSpecMode = 0
//            var childWidthSpecSize = 0
//            //先考虑开发者建议，再根据自身条件具体是否满足来判断最终要给childView的测量建议
//            when (layoutParams.width) {
//                LayoutParams.MATCH_PARENT ->
//                    when (widthMode) {
//                        //我的父view给我的空间是确定的，然后子view的开发者意见又要填满我的空间，所以我把我能给的空间都给他
//                        MeasureSpec.EXACTLY -> {
//                            childWidthSpecSize = widthSuggest - widthUsed
//                            childWidthSpecMode = MeasureSpec.EXACTLY
//                        }
//                        //我的父View给我的空间是一个有上限的空间，即不超过某个值都可以，那么当我的子View需要所有空间，我就都给他
//                        MeasureSpec.AT_MOST -> {
//                            childWidthSpecSize = widthSuggest - widthUsed
//                            childWidthSpecMode = MeasureSpec.EXACTLY
//                        }
//                        //随便测量不给我限制，开发者又想填满我，我没办法给出具体的值了就只有也不限制你了
//                        MeasureSpec.UNSPECIFIED -> {
//                            childWidthSpecSize = 0
//                            childWidthSpecMode = MeasureSpec.UNSPECIFIED
//                        }
//                    }
//                LayoutParams.WRAP_CONTENT ->
//                    when (widthMode) {
//                        //我的父view给我的空间是确定的，然后子view的开发者意见又要填满我的空间，所以我把我能给的空间都给他
//                        MeasureSpec.EXACTLY -> {
//                            childWidthSpecSize = widthSuggest - widthUsed
//                            childWidthSpecMode = MeasureSpec.AT_MOST
//                        }
//                        //我的父View给我的空间是一个有上限的空间，即不超过某个值都可以，那么当我的子View需要所有空间，我就都给他
//                        MeasureSpec.AT_MOST -> {
//                            childWidthSpecSize = widthSuggest - widthUsed
//                            childWidthSpecMode = MeasureSpec.AT_MOST
//                        }
//                        //随便测量不给我限制，开发者又想填满我，我没办法给出具体的值了就只有也不限制你了
//                        MeasureSpec.UNSPECIFIED -> {
//                            childWidthSpecSize = 0
//                            childWidthSpecMode = MeasureSpec.UNSPECIFIED
//                        }
//                    }
//                else -> {
//                    childWidthSpecSize = layoutParams.width
//                    childWidthSpecMode = MeasureSpec.EXACTLY
//                }
//            }
//
//            //父布局给子View的测量建议 由什么决定？
//            //1.开发者建议 2.自己的所剩下的空间大小（我的可用空间从哪来，一个是我的父view给我的建议，一个是我用掉的空间
//
//            child.measure(childWidthSpec, childHeightSpec)


    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((i, child) in children.withIndex()) {

            child.layout(
                childBounds[i].left,
                childBounds[i].top,
                childBounds[i].right,
                childBounds[i].bottom
            )
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}