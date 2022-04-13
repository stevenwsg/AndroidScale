package com.wsg.scale.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsg.scale.R
import com.wsg.scale.bean.Empty
import me.drakeet.multitype.ItemViewBinder

/**
 * Create on 2022/4/13.
 *
 * @author wangshengguo.
 */
class EmptyViewBinder : ItemViewBinder<Empty, EmptyViewBinder.EmptyViewHolder>() {


    class EmptyViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        var emptyView: View

        init {
            emptyView = rootView
        }

        fun render(item: Empty) {
            if (emptyView.layoutParams is RecyclerView.LayoutParams) {
                val params = emptyView.layoutParams
                params.width = item.width
                params.height = item.height
                emptyView.layoutParams = params
            }
        }
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): EmptyViewHolder {
        return EmptyViewHolder(inflater.inflate(R.layout.item_empty, parent, false))
    }

    override fun onBindViewHolder(holder: EmptyViewHolder, item: Empty) {
        holder.render(item)
    }
}