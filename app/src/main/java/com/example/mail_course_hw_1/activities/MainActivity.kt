package com.example.mail_course_hw_1.activities

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Toast
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.fragments.FirstFragment
import com.example.mail_course_hw_1.fragments.SecondFragment
import com.example.mail_course_hw_1.num_handler.NumHandler
import com.example.mail_course_hw_1.num_handler.NumHandler.init
import com.example.mail_course_hw_1.num_handler.NumHandler.list
import com.example.mail_course_hw_1.num_handler.NumHandler.selectedItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // константы
    private companion object {

        const val KEY_SELECTED_ITEM = "ITEM"
        const val KEY_SIZE = "SIZE"

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // перед onStop запоминаем размер списка и выбранный элемент

        outState.putInt(KEY_SIZE, list.size)
        outState.putInt(KEY_SELECTED_ITEM, selectedItem)

        // очищаем лист, т.к ссылаемся на тот же лист и при иниц. от 1 до n будет 2n элементов
        list.clear()

    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when (savedInstanceState) {

            // по умолчанию заполняем лист от 1 до 100 и открываем фрагмент
            null -> {
                list.init()
                supportFragmentManager.beginTransaction().add(R.id.main_layout, FirstFragment()).commit()
            }

            // в сохр. состоянии заполняем лист и выбранное число до сохраненных значений
            else -> {
                list.init(savedInstanceState.getInt(KEY_SIZE))
                selectedItem = savedInstanceState.getInt(KEY_SELECTED_ITEM)
            }

        }


    }



}