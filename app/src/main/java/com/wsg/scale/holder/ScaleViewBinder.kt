package com.wsg.scale.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsg.scale.R
import com.wsg.scale.bean.Scale
import me.drakeet.multitype.ItemViewBinder

/**
 * Create on 2022/4/13.
 *
 * @author wangshengguo.
 */
class ScaleViewBinder : ItemViewBinder<Scale, ScaleViewBinder.ScaleViewHolder>() {

    class ScaleViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {

    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ScaleViewHolder {
        return ScaleViewHolder(inflater.inflate(R.layout.item_scale, parent, false))
    }

    override fun onBindViewHolder(holder: ScaleViewHolder, item: Scale) {

    }
}