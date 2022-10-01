package com.basakjeet08.dob_calculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker:Button = findViewById(R.id.btnDatePicker)
        val tvSelectedDate : TextView = findViewById(R.id.tvSelectedDate)
        val myCalendar = Calendar.getInstance()
        val currentYear = myCalendar.get(Calendar.YEAR)
        val currentMonth = myCalendar.get(Calendar.MONTH)
        val currentDay = myCalendar.get(Calendar.DAY_OF_MONTH)
        tvSelectedDate.text = "$currentDay/${currentMonth+1}/$currentYear"

        btnDatePicker.setOnClickListener {
            clickDatePicker(currentDay,currentMonth,currentYear,tvSelectedDate)
        }
    }
    private fun clickDatePicker(currentDay:Int , currentMonth:Int , currentYear:Int , tvSelectedDate : TextView){
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view , selectedYear , selectedMonth , dayOfMonth ->
            tvSelectedDate.text = "$dayOfMonth/${selectedMonth+1}/$selectedYear"
            val todayDate = (currentYear*365 + currentDay + when(currentMonth+1){
                1,3,5,7,9,11 -> 31
                4,6,8,10,12 -> 30
                else -> 27
            })*1440
            val bodDate = (selectedYear*365 + dayOfMonth + when(selectedMonth+1){
                1,3,5,7,9,11 -> 31
                4,6,8,10,12 -> 30
                else -> 27
            })*1440
            val differenceInMinutes = todayDate - bodDate

            val tvTimeInMin : TextView = findViewById(R.id.tvTimeInMin)
            tvTimeInMin.text = "$differenceInMinutes"
        },
            currentYear,currentMonth,currentDay
        ).show()
    }
}