package com.example.mail_course_hw_1.rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mail_course_hw_1.activities.MainActivity
import com.example.mail_course_hw_1.num_handler.NumHandler.list
import java.util.*

class RvAdapter(private val activity: FragmentActivity)
    : RecyclerView.Adapter<RvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RvViewHolder(activity, LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size
}