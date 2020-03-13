package com.vnc.mdsolprodservices.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface ProductDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert(product: ProductDataEntity):Long

    @Query("SELECT * FROM productData")
     suspend fun getAllMedidataProduct(): List<ProductDataEntity>
}
