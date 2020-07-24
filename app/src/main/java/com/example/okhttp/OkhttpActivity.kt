package com.example.okhttp

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.mykotlin.R
import com.example.retrofit.GitHubService
import com.example.retrofit.Repo
import kotlinx.coroutines.GlobalScope
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.sql.DriverManager.println
import retrofit2.Callback as Callback1

class OkhttpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val okhttpClient: OkHttpClient = OkHttpClient()
        val req: Request =
            Request.Builder().url("https://api.github.com/users/rengwuxian/repos").build()

        val call = okhttpClient.newCall(req)

        call.enqueue(object : Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                println("response code=${e.toString()}")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                println("response code=${response.code()}")
            }

        })
        call.execute()
    }
}