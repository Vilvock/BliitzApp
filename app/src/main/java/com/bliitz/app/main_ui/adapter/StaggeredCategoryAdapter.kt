package com.bliitz.app.main_ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bliitz.app.R
import com.bliitz.app.util.RecyclerItemListener
import com.google.android.material.imageview.ShapeableImageView

class StaggeredCategoryAdapter(private val context: Context,
                               private val list: List<Any>,
                               private val onListener: RecyclerItemListener
):
    RecyclerView.Adapter<StaggeredCategoryAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nameTv: TextView = itemView.findViewById(R.id.name_tv)
//        val commentTv: TextView = itemView.findViewById(R.id.comment_tv)
//        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
//        val dateTv: TextView = itemView.findViewById(R.id.date_tv)
//        val numberNoReadMsgsTv: TextView = itemView.findViewById(R.id.numberMsgs_tv)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_category_staggered, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]


        when(position) {
            0-> {

                holder.nameTv.text = "categoria"
            }
            1 -> {

                holder.nameTv.text = "lorem ipsum"
            }
            else ->{

                holder.nameTv.text = "outra "
            }
        }

        holder.itemView.setOnClickListener { onListener.onClickListenerItem(item) }

    }


    override fun getItemCount(): Int {
        return list.size
    }




}