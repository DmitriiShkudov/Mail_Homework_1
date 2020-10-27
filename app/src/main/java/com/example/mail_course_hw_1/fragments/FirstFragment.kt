package com.example.mail_course_hw_1.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.fragments.SecondFragment.Companion.KEY_SELECTED_ITEM
import com.example.mail_course_hw_1.num_handler.NumHandler
import com.example.mail_course_hw_1.rv_adapter.RvAdapter
import kotlinx.android.synthetic.main.fragment_first.*
import java.util.*


class FirstFragment : Fragment() {

    companion object {

        const val SPAN_AMOUNT = 3
        const val LANDSCAPE_SPAN_AMOUNT = 4
        const val KEY_SIZE = "SIZE"
        const val DEFAULT_NUM_AMOUNT = 100

        // инициализация списка до заданного значения
        fun LinkedList<Int>.init(size: Int) = (1..size).forEach { this.add(it) }

        // добавление следующего числа
        fun LinkedList<Int>.add() = this.add(this.last + 1)

    }

    private lateinit var list: LinkedList<Int>

    private var size: Int
        get() = requireArguments().getInt(KEY_SIZE, DEFAULT_NUM_AMOUNT)
        set(value) = requireArguments().putInt(KEY_SIZE, value)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_first, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        // инициализация листа
        list = LinkedList<Int>().also { it.init(size) }

        // адаптер
        val rvAdapter = RvAdapter(list, ::onNumberSelectAction)

        // присваивание адаптера и менеджера
        with(recycler) {

            adapter = rvAdapter

            // устанавливаем кол-во столбцов в зависимости от ориентации
            layoutManager = GridLayoutManager(context, getSpanAmount())

        }

        // при клике на кнопку "Add" добавляем элемент и сообщаем адаптеру об изменениях
        btn_add.setOnClickListener {

            size++
            list.add()
            rvAdapter.notifyDataSetChanged()

        }
    }



    private fun onNumberSelectAction(num: Int) {

        // открываем второй фрагмент и запоминаем выбранное число
        with(requireActivity().supportFragmentManager.beginTransaction()) {

            replace(R.id.main_layout, SecondFragment().also {

                it.arguments = Bundle().apply {
                    putInt(KEY_SELECTED_ITEM, num)
                }

            })

            addToBackStack(null)
            commit()

        }

    }

    private fun getSpanAmount() = when (resources.configuration.orientation) {

        Configuration.ORIENTATION_LANDSCAPE -> LANDSCAPE_SPAN_AMOUNT
        else -> SPAN_AMOUNT

    }

}