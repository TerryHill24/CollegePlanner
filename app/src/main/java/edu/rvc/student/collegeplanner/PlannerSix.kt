package edu.rvc.student.collegeplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.Period
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener

class PlannerSix : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner_six)

        val btnBack = findViewById<Button>(R.id.btnMenu13)
        val next = findViewById<Button>(R.id.btnNext6)
        val btnAdd = findViewById<Button>(R.id.btnAdd7)
        val menu = findViewById<Button>(R.id.btnMenu12)
        val txtTomDate = findViewById<TextView>(R.id.txtDateTomorrow5)
        val fire6 = findViewById<TextView>(R.id.txtDisplay6)
        val txtToday666 = findViewById<TextView>(R.id.txtToday666)
        val txtClear66 = findViewById<TextView>(R.id.txtClear66)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        var ref = FirebaseDatabase.getInstance().getReference("Saturday")

        //import current date
        var dateTime = LocalDateTime.now()
        var counter = (preferences.getInt("counter7", 0))
        dateTime += Period.ofDays(counter)
        txtTomDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        if (counter == 0){
            txtToday666.text = "TODAY"
        }
        if (counter == 1){
            txtToday666.text = "TOMORROW"
        }

        val course = (preferences.getString("course6", ""))
        var task = (preferences.getString("task6", ""))
        val due = (preferences.getString("due6", ""))
        task = "$task      $due"

        if(course.toString() != "") {
            var messageid6 = ref.push().key
            var messageg6 = Message(
                messageid6.toString(),
                course.toString(),
                task.toString(),
                due.toString()
            )
            ref.child(messageid6.toString()).setValue(messageg6).addOnCompleteListener {
            }
        }
        //listen and show data changes
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                fire6.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    fire6.text =
                        fire6.text.toString() + "\n" + it.child("name").value.toString() + "      "  + it.child(
                            "message" ).value.toString()

                    editor.putString("date1", txtClear66.text.toString())
                    editor.putString("course6", txtClear66.text.toString())
                    editor.putString("task6", txtClear66.text.toString())
                    editor.putString("due6", txtClear66.text.toString())
                    editor.commit()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Saturday", "Failed to read value.", error.toException())
            }
        })

        btnBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlannerFive::class.java)
            startActivity(intent)
        })

        btnAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivity(intent)
        })
        next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlannerSeven::class.java)
            startActivity(intent)
        })

        menu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


    }
}



