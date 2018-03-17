package com.annasblackhat.archpaging

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

/**
 * Created by annasblackhat on 16/03/18.
 */
class ProductViewModel(private val productDao: ProductDao): ViewModel() {

    val MAX_DATA = 100
    var productList : LiveData<PagedList<Product>> = LivePagedListBuilder(productDao.getuser(), 20).build()

    fun insertData() {
        launch {
            val countData = productDao.countData()
            if(countData == 0){
                val productList = ArrayList<Product>()
                for (i in 0 until MAX_DATA){
                    productList.add(Product(i, "Chicken Panda $i", 5500 + (i + MAX_DATA), i))
                }
                productDao.saveProducts(productList)
            }
        }
    }


}