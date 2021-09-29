package com.example.giphy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.giphy.RetrofitInstance.retrofitInstance
import retrofit2.Call
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NoticeAdapter
    lateinit var recyclerView : RecyclerView
    val noticeArrayList= ArrayList<Notice>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = NoticeAdapter(noticeArrayList,this)

        val service = retrofitInstance!!.create(
            GetNoticeDataService::class.java
        )

        val call: Call<NoticeList?>? = service.noticeData()

        call!!.enqueue(object : Callback<NoticeList?> {
            override fun onResponse(call: Call<NoticeList?>?, response: Response<NoticeList?>) {
                generateNoticeList(response.body()!!.noticeArrayList!!)
            }

            override fun onFailure(call: Call<NoticeList?>?, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Something went wrong...Error message: " + t.cause,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun generateNoticeList(noticeArrayList: ArrayList<Notice>) {

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = NoticeAdapter(noticeArrayList,applicationContext)
    }
}