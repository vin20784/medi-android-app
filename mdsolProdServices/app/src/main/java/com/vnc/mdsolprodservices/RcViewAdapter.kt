package com.vnc.mdsolprodservices

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
const val key ="myobjkey"
class RcViewAdapter(var context: Context,val userList: ArrayList<MovieModel>) : RecyclerView.Adapter<RcViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_adapter, parent, false)
        return ViewHolder(v);
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.img.setImageResource(userList[position].mIcon)
        holder.name.text = userList[position].name
        holder.YoR.text = userList[position].YearOfRel.toString()
        holder.director.text = userList[position].dir_name.toString()
        holder.rating.text = userList[position].rating.toString()



        holder.itemView.setOnClickListener{

            //Toast.makeText(context,position.toString(),LENGTH_LONG).show()
            //start new activity
            //val myIntent = Intent(context,)

            //var obj = holder as Bundle

            //startActivity(context,Intent(context, DetailCardActivity::class.java),null)


        }
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)
    {
        val name: TextView = itemView.findViewById(R.id.mvName)
        val YoR = itemView.findViewById<TextView>(R.id.mvYearOfRel)
        val director = itemView.findViewById<TextView>(R.id.mvdir_name)
        val rating = itemView.findViewById<TextView>(R.id.mvrating)
        val img = itemView.findViewById<ImageView>(R.id.imageView)



    }
}