package com.wsg.scale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.wsg.scale.adapter.ScaleAdapter
import com.wsg.scale.bean.Empty
import com.wsg.scale.bean.Scale
import com.wsg.scale.bean.ScaleHalf

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: ScaleAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        textView = findViewById(R.id.tv_progress)

        recyclerView = findViewById(R.id.scaleRv)
        layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView?.layoutManager = layoutManager

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)


        recyclerView?.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (RecyclerView.SCROLL_STATE_IDLE == newState) {
                    val childView = snapHelper.findSnapView(layoutManager)
                    childView?.apply {
                        val position = recyclerView.getChildAdapterPosition(this)

                        when(adapter?.items?.get(position)) {
                            is Scale -> {
                                textView?.text = "当前滑动到 ${((adapter?.items?.get(position) as? Scale)?.scale)}"
                            }
                            is ScaleHalf -> {
                                textView?.text = "当前滑动到 ${((adapter?.items?.get(position) as? ScaleHalf)?.scale)}"
                            }
                        }
                    }
                }
            }
        })

        adapter = ScaleAdapter()
        recyclerView?.adapter = adapter

        val list = arrayListOf<Any>()
        val width = recyclerView?.layoutParams?.width ?: 0
        val height = recyclerView?.layoutParams?.height ?: 0

        list.add(Empty(width / 2, height))

        for (i in 0..100) {
            list.add(Scale(i))
            if (i != 100) {
                for (j in 1..9) {
                    list.add(ScaleHalf(j / 10f + i))
                }
            }
        }

        list.add(Empty(width / 2, height))

        adapter?.items = list
        adapter?.notifyDataSetChanged()
    }
}