package com.annasblackhat.archpaging

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by annasblackhat on 16/03/18.
 */

@Dao
interface ProductDao{

    @Insert
    fun saveProducts(product: List<Product>)

    @Query("SELECT * FROM product ORDER BY id")
    fun getuser(): DataSource.Factory<Int, Product>

    @Query("SELECT COUNT(*) FROM product")
    fun countData(): Int
}