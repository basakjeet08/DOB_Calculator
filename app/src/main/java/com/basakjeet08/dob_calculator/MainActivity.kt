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
        val myCalendar = Calendar.getInstance()
        val tvSelectedDate : TextView = findViewById(R.id.tvSelectedDate)
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        tvSelectedDate.text = "$day/${month+1}/$year"

        btnDatePicker.setOnClickListener {
            clickDatePicker(day,month,year,tvSelectedDate)
        }
    }
    private fun clickDatePicker(day:Int , month:Int , year:Int , tvSelectedDate : TextView){
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view , selectedYear , selectedMonth , dayOfMonth ->
            tvSelectedDate.text = "$dayOfMonth/${selectedMonth+1}/$selectedYear"
            val todayDate = year*365 + day + when(month+1){
                1,3,5,7,9,11 -> 31
                4,6,8,10,12 -> 30
                else -> 27
            }
            val bodDate = selectedYear*365 + dayOfMonth + when(selectedMonth+1){
                1,3,5,7,9,11 -> 31
                4,6,8,10,12 -> 30
                else -> 27
            }
            val differenceInDays = todayDate - bodDate

            val tvTimeInMin : TextView = findViewById(R.id.tvTimeInMin)
            tvTimeInMin.text = "$differenceInDays"
        },
            year,month,day
        ).show()
    }
}