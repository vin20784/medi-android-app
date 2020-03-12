package com.vnc.mdsolprodservices

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

const val key ="myobjkey"
class RcViewAdapter(var context: Context,val userList: ArrayList<ProductModel>) : RecyclerView.Adapter<RcViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_adapter, parent, false)
        return ViewHolder(v);
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text     = userList[position].productName
        holder.director.text = userList[position].productdetails
        holder.itemView.setOnClickListener{
            var productModel = userList[position]
            var mContext = context as AppCompatActivity

            val fragmentTransaction = mContext.getSupportFragmentManager().beginTransaction()
            val productListFragment = ProductDetailsFragment.newInstance(productModel)

            if (productListFragment != null) {
                fragmentTransaction.replace(R.id.detailFrameLayout, productListFragment)
            }
            fragmentTransaction.addToBackStack("productListFragment")
            fragmentTransaction.commit()
        }
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
       val name     = itemView.findViewById<TextView>(R.id.productName)
       val director = itemView.findViewById<TextView>(R.id.productDetails)
       val img      = itemView.findViewById<ImageView>(R.id.imageView)
    }
}