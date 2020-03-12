package com.vnc.mdsolprodservices.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "productImage", foreignKeys = [ForeignKey(entity = ProductData::class,
        parentColumns = arrayOf("productID"),
        childColumns = arrayOf("productID"),
        onDelete = ForeignKey.CASCADE)])
class ProductImage(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")val id:Long=1,
        @ColumnInfo(name = "productID")val prodID: Long,
        @ColumnInfo(typeAffinity = ColumnInfo.BLOB) val data: ByteArray? = null
) {}
