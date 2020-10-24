package com.example.mail_course_hw_1.rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.num_handler.NumHandler.setColor
import kotlinx.android.synthetic.main.recycler_item.view.*
import java.lang.Exception

class RvViewHolder(private val onNumberSelectAction: (Int) -> Unit, inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_item, parent, false)) {

    // TextView, отображающее число
    private val tvItem = itemView.tvItem

    fun bind(element: Int) {

        with(tvItem) {

            // установка числа
            text = element.toString()

            // установка цвета
            setColor(element)

            // обработка нажатия
            setOnClickListener {
                
                onNumberSelectAction.invoke(element)

            }

        }

    }

}