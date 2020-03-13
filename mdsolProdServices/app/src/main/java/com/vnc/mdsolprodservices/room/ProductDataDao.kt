package com.vnc.mdsolprodservices.room

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query

interface ProductDataDao {
    @Insert
    suspend fun insert(product: ProductDataEntity)

    @Query("SELECT * FROM productData")
    suspend fun getAllMedidataProduct(): LiveData<List<ProductDataEntity>>

}
