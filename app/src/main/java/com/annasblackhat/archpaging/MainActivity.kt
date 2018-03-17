package com.annasblackhat.archpaging

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.util.DiffUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val productList =  ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(this, ProductDatabase::class.java, "product.db").build()
        val dao = db.productDao()
        val viewModel = ViewModelProviders.of(this, ProductDaoFactory(dao)).get(ProductViewModel::class.java)

        println("insert data....")
        viewModel.insertData()

        rec_view_product.adapter = ProductAdapter(DIFF_CALLBACK, productList)
        viewModel.productList.observe(this, Observer {
            it?.let { productList.addAll(it) }
            rec_view_product.adapter.notifyDataSetChanged()
            println("product size Now : ${productList.size}")
            productList.forEach { println("ID : ${it}") }
        })
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Product>(){
            override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
        }
    }
}
