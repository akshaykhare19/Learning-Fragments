package com.project.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val item: Array<String>,
                private val listener: ListItemClicked): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ListViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = item[position]
        holder.listText.text = currentItem
        holder.itemView.setOnClickListener {
            listener.onItemClicked(currentItem)
        }

    }

    override fun getItemCount() = item.size

    class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val listText: TextView = view.findViewById(R.id.list_text)

    }
    interface ListItemClicked {
        fun onItemClicked(place: String)
    }


}