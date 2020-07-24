package com.example.mykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.GitHubService
import com.example.retrofit.Repo
import kotlinx.coroutines.GlobalScope
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.DriverManager.println
import retrofit2.Callback as Callback1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val create:GitHubService = retrofit.create(GitHubService::class.java)

        val listRepos: Call<List<Repo>> = create.listRepos("octocat")

        listRepos.enqueue(object : Callback1<List<Repo>>{
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {

                System.out.println("Response:${response.body()?.get(0)?.name}")
            }

        })
    }
}