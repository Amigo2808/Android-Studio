package com.amigo.swipableviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.amigo.tablayout.R

class Adapter (
    val image:List<Int>
):RecyclerView.Adapter<Adapter.viewPagerViewHolder>(){
    inner class viewPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewPagerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.ivimage,parent,false)
        return viewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: viewPagerViewHolder, position: Int) {
        val curImage=image[position]
        holder.itemView.findViewById<ImageView>(R.id.ivImage).setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return image.size
    }
}