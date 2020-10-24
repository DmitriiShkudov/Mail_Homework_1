package com.example.mail_course_hw_1.num_handler

import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.mail_course_hw_1.R
import java.util.*

object NumHandler {

    private const val DEFAULT_NUM_AMOUNT = 100

    // список
    val list = LinkedList<Int>()

    // ссылка, которая хранит номер выбранного числа
    var selectedItem = 0

    // инициализация списка по умолчанию
    fun LinkedList<Int>.init() = (1..DEFAULT_NUM_AMOUNT).forEach { this.add(it) }

    // инициализация списка до заданного значения
    fun LinkedList<Int>.init(size: Int) = (1..size).forEach { this.add(it) }

    // добавление следующего числа
    fun LinkedList<Int>.add() = this.add(this.last + 1)

    // установка цвета в соотв. с заданием
    fun TextView.setColor(num: Int) =
        this.setTextColor(ResourcesCompat.getColor(resources,
                                                   if (num.isOdd) R.color.blue else R.color.red,
                                                   null))

    // нечетное ли число
    private val Int.isOdd
        get() = this % 2 == 1

}