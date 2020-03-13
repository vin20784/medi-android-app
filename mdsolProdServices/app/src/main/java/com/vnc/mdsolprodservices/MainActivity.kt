package com.vnc.mdsolprodservices


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        val dataList = ArrayList<MovieModel>()
        dataList.add(MovieModel("eCOA ", 1999,"Patient Cloud",4.8))
        dataList.add(MovieModel("eConsent", 2003,"Patient Cloud", 4.3))
        dataList.add(MovieModel("Virtual Trials", 2003 ,"Patient Cloud",4.1))
        dataList.add(MovieModel("eTMF", 2021 ,"Trial Management",0.0))
        dataList.add(MovieModel("CTMS", 2008, "Trial Management" ,4.2))
        dataList.add(MovieModel("CSA", 2008, "Trial Management" ,4.2))
        dataList.add(MovieModel("RBQM", 2010, "Trial Management" ,4.4))

        //        pass the values to RvAdapter
        val rvAdapter = RcViewAdapter(this,dataList)
//        set the recyclerView to the adapter
        recyclerView.adapter = rvAdapter;

    }
}
