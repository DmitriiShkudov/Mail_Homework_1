package com.example.mail_course_hw_1.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mail_course_hw_1.num_handler.OnNumberSelectListener
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.num_handler.NumHandler
import com.example.mail_course_hw_1.num_handler.NumHandler.add
import com.example.mail_course_hw_1.num_handler.NumHandler.list
import com.example.mail_course_hw_1.num_handler.NumHandler.selectedItem
import com.example.mail_course_hw_1.rv_adapter.RvAdapter
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

    // константы
    companion object {

        const val SPAN_AMOUNT = 3
        const val LANDSCAPE_SPAN_AMOUNT = 4

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_first, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        // адаптер
        val rvAdapter = RvAdapter()

        // присваивание адаптера, менеджера и обработчика нажатий
        with(recycler) {

            adapter = rvAdapter

            // устанавливаем кол-во столбцов в зависимости от ориентации
            layoutManager = GridLayoutManager(context, getSpanAmount())

            setOnNumberSelectListener()

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

    private fun RecyclerView.setOnNumberSelectListener() =

        (this.adapter as RvAdapter).setOnNumberSelectListener { num ->

            // присвоение ссылке выбранного числа
            selectedItem = num

            // открываем второй фрагмент
            with(requireActivity().supportFragmentManager.beginTransaction()) {

                replace(R.id.main_layout, SecondFragment())
                addToBackStack(null)
                commit()

            }

        }


}