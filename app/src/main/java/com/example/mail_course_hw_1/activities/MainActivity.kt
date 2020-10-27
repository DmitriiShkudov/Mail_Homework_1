package com.example.mail_course_hw_1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.fragments.FirstFragment
import java.util.*

class MainActivity : AppCompatActivity() {

    // хелпер-методы
    companion object {

        // установка цвета в соотв. с заданием
        fun TextView.setColor(num: Int) =
            this.setTextColor(
                ResourcesCompat.getColor(resources,
                if (num.isOdd) R.color.blue else R.color.red,
                null))

        // нечетное ли число
        val Int.isOdd
            get() = this % 2 == 1

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            with (supportFragmentManager.beginTransaction()) {
                add(R.id.main_layout, FirstFragment().also { it.arguments = Bundle() })
                commit()
            }

    }

}