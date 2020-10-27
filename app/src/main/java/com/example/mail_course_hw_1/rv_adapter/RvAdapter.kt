package com.example.mail_course_hw_1.rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class RvAdapter(private val list: LinkedList<Int>,
                private val onNumberSelectAction: (num: Int) -> Unit)
    : RecyclerView.Adapter<RvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RvViewHolder(onNumberSelectAction, LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

}