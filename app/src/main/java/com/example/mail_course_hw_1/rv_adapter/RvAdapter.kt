package com.example.mail_course_hw_1.rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mail_course_hw_1.num_handler.OnNumberSelectListener
import com.example.mail_course_hw_1.num_handler.NumHandler.list

class RvAdapter()
    : RecyclerView.Adapter<RvViewHolder>() {

    // Слушатель выбора элемента
    private var onNumberSelectListener: OnNumberSelectListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RvViewHolder(onNumberSelectListener, LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    fun setOnNumberSelectListener(onNumberSelect: (num: Int) -> Unit) {

        onNumberSelectListener = object : OnNumberSelectListener {

            override fun onNumberSelect(num: Int) = onNumberSelect.invoke(num)

        }

    }

}