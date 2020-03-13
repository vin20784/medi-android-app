package com.vnc.mdsolprodservices.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "productData")
data class ProductDataEntity(
        @PrimaryKey(autoGenerate = true)  @NotNull @ColumnInfo(name = "productID")val id:Long=1,
        @ColumnInfo(name = "productName") @NotNull val productName:String = "",
        @ColumnInfo(name = "productType") @NotNull val productType:String = "",
        @ColumnInfo(name = "productDesc") @NotNull val productDescription:String = ""
) {}
