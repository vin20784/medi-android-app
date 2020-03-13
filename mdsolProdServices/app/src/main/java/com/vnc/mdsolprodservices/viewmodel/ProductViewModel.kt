package com.vnc.mdsolprodservices.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnc.mdsolprodservices.room.ProductDataEntity
import com.vnc.mdsolprodservices.room.ProductDatabase
import com.vnc.mdsolprodservices.room.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProductViewModel(application: Application): AndroidViewModel(application) {
     var productRepository: ProductRepository;
    //val allProductData: LiveData<List<ProductDataEntity>>

    init{
        val productDataDao= ProductDatabase.getDatabase(application)?.productDataDao()
        productRepository= productDataDao?. let{ ProductRepository(it) }!!
        //allProductData = productRepository.allProducts
    }

    fun insert(productDataEntity: ProductDataEntity){
        viewModelScope.launch(Dispatchers.Default){
            productRepository.insert(productDataEntity)
        }
    }

    fun getMedidataProductData(): List<ProductDataEntity>? {
        var allProducts:List<ProductDataEntity>?=null
        viewModelScope.launch(Dispatchers.Default){
             allProducts =  productRepository.getProductData()
            println(allProducts?.size)
            allProducts?.forEach(){
                println(it.productName)
                println(it.id)
            }
        }
        return  allProducts
    }
}