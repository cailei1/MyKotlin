package com.example.customview

import android.content.Intent
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlin.R
import com.example.retrofit.GitHubService
import com.example.retrofit.Repo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.io.ObjectOutputStream
import java.io.OutputStream
import kotlin.concurrent.thread
import retrofit2.Callback as Callback1

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hThread = HandlerThread("子线程")
        hThread.start()

        val mainHandle = Handler(hThread.looper)



        mainHandle.post(object : Runnable {
            override fun run() {
                Thread.sleep(2000)
                tv.text = "hello 海贼王"
            }

        })
//        tv.setOnClickListener{
//            thread {
//                Looper.prepare()
//                tv.text = "hello 海贼王"
//                Looper.loop()
//            }
//        }


    }
}