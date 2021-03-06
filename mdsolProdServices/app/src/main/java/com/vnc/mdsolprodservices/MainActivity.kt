package com.vnc.mdsolprodservices


import android.content.Intent
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val productListFragment = ProductListFragment()
        fragmentTransaction.replace(R.id.detailFrameLayout, productListFragment)
        fragmentTransaction.addToBackStack("productListFragment")
        fragmentTransaction.commit()


        imageViewNewPrd.setOnClickListener(){
            startActivity(Intent(this,AddProductActivity::class.java))
        }

    }
}
