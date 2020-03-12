package com.vnc.mdsolprodservices.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
        entities = [ProductDataEntity::class,ProductImageEntity::class],
        version=1,
        exportSchema = false
)
abstract class ProductDatabase:RoomDatabase() {
    abstract fun productDataDao():ProductDataDao
    abstract fun productImageDao():ProductImageDao

    companion object {
        @Volatile
        var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase? {
            if (INSTANCE == null){
                synchronized(ProductDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, ProductDatabase::class.java, "medidataDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}
