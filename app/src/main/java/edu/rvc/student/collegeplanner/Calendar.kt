package edu.rvc.student.collegeplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class Calendar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val theDate = findViewById<TextView>(R.id.textView)
        val txtRange = findViewById<TextView>(R.id.txtRange)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        val current = LocalDateTime.now()
        var dateTimes1 = current + Period.ofDays(-6)
        var dateTimes2 = current + Period.ofDays(-5)
        var dateTimes3 = current + Period.ofDays(-4)
        var dateTimes4 = current + Period.ofDays(-3)
        var dateTimes5 = current + Period.ofDays(-2)
        var dateTimes6 = current + Period.ofDays(-1)
        var dateTimes7 = current + Period.ofDays(0)
        var dateTimes8 = current + Period.ofDays(1)
        var dateTimes9 = current + Period.ofDays(2)
        var dateTimes10 = current + Period.ofDays(3)
        var dateTimes11 = current + Period.ofDays(4)
        var dateTimes12 = current + Period.ofDays(5)
        var dateTimes13 = current + Period.ofDays(6)


        var day = LocalDateTime.now().dayOfWeek
        var monday = "MONDAY"
        var tuesday = "TUESDAY"
        var wednesday = "WEDNESDAY"
        var thursday = "THURSDAY"
        var friday = "FRIDAY"
        var saturday = "SATURDAY"
        var sunday = "SUNDAY"


        if (day.toString() == monday.toString()) {
            var dateTime1 = current + Period.ofDays(0)
            var dateTime2 = current + Period.ofDays(6)
            txtRange.text = " Select a Date Range From: \n" + dateTime1.format(
                java.time.format.DateTimeFormatter.ofLocalizedDate(
                    java.time.format.FormatStyle.FULL
                )
            ) + " to " + dateTime2.format(
                java.time.format.DateTimeFormatter.ofLocalizedDate(
                    java.time.format.FormatStyle.FULL
                )
            )
        } else {
            if (day.toString() == tuesday.toString()) {
                var dateTime1 = current + Period.ofDays(-1)
                var dateTime2 = current + Period.ofDays(5)
                txtRange.text = " Select a Date Range From: \n" + dateTime1.format(
                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                        java.time.format.FormatStyle.FULL
                    )
                ) + " to " + dateTime2.format(
                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                        java.time.format.FormatStyle.FULL
                    )
                )

            } else {
                if (day.toString() == wednesday.toString()) {
                    var dateTime1 = current + Period.ofDays(-2)
                    var dateTime2 = current + Period.ofDays(4)
                    txtRange.text = " Select a Date Range From: \n" + dateTime1.format(
                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                            java.time.format.FormatStyle.FULL
                        )
                    ) + " to " + dateTime2.format(
                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                            java.time.format.FormatStyle.FULL
                        )
                    )
                } else {
                    if (day.toString() == thursday.toString()) {
                        var dateTime1 = current + Period.ofDays(-3)
                        var dateTime2 = current + Period.ofDays(3)
                        txtRange.text = " Select a Date Range From: \n" + dateTime1.format(
                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                java.time.format.FormatStyle.FULL
                            )
                        ) + " to " + dateTime2.format(
                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                java.time.format.FormatStyle.FULL
                            )
                        )
                    } else {
                        if (day.toString() == friday.toString()) {
                            var dateTime1 = current + Period.ofDays(-4)
                            var dateTime2 = current + Period.ofDays(2)
                            txtRange.text = " Select a Date Range From: \n" + dateTime1.format(
                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                    java.time.format.FormatStyle.FULL
                                )
                            ) + " to " + dateTime2.format(
                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                    java.time.format.FormatStyle.FULL
                                )
                            )
                        } else {
                            if (day.toString() == saturday.toString()) {
                                var dateTime1 = current + Period.ofDays(-5)
                                var dateTime2 = current + Period.ofDays(1)
                                txtRange.text = " Select a Date Range From: \n" + dateTime1.format(
                                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                                        java.time.format.FormatStyle.FULL
                                    )
                                ) + " to " + dateTime2.format(
                                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                                        java.time.format.FormatStyle.FULL
                                    )
                                )
                            } else {
                                if (day.toString() == sunday.toString()) {
                                    var dateTime1 = current + Period.ofDays(-6)
                                    var dateTime2 = current + Period.ofDays(0)
                                    txtRange.text =
                                        " Select a Date Range From: \n" + dateTime1.format(
                                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                java.time.format.FormatStyle.FULL
                                            )
                                        ) + " to " + dateTime2.format(
                                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                java.time.format.FormatStyle.FULL
                                            )
                                        )
                                }
                            }
                        }
                    }
                }
            }
        }


        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.
            val msg = "Selected date is " + (month + 1) + "/" + dayOfMonth + "/" + year

            var dateTime = LocalDate.of(year, (month + 1), dayOfMonth)

            theDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
            editor.putString("date1", theDate.text.toString())
            editor.commit()

            if (day.toString() == monday.toString()) {
                if (theDate.text.toString() == dateTimes13.format(
                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                            java.time.format.FormatStyle.FULL
                        )
                    ) || theDate.text.toString() == dateTimes7.format(
                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                            java.time.format.FormatStyle.FULL
                        )
                    ) || theDate.text.toString() == dateTimes8.format(
                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                            java.time.format.FormatStyle.FULL
                        )
                    ) || theDate.text.toString() == dateTimes9.format(
                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                            java.time.format.FormatStyle.FULL
                        )
                    ) || theDate.text.toString() == dateTimes10.format(
                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                            java.time.format.FormatStyle.FULL
                        )
                    ) || theDate.text.toString() == dateTimes11.format(
                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                            java.time.format.FormatStyle.FULL
                        )
                    ) || theDate.text.toString() == dateTimes12.format(
                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                            java.time.format.FormatStyle.FULL
                        )
                    )
                ) {
                    //Intent is used to send data between activities
                    val intent = Intent(this, Add::class.java)
                    //Go to second activity
                    startActivity(intent)
                }
            else {
                Toast.makeText(this, "Invalid Range. Please try again.", Toast.LENGTH_LONG).show() }

            } else {
                if (day.toString() == tuesday.toString()) {
                    if (theDate.text.toString() == dateTimes6.format(
                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                java.time.format.FormatStyle.FULL
                            )
                        ) || theDate.text.toString() == dateTimes7.format(
                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                java.time.format.FormatStyle.FULL
                            )
                        ) || theDate.text.toString() == dateTimes8.format(
                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                java.time.format.FormatStyle.FULL
                            )
                        ) || theDate.text.toString() == dateTimes9.format(
                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                java.time.format.FormatStyle.FULL
                            )
                        ) || theDate.text.toString() == dateTimes10.format(
                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                java.time.format.FormatStyle.FULL
                            )
                        ) || theDate.text.toString() == dateTimes11.format(
                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                java.time.format.FormatStyle.FULL
                            )
                        ) || theDate.text.toString() == dateTimes12.format(
                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                java.time.format.FormatStyle.FULL
                            )
                        )
                    ) {
                        //Intent is used to send data between activities
                        val intent = Intent(this, Add::class.java)
                        //Go to second activity
                        startActivity(intent)
                    } else {
                    Toast.makeText(this, "Invalid Range. Please try again.", Toast.LENGTH_LONG).show() }


                } else {
                    if (day.toString() == wednesday.toString()) {
                        if (theDate.text.toString() == dateTimes5.format(
                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                    java.time.format.FormatStyle.FULL
                                )
                            ) || theDate.text.toString() == dateTimes6.format(
                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                    java.time.format.FormatStyle.FULL
                                )
                            ) || theDate.text.toString() == dateTimes7.format(
                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                    java.time.format.FormatStyle.FULL
                                )
                            ) || theDate.text.toString() == dateTimes8.format(
                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                    java.time.format.FormatStyle.FULL
                                )
                            ) || theDate.text.toString() == dateTimes9.format(
                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                    java.time.format.FormatStyle.FULL
                                )
                            ) || theDate.text.toString() == dateTimes10.format(
                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                    java.time.format.FormatStyle.FULL
                                )
                            ) || theDate.text.toString() == dateTimes11.format(
                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                    java.time.format.FormatStyle.FULL
                                )
                            )
                        ) {
                            //Intent is used to send data between activities
                            val intent = Intent(this, Add::class.java)
                            //Go to second activity
                            startActivity(intent)
                        } else {
                        Toast.makeText(this, "Invalid Range. Please try again.", Toast.LENGTH_LONG).show() }

                    } else {
                        if (day.toString() == thursday.toString()) {
                            if (theDate.text.toString() == dateTimes4.format(
                                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                                        java.time.format.FormatStyle.FULL
                                    )
                                ) || theDate.text.toString() == dateTimes5.format(
                                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                                        java.time.format.FormatStyle.FULL
                                    )
                                ) || theDate.text.toString() == dateTimes6.format(
                                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                                        java.time.format.FormatStyle.FULL
                                    )
                                ) || theDate.text.toString() == dateTimes7.format(
                                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                                        java.time.format.FormatStyle.FULL
                                    )
                                ) || theDate.text.toString() == dateTimes8.format(
                                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                                        java.time.format.FormatStyle.FULL
                                    )
                                ) || theDate.text.toString() == dateTimes9.format(
                                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                                        java.time.format.FormatStyle.FULL
                                    )
                                ) || theDate.text.toString() == dateTimes10.format(
                                    java.time.format.DateTimeFormatter.ofLocalizedDate(
                                        java.time.format.FormatStyle.FULL
                                    )
                                )
                            ) {
                                //Intent is used to send data between activities
                                val intent = Intent(this, Add::class.java)
                                //Go to second activity
                                startActivity(intent)
                            }  else {
                            Toast.makeText(this, "Invalid Range. Please try again.", Toast.LENGTH_LONG).show() }

                        } else {
                            if (day.toString() == friday.toString()) {
                                if (theDate.text.toString() == dateTimes3.format(
                                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                                            java.time.format.FormatStyle.FULL
                                        )
                                    ) || theDate.text.toString() == dateTimes4.format(
                                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                                            java.time.format.FormatStyle.FULL
                                        )
                                    ) || theDate.text.toString() == dateTimes5.format(
                                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                                            java.time.format.FormatStyle.FULL
                                        )
                                    ) || theDate.text.toString() == dateTimes6.format(
                                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                                            java.time.format.FormatStyle.FULL
                                        )
                                    ) || theDate.text.toString() == dateTimes7.format(
                                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                                            java.time.format.FormatStyle.FULL
                                        )
                                    ) || theDate.text.toString() == dateTimes8.format(
                                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                                            java.time.format.FormatStyle.FULL
                                        )
                                    ) || theDate.text.toString() == dateTimes9.format(
                                        java.time.format.DateTimeFormatter.ofLocalizedDate(
                                            java.time.format.FormatStyle.FULL
                                        )
                                    )
                                ) {
                                    //Intent is used to send data between activities
                                    val intent = Intent(this, Add::class.java)
                                    //Go to second activity
                                    startActivity(intent)
                                }
                            else {
                                Toast.makeText(this, "Invalid Range. Please try again.", Toast.LENGTH_LONG).show() }


                            } else {
                                if (day.toString() == saturday.toString()) {
                                    if (theDate.text.toString() == dateTimes2.format(
                                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                java.time.format.FormatStyle.FULL
                                            )
                                        ) || theDate.text.toString() == dateTimes3.format(
                                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                java.time.format.FormatStyle.FULL
                                            )
                                        ) || theDate.text.toString() == dateTimes4.format(
                                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                java.time.format.FormatStyle.FULL
                                            )
                                        ) || theDate.text.toString() == dateTimes5.format(
                                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                java.time.format.FormatStyle.FULL
                                            )
                                        ) || theDate.text.toString() == dateTimes6.format(
                                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                java.time.format.FormatStyle.FULL
                                            )
                                        ) || theDate.text.toString() == dateTimes7.format(
                                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                java.time.format.FormatStyle.FULL
                                            )
                                        ) || theDate.text.toString() == dateTimes8.format(
                                            java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                java.time.format.FormatStyle.FULL
                                            )
                                        )
                                    ) {
                                        //Intent is used to send data between activities
                                        val intent = Intent(this, Add::class.java)
                                        //Go to second activity
                                        startActivity(intent)
                                    }  else {
                                    Toast.makeText(this, "Invalid Range. Please try again.", Toast.LENGTH_LONG).show() }

                                } else {
                                    if (day.toString() == sunday.toString()) {
                                        if (theDate.text.toString() == dateTimes1.format(
                                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                    java.time.format.FormatStyle.FULL
                                                )
                                            ) || theDate.text.toString() == dateTimes2.format(
                                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                    java.time.format.FormatStyle.FULL
                                                )
                                            ) || theDate.text.toString() == dateTimes3.format(
                                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                    java.time.format.FormatStyle.FULL
                                                )
                                            ) || theDate.text.toString() == dateTimes4.format(
                                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                    java.time.format.FormatStyle.FULL
                                                )
                                            ) || theDate.text.toString() == dateTimes5.format(
                                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                    java.time.format.FormatStyle.FULL
                                                )
                                            ) || theDate.text.toString() == dateTimes6.format(
                                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                    java.time.format.FormatStyle.FULL
                                                )
                                            ) || theDate.text.toString() == dateTimes7.format(
                                                java.time.format.DateTimeFormatter.ofLocalizedDate(
                                                    java.time.format.FormatStyle.FULL
                                                )
                                            )
                                        ) {
                                            //Intent is used to send data between activities
                                            val intent = Intent(this, Add::class.java)
                                            //Go to second activity
                                            startActivity(intent)
                                        }  else {
                                        Toast.makeText(this, "Invalid Range. Please try again.", Toast.LENGTH_LONG).show() }
                                    }
                                }
                            }
                        }
                    }
                }
            }


        }
    }
}




