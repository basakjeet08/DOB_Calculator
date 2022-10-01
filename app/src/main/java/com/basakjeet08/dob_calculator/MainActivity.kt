package com.basakjeet08.dob_calculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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
            //Toast.makeText(this,"$dayOfMonth/${selectedMonth+1}/$selectedYear" , Toast.LENGTH_LONG).show()
            tvSelectedDate.text = "$dayOfMonth/${selectedMonth+1}/$selectedYear"

            val todayDate = year*365 + month*30 + day
            val bodDate = selectedYear*365 + selectedMonth*30 + dayOfMonth
            val differenceInDays = todayDate - bodDate


        },
            year,month,day
        ).show()

        Toast.makeText(this,"$day/${month+1}/$year" , Toast.LENGTH_LONG).show()
    }
}