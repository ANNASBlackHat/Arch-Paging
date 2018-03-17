package com.annasblackhat.archpaging

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by annasblackhat on 16/03/18.
 */

@Entity
data class Product(
        @PrimaryKey
        var id: Int,
        var name: String,
        var price: Int,
        var qty: Int
)