package com.amigo.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    val todo:List<dataClass>
):RecyclerView.Adapter<Adapter.todoViewHolder>(){
    inner class todoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return todoViewHolder(view)
    }

    override fun onBindViewHolder(holder: todoViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tvTitle).text=todo[position].title
            findViewById<CheckBox>(R.id.cbDone).isChecked=todo[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todo.size
    }
}