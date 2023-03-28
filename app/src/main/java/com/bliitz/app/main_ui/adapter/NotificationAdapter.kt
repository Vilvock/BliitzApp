package com.bliitz.app.main_ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bliitz.app.R
import com.bliitz.app.util.RecyclerItemListener

class NotificationAdapter(private val context: Context,
                          private val list: List<Any>,
                          private val onListener: RecyclerItemListener
):
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

//        val nameTv: TextView = itemView.findViewById(R.id.name_tv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_notification, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.itemView.setOnClickListener { onListener.onClickListenerItem(item) }

    }

    override fun getItemCount(): Int {
        return list.size
    }


}