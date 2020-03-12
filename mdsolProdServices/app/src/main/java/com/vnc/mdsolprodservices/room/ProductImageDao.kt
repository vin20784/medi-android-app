package com.vnc.mdsolprodservices.room

import androidx.lifecycle.LiveData
import androidx.room.Query

interface ProductImageDao {

    @Query("SELECT * FROM productImage")
    suspend fun getAllMedidataProduct(): LiveData<List<ProductImageEntity>>
}
