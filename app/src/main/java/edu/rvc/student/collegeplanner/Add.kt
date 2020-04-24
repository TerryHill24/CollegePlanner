package edu.rvc.student.collegeplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDateTime

class Add : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val btnBack = findViewById<Button>(R.id.btnMainMenu)
        val addToPlanner = findViewById <Button>(R.id.btnAddTo)
        val planner = findViewById <Button>(R.id.btnViews)
        val blank = findViewById<TextView>(R.id.textBlank)
        val addDate = findViewById <Button>(R.id.btnAddDate)
        val txtAssign = findViewById<EditText>(R.id.txtAssign)
        val txtCourse = findViewById<EditText>(R.id.txtCourse)
        val txtDueBy = findViewById<EditText>(R.id.txtDueBy)
        val preferences = getSharedPreferences ("data", Context.MODE_PRIVATE)

        val addIt = findViewById<TextView>(R.id.txtDateToAddTo)
        addIt.setText(preferences.getString("date1", ""))
        txtCourse.setText(preferences.getString("course", ""))
        txtAssign.setText(preferences.getString("task", ""))
        txtDueBy.setText(preferences.getString("due", ""))

        val cope = addIt.text.toString()
        var dayWeek1 = cope.contains("Monday")
        var dayWeek2 = cope.contains("Tuesday")
        var dayWeek3 = cope.contains("Wednesday")
        var dayWeek4 = cope.contains("Thursday")
        var dayWeek5 = cope.contains("Friday")
        var dayWeek6 = cope.contains("Saturday")
        var dayWeek7 = cope.contains("Sunday")

        var day = LocalDateTime.now().dayOfWeek
        var monday = "MONDAY"
        var tuesday = "TUESDAY"
        var wednesday = "WEDNESDAY"
        var thursday = "THURSDAY"
        var friday = "FRIDAY"
        var saturday = "SATURDAY"
        var sunday = "SUNDAY"

        txtCourse.requestFocus()

        addDate.setOnClickListener(View.OnClickListener {
            val editor = preferences.edit()
            editor.putString("course", txtCourse.text.toString())
            editor.putString("task", txtAssign.text.toString())
            editor.putString("due", txtDueBy.text.toString())
            editor.commit()

            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        })

        addToPlanner.setOnClickListener {
            val editor = preferences.edit()

            if (txtCourse.text.toString() == "") {
                Toast.makeText(this, "Error. Please enter a Course Name/Number.", Toast.LENGTH_LONG)
                    .show()
            }
            if (txtAssign.text.toString() == "") {
                Toast.makeText(this, "Error. Please enter an Assignment.", Toast.LENGTH_LONG).show()
            }
            if (txtDueBy.text.toString() == "") {
                Toast.makeText(this, "Error. Please enter a due date.", Toast.LENGTH_LONG).show()
            }
            if (addIt.toString() == "") {
                Toast.makeText(this, "Error. Please enter a valid date.", Toast.LENGTH_LONG).show()
            }

            if (txtCourse.text.toString() != "" && txtAssign.text.toString() != "" && txtDueBy.text.toString() != "" && addIt.toString() != "") {

                if (dayWeek1) {
                    editor.putString("course1", txtCourse.text.toString())
                    editor.putString("task1", txtAssign.text.toString())
                    editor.putString("due1", txtDueBy.text.toString())
                    editor.commit()
                    addIt.text = ("")
                    txtCourse.setText("")
                    txtAssign.setText("")
                    txtDueBy.setText("")
                    editor.putString("course", blank.text.toString())
                    editor.putString("task", blank.text.toString())
                    editor.putString("due", blank.text.toString())
                    editor.putString("date1", blank.text.toString())
                    editor.commit()
                    Toast.makeText(this, "Assignment Successfully Added!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, Planner1::class.java)
                    startActivity(intent)
                } else {
                    if (dayWeek2) {
                        editor.putString("course2", txtCourse.text.toString())
                        editor.putString("task2", txtAssign.text.toString())
                        editor.putString("due2", txtDueBy.text.toString())
                        editor.commit()
                        addIt.text = ("")
                        txtCourse.setText("")
                        txtAssign.setText("")
                        txtDueBy.setText("")
                        editor.putString("course", blank.text.toString())
                        editor.putString("task", blank.text.toString())
                        editor.putString("due", blank.text.toString())
                        editor.putString("date1", blank.text.toString())
                        editor.commit()
                        Toast.makeText(this, "Assignment Successfully Added!", Toast.LENGTH_LONG)
                            .show()
                        val intent = Intent(this, Nextplanner::class.java)
                        startActivity(intent)
                    } else {
                        if (dayWeek3) {
                            editor.putString("course3", txtCourse.text.toString())
                            editor.putString("task3", txtAssign.text.toString())
                            editor.putString("due3", txtDueBy.text.toString())
                            editor.commit()
                            addIt.text = ("")
                            txtCourse.setText("")
                            txtAssign.setText("")
                            txtDueBy.setText("")
                            editor.putString("course", blank.text.toString())
                            editor.putString("task", blank.text.toString())
                            editor.putString("due", blank.text.toString())
                            editor.putString("date1", blank.text.toString())
                            editor.commit()
                            Toast.makeText(
                                this,
                                "Assignment Successfully Added!",
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(this, PlannerThree::class.java)
                            startActivity(intent)
                        } else {
                            if (dayWeek4) {
                                editor.putString("course4", txtCourse.text.toString())
                                editor.putString("task4", txtAssign.text.toString())
                                editor.putString("due4", txtDueBy.text.toString())
                                editor.commit()
                                addIt.text = ("")
                                txtCourse.setText("")
                                txtAssign.setText("")
                                txtDueBy.setText("")
                                editor.putString("course", blank.text.toString())
                                editor.putString("task", blank.text.toString())
                                editor.putString("due", blank.text.toString())
                                editor.putString("date1", blank.text.toString())
                                editor.commit()
                                Toast.makeText(
                                    this,
                                    "Assignment Successfully Added!",
                                    Toast.LENGTH_LONG
                                ).show()
                                val intent = Intent(this, PlannerFour::class.java)
                                startActivity(intent)
                            } else {
                                if (dayWeek5) {
                                    editor.putString("course5", txtCourse.text.toString())
                                    editor.putString("task5", txtAssign.text.toString())
                                    editor.putString("due5", txtDueBy.text.toString())
                                    editor.commit()
                                    addIt.text = ("")
                                    txtCourse.setText("")
                                    txtAssign.setText("")
                                    txtDueBy.setText("")
                                    editor.putString("course", blank.text.toString())
                                    editor.putString("task", blank.text.toString())
                                    editor.putString("due", blank.text.toString())
                                    editor.putString("date1", blank.text.toString())
                                    editor.commit()
                                    Toast.makeText(
                                        this,
                                        "Assignment Successfully Added!",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    val intent = Intent(this, PlannerFive::class.java)
                                    startActivity(intent)
                                } else {
                                    if (dayWeek6) {
                                        editor.putString("course6", txtCourse.text.toString())
                                        editor.putString("task6", txtAssign.text.toString())
                                        editor.putString("due6", txtDueBy.text.toString())
                                        editor.commit()
                                        addIt.text = ("")
                                        txtCourse.setText("")
                                        txtAssign.setText("")
                                        txtDueBy.setText("")
                                        editor.putString("course", blank.text.toString())
                                        editor.putString("task", blank.text.toString())
                                        editor.putString("due", blank.text.toString())
                                        editor.putString("date1", blank.text.toString())
                                        editor.commit()
                                        Toast.makeText(
                                            this,
                                            "Assignment Successfully Added!",
                                            Toast.LENGTH_LONG
                                        ).show()
                                        val intent = Intent(this, PlannerSix::class.java)
                                        startActivity(intent)
                                    } else {
                                        if (dayWeek7) {
                                            editor.putString("course7", txtCourse.text.toString())
                                            editor.putString("task7", txtAssign.text.toString())
                                            editor.putString("due7", txtDueBy.text.toString())
                                            editor.commit()
                                            addIt.text = ("")
                                            txtCourse.setText("")
                                            txtAssign.setText("")
                                            txtDueBy.setText("")
                                            editor.putString("course", blank.text.toString())
                                            editor.putString("task", blank.text.toString())
                                            editor.putString("due", blank.text.toString())
                                            editor.putString("date1", blank.text.toString())
                                            editor.commit()
                                            Toast.makeText(
                                                this,
                                                "Assignment Successfully Added!",
                                                Toast.LENGTH_LONG
                                            ).show()
                                            val intent = Intent(this, PlannerSeven::class.java)
                                            startActivity(intent)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        btnBack.setOnClickListener(View.OnClickListener {
            val editor = preferences.edit()
            editor.putString("date1", blank.text.toString())
            editor.commit()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        planner.setOnClickListener(View.OnClickListener {
            val editor = preferences.edit()
            editor.putString("date1", blank.text.toString())
            editor.commit()
            this.finish()
        })

        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }

    //function to hide keyboard goes right before the last right bracket of Class MainActivity
//should auto import android.content.Context
//should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}



