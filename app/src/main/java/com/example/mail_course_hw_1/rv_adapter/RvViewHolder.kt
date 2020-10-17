package com.example.mail_course_hw_1.rv_adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.activities.MainActivity
import com.example.mail_course_hw_1.fragments.FirstFragment
import com.example.mail_course_hw_1.fragments.SecondFragment
import com.example.mail_course_hw_1.num_handler.NumHandler
import com.example.mail_course_hw_1.num_handler.NumHandler.selectedItem
import com.example.mail_course_hw_1.num_handler.NumHandler.setColor
import kotlinx.android.synthetic.main.recycler_item.view.*

class RvViewHolder(private val activity: FragmentActivity, inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_item, parent, false)) {

    // TextView, отображающее число
    private val tvItem = itemView.tvItem

    fun bind(element: Int) {

        with(tvItem) {

            // установка числа
            text = element.toString()

            // установка цвета
            setColor(element)

            setOnClickListener {

                // присвоение ссылке выбранного числа
                selectedItem = element

                // открываем второй фрагмент
                with (activity.supportFragmentManager.beginTransaction()) {

                    replace(R.id.main_layout, SecondFragment())
                    addToBackStack(null)
                    commit()

                }

            }

        }

    }

}