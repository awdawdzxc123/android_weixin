package com.example.android_weixin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.CHINA


class FruitAdapter(context: Context, private val resource: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(context, resource, data) {

    private val resourceId =resource
    inner  class ViewHolder(
        val imageView:ImageView,
        val textView1:TextView,
        val textView2:TextView,
        val textView3:TextView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val viewHolder:ViewHolder
        val view: View
        if (convertView==null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val imageView: ImageView = view.findViewById(R.id.imageView)
            val textView1: TextView = view.findViewById(R.id.textView1)
            val textView2: TextView = view.findViewById(R.id.textView2)
            val textView3: TextView = view.findViewById(R.id.textView3)

            viewHolder =ViewHolder(imageView, textView1, textView2, textView3)
            view.tag=viewHolder

        }else{
            view =convertView
            viewHolder=view.tag as ViewHolder
        }

        val fruit=getItem(position)
        if (fruit != null){
            viewHolder.imageView.setImageResource(fruit.imageID)
            viewHolder.textView1.text=fruit.name
            viewHolder.textView2.text=fruit.xid
            viewHolder.textView3.text=getTime()
        }
        return view
    }
    fun  getTime():String{
        val data = Date()
        val dateFormat = SimpleDateFormat("HH:mm:ss", CHINA)
        return dateFormat.format(data)
    }
}