package edu.rvc.student.collegeplanner

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bind objects
        val btnCal = findViewById<Button>(R.id.btnDayPlanner)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val btnCalendar = findViewById<Button>(R.id.btnCalendar)
        val txtHeadDate = findViewById<TextView>(R.id.txtHeadDate)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        var day = LocalDateTime.now().dayOfWeek
        var monday = "MONDAY"
        var tuesday = "TUESDAY"
        var wednesday = "WEDNESDAY"
        var thursday = "THURSDAY"
        var friday = "FRIDAY"
        var saturday = "SATURDAY"
        var sunday = "SUNDAY"

        var dateTime = LocalDateTime.now()
        txtHeadDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        if( day.toString() == monday.toString()) {
            editor.putInt("counter1", -1)
            editor.putInt("counter2", 0)
            editor.putInt("counter3", 1)
            editor.putInt("counter4", 2)
            editor.putInt("counter5", 3)
            editor.putInt("counter6", 4)
            editor.putInt("counter7", 5)
            editor.putInt("counter8", 6)
            editor.commit()

        } else {
            if (day.toString() == tuesday.toString()) {
                editor.putInt("counter1", -2)
                editor.putInt("counter2", -1)
                editor.putInt("counter3", 0)
                editor.putInt("counter4", 1)
                editor.putInt("counter5", 2)
                editor.putInt("counter6", 3)
                editor.putInt("counter7", 4)
                editor.putInt("counter8", 5)
                editor.commit()

            } else {
                if (day.toString() == wednesday.toString()) {
                    editor.putInt("counter1", -3)
                    editor.putInt("counter2", -2)
                    editor.putInt("counter3", -1)
                    editor.putInt("counter4", 0)
                    editor.putInt("counter5", 1)
                    editor.putInt("counter6", 2)
                    editor.putInt("counter7", 3)
                    editor.putInt("counter8", 4)
                    editor.commit()
                } else {
                    if (day.toString() == thursday.toString()) {
                        editor.putInt("counter1", -4)
                        editor.putInt("counter2", -3)
                        editor.putInt("counter3", -2)
                        editor.putInt("counter4", -1)
                        editor.putInt("counter5", 0)
                        editor.putInt("counter6", 1)
                        editor.putInt("counter7", 2)
                        editor.putInt("counter8", 3)
                        editor.commit()
                    }else {
                        if (day.toString() == friday.toString()) {
                            editor.putInt("counter1", -5)
                            editor.putInt("counter2", -4)
                            editor.putInt("counter3", -3)
                            editor.putInt("counter4", -2)
                            editor.putInt("counter5", -1)
                            editor.putInt("counter6", 0)
                            editor.putInt("counter7", 1)
                            editor.putInt("counter8", 2)
                            editor.commit()
                        } else {
                            if (day.toString() == saturday.toString()) {
                                editor.putInt("counter1", -6)
                                editor.putInt("counter2", -5)
                                editor.putInt("counter3", -4)
                                editor.putInt("counter4", -3)
                                editor.putInt("counter5", -2)
                                editor.putInt("counter6", -1)
                                editor.putInt("counter7", 0)
                                editor.putInt("counter8", 1)
                                editor.commit()
                            } else {
                                if (day.toString() == sunday.toString()) {
                                    editor.putInt("counter1", -7)
                                    editor.putInt("counter2", -6)
                                    editor.putInt("counter3", -5)
                                    editor.putInt("counter4", -4)
                                    editor.putInt("counter5", -3)
                                    editor.putInt("counter6", -2)
                                    editor.putInt("counter7", -1)
                                    editor.putInt("counter8", 0)
                                    editor.commit()}
                            }
                        }
                    }
                }
            }
        }

        btnCal.setOnClickListener(View.OnClickListener {
            if( day.toString() == monday.toString()) {
                editor.putInt("dayCounter", 0)
                editor.commit()
                val intent = Intent(this, Planner1::class.java)
                startActivity(intent)
            } else {
                if (day.toString() == tuesday.toString()) {
                    editor.putInt("dayCounter", 0)
                    editor.commit()
                    val intent = Intent(this, Nextplanner::class.java)
                    startActivity(intent)
                } else {
                    if (day.toString() == wednesday.toString()) {
                        editor.putInt("dayCounter", 0)
                        editor.commit()
                        val intent = Intent(this, PlannerThree::class.java)
                        startActivity(intent)
                    } else {
                        if (day.toString() == thursday.toString()) {
                            editor.putInt("dayCounter", 0)
                            editor.commit()
                            val intent = Intent(this, PlannerFour::class.java)
                            startActivity(intent)
                        }else {
                            if (day.toString() == friday.toString()) {
                                editor.putInt("dayCounter", 0)
                                editor.commit()
                                val intent = Intent(this, PlannerFive::class.java)
                                startActivity(intent)
                            } else {
                                if (day.toString() == saturday.toString()) {
                                    editor.putInt("dayCounter", 0)
                                    editor.commit()
                                    val intent = Intent(this, PlannerSix::class.java)
                                    startActivity(intent)
                                } else {
                                    if (day.toString() == sunday.toString()) {
                                        editor.putInt("dayCounter", 0)
                                        editor.commit()
                                        val intent = Intent(this, PlannerSeven::class.java)
                                        startActivity(intent) }
                                }
                            }
                        }
                    }
                }
            }
        })
        btnAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivity(intent)
        })
        btnSearch.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlanSearch::class.java)
            startActivity(intent)
        })
        btnCalendar.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CalendarTwo::class.java)
            startActivity(intent)
        })
    }
}

