package com.example.mail_course_hw_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.mail_course_hw_1.R
import com.example.mail_course_hw_1.activities.MainActivity.Companion.setColor
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    companion object {

        const val KEY_SELECTED_ITEM = "ITEM"

    }

    private var selectedNum: Int
        get() = requireArguments().getInt(KEY_SELECTED_ITEM)
        set(value) = requireArguments().putInt(KEY_SELECTED_ITEM, value)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_second, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(tvSelectedNum) {
            text = selectedNum.toString()
            setColor(selectedNum)
        }
    }
}
