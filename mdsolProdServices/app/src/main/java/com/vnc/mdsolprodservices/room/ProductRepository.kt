package com.vnc.mdsolprodservices.room

import androidx.lifecycle.LiveData

class ProductRepository(private val productDataDao:ProductDataDao) {


    suspend fun insert(productDataEntity: ProductDataEntity) {
        productDataDao.insert(productDataEntity)
    }

     suspend fun getProductData():List<ProductDataEntity> {
        var allProducts:List<ProductDataEntity> =  productDataDao.getAllMedidataProduct()
        return allProducts
    }
}