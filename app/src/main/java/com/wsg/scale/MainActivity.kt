package com.wsg.scale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wsg.scale.adapter.ScaleAdapter
import com.wsg.scale.bean.Scale

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: ScaleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        recyclerView = findViewById(R.id.scaleRv)
        recyclerView?.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        adapter = ScaleAdapter()
        recyclerView?.adapter = adapter

        val list = arrayListOf<Any>()
        for (i in 0..100) {
            list.add(Scale(i))
        }
        adapter?.items = list
        adapter?.notifyDataSetChanged()
    }
}