package com.vnc.mdsolprodservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.vnc.mdsolprodservices.room.ProductDataEntity
import com.vnc.mdsolprodservices.room.ProductDatabase
import com.vnc.mdsolprodservices.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity : AppCompatActivity() {
    private var productViewModel:ProductViewModel?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
         productViewModel= ViewModelProvider(this).get(ProductViewModel(application)::class.java)


        addPrdButton.setOnClickListener(){
            saveProductDataInDB(it);

        }
    }

    private fun saveProductDataInDB(it: View?) {
        var productDataEntity= ProductDataEntity(System.currentTimeMillis(),"eCoa","medicle","test")
        productViewModel?.insert(productDataEntity);
        println("Data inserted successfully")
        var allProduct: List<ProductDataEntity>? = productViewModel?.getMedidataProductData()
        println(allProduct?.size)
        allProduct?.forEach(){
            println(productDataEntity.productName)
        }
    }
}
