package com.wsg.scale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wsg.scale.adapter.ScaleAdapter
import com.wsg.scale.bean.Empty
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
        val width = recyclerView?.layoutParams?.width ?: 0
        val height = recyclerView?.layoutParams?.height ?: 0

        list.add(Empty(width / 2, height))

        for (i in 0..100) {
            list.add(Scale(i))
        }

        list.add(Empty(width / 2, height))

        adapter?.items = list
        adapter?.notifyDataSetChanged()
    }
}