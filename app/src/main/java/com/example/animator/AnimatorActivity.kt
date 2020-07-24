package com.example.animator

import android.animation.ObjectAnimator
import android.animation.PointFEvaluator
import android.animation.TypeEvaluator
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import com.example.customview.dp
import com.example.dashboard.DashBoardView
import com.example.mykotlin.R
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_animator.*
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.function.Consumer
import java.util.function.Function
import androidx.annotation.MainThread as Andr
import io.reactivex.Observer as Observer1
import io.reactivex.SingleObserver as SingleObserver


class AnimatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator)

//        val animator = ObjectAnimator.ofInt(
//            dashView, "count",
//            19
//        )
//
//        animator.duration = 2000
//        animator.startDelay=3000
//        animator.start()


//        //属性动画
//        val animator = ObjectAnimator.ofFloat(view, "radius", 150f.dp)
//        animator.startDelay = 1000
//        animator.start()


//        var single:Single<Int> = Single.just(1)
//        single.map(object :io.reactivex.functions.Function<Int,String>{
//            override fun apply(t: Int): String {
//                TODO("Not yet implemented")
//            }
//
//        })
//        Single.just(1).map { it.toString() }
//            .subscribe(object:SingleObserver<String>{
//            override fun onSuccess(value: String?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onSubscribe(d: Disposable?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onError(e: Throwable?) {
//                TODO("Not yet implemented")
//            }
//
//        })

    }
}