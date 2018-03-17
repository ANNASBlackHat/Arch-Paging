package com.annasblackhat.archpaging

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by annasblackhat on 16/03/18.
 */
class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: ViewDataBinding? = DataBindingUtil.bind(itemView)

    fun bind(variable: Int, value: Any?){
        value?.let {
            binding?.setVariable(variable, it)
            binding?.executePendingBindings()
        }
    }
}