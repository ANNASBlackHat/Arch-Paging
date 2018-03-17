package com.annasblackhat.archpaging

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by annasblackhat on 16/03/18.
 */

@Database(entities = [(Product::class)], version = 1)
abstract class ProductDatabase: RoomDatabase(){
    abstract fun productDao(): ProductDao
}