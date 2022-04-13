package com.wsg.scale.adapter

import com.wsg.scale.bean.Empty
import com.wsg.scale.bean.Scale
import com.wsg.scale.holder.EmptyViewBinder
import com.wsg.scale.holder.ScaleViewBinder
import me.drakeet.multitype.MultiTypeAdapter

/**
 * Create on 2022/4/13.
 *
 * @author wangshengguo.
 */
class ScaleAdapter : MultiTypeAdapter() {
    init {
        register(Scale::class.java, ScaleViewBinder())
        register(Empty::class.java, EmptyViewBinder())
    }
}