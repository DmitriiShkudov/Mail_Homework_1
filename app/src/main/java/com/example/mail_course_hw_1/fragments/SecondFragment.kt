package com.example.mail_course_hw_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.num_handler.NumHandler
import com.example.mail_course_hw_1.num_handler.NumHandler.selectedItem
import com.example.mail_course_hw_1.num_handler.NumHandler.setColor
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_second, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // присваиваю
        tvSelectedNum.text = selectedItem.toString()
        tvSelectedNum.setColor(selectedItem)

    }
}