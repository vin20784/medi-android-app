package com.vnc.mdsolprodservices.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productData")
data class ProductData(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "productID")val id:Long=1,
        @ColumnInfo(name = "productName")val productName:String = ""
) {}
