package edu.rvc.student.collegeplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import java.time.LocalDate

class CalendarTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_two)

        val backed = findViewById<Button>(R.id.btnCalen)
        val calendarView = findViewById<CalendarView>(R.id.calendarView2)

        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.
            val msg = "Selected date is " + (month + 1) + "/" + dayOfMonth + "/" + year
            Toast.makeText(this@CalendarTwo, msg, Toast.LENGTH_LONG).show()

            val dateTime = LocalDate.of(year, (month + 1), dayOfMonth)

            backed.setOnClickListener(View.OnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            })


        }
    }
}