package com.example.mail_course_hw_1.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.num_handler.NumHandler.add
import com.example.mail_course_hw_1.num_handler.NumHandler.init
import com.example.mail_course_hw_1.num_handler.NumHandler.list
import com.example.mail_course_hw_1.rv_adapter.RvAdapter
import kotlinx.android.synthetic.main.fragment_first.*
import java.util.*


class FirstFragment : Fragment() {

    // константы
    private companion object {

        const val SPAN_AMOUNT = 3
        const val LANDSCAPE_SPAN_AMOUNT = 4

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_first, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        // адаптер
        val rvAdapter = RvAdapter(activity!!)

        // присваивание адаптера и менеджера
        recycler.apply {

            adapter = rvAdapter

            // устанавливаем кол-во столбцов в зависимости от ориентации
            layoutManager = GridLayoutManager(context, getSpanAmount())

        }

        // при клике на кнопку "Add" добавляем элемент и сообщаем адаптеру об изменениях
        btn_add.setOnClickListener {

            list.add()
            rvAdapter.notifyDataSetChanged()

        }

    }

    private fun getSpanAmount() = when (resources.configuration.orientation) {

        Configuration.ORIENTATION_LANDSCAPE -> LANDSCAPE_SPAN_AMOUNT
        else -> SPAN_AMOUNT

    }


}