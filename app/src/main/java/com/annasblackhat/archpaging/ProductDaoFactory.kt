package com.annasblackhat.archpaging

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ProductDaoFactory(val productDao: ProductDao) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProductViewModel::class.java)){
            return  ProductViewModel(productDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}