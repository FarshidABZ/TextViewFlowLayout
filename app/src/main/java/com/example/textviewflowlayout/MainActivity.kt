package com.example.textviewflowlayout

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var chatItems = arrayListOf<ChatModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        addItems()
    }

    private fun initViews() {
        recyclerView.adapter = MessageAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, true)
    }

    private fun addItems() {
        for (i in 0..200) {
            chatItems.add(getRandomChat(i))
        }
        
        (recyclerView.adapter as MessageAdapter).submitList(chatItems)
    }
}