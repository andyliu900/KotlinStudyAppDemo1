/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package com.ideacode.kotlinstudydemo1.mvp.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ideacode.kotlinstudydemo1.R
import com.ideacode.kotlinstudydemo1.bean.CalentarDayBean
import com.ideacode.kotlinstudydemo1.bean.CalentarDayData
import com.ideacode.kotlinstudydemo1.bean.CalentarDayResult
import com.ideacode.kotlinstudydemo1.mvp.contract.CalentarContract
import com.ideacode.kotlinstudydemo1.mvp.presenter.CalentarPresenter

class MainActivity : AppCompatActivity(), CalentarContract.View {

    lateinit var datePicker: DatePicker
    lateinit var selectButton: Button
    lateinit var detailLabel: TextView
    lateinit var detailResult: TextView

    override lateinit var presenter: CalentarContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        presenter = CalentarPresenter(this)
        datePicker = findViewById(R.id.datePicker)
        detailLabel = findViewById(R.id.detailLabel)
        detailResult = findViewById(R.id.detailResult)

        selectButton = findViewById(R.id.selectButton)
        selectButton.setOnClickListener {
            selectButton.visibility = View.GONE
            detailLabel.visibility = View.GONE
            detailResult.visibility = View.GONE
            datePicker.visibility = View.VISIBLE
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener { view, year, month, day ->
                var date = "${year}-${month+1}-${day}"
                presenter.getDayCalentarData(date)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun showDayCalentarData(calentarDayBean: CalentarDayBean<CalentarDayResult<CalentarDayData>>) {
        hideDatePickerDialog()

        detailLabel.text = calentarDayBean.result.data.date
        detailResult.text = calentarDayBean.result.data.toString()
    }

    override fun showError(errorMsg: String) {
        hideDatePickerDialog()

        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
    }

    fun hideDatePickerDialog() {
        datePicker.visibility = View.GONE
        selectButton.visibility = View.VISIBLE
        detailLabel.visibility = View.VISIBLE
        detailResult.visibility = View.VISIBLE
    }
}