package com.example.mail_course_hw_1.rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mail_course_hw_1.num_handler.NumHandler.list

class RvAdapter()
    : RecyclerView.Adapter<RvViewHolder>() {

    // обработчик выбора элемента
    private var onNumberSelectAction: (num: Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RvViewHolder(onNumberSelectAction, LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    fun setOnNumberSelectAction(onNumberSelect: (num: Int) -> Unit) {
        onNumberSelectAction = onNumberSelect
    }


}