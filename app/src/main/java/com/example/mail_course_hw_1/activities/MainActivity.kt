package com.example.mail_course_hw_1.activities

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.fragments.FirstFragment
import com.example.mail_course_hw_1.fragments.SecondFragment
import com.example.mail_course_hw_1.num_handler.NumHandler
import com.example.mail_course_hw_1.num_handler.NumHandler.init
import com.example.mail_course_hw_1.num_handler.NumHandler.list
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Заполняем лист по умолчанию (от 1 до 100) только при первом запуске
        if (savedInstanceState == null) {

            list.init()
            supportFragmentManager.beginTransaction().add(R.id.main_layout, FirstFragment()).commit()

        }

    }

}