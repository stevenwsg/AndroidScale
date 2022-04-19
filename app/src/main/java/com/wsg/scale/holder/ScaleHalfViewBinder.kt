package com.wsg.scale.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsg.scale.R
import com.wsg.scale.bean.ScaleHalf
import me.drakeet.multitype.ItemViewBinder

/**
 * Create on 2022/4/19.
 *
 * @author wangshengguo.
 */
class ScaleHalfViewBinder : ItemViewBinder<ScaleHalf, ScaleHalfViewBinder.Holder>() {

    class Holder(rootView: View) : RecyclerView.ViewHolder(rootView) {

    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): Holder {
        return ScaleHalfViewBinder.Holder(inflater.inflate(R.layout.item_scale_half, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, item: ScaleHalf) {
    }
}