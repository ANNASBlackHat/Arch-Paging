package com.annasblackhat.archpaging

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by annasblackhat on 16/03/18.
 */

class ProductAdapter(diffCallback: DiffUtil.ItemCallback<Product>, private val products: List<Product>) : PagedListAdapter<Product, ProductViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(BR.model, products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }
}