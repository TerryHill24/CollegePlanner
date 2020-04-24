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

class PlannerFour : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner_four)

        val btnBack = findViewById<Button>(R.id.btnMenu7)
        val next = findViewById<Button>(R.id.btnNext4)
        val menu = findViewById<Button>(R.id.btnMenu6)
        val btnAdd = findViewById<Button>(R.id.btnAdd5)
        val txtTomDate = findViewById<TextView>(R.id.txtDateTomorrow3)
        val fire4 = findViewById<TextView>(R.id.txtDisplay4)
        val txtToday444 = findViewById<TextView>(R.id.txtToday444)
        val txtClear44 = findViewById<TextView>(R.id.txtClear44)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        var ref = FirebaseDatabase.getInstance().getReference("Thursday")

        //import current date
        var dateTime = LocalDateTime.now()
        var counter = (preferences.getInt("counter5", 0))
        dateTime += Period.ofDays(counter)
        txtTomDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        if (counter == 0){
            txtToday444.text = "TODAY"
        }
        if (counter == 1){
            txtToday444.text = "TOMORROW"
        }

        val course = (preferences.getString("course4", ""))
        var task = (preferences.getString("task4", ""))
        val due = (preferences.getString("due4", ""))
        task = "$task      $due"

        if(course.toString() != "") {
            var messageid4 = ref.push().key
            var messageg4 = Message(messageid4.toString(), course.toString(), task.toString(), due.toString())
            ref.child(messageid4.toString()).setValue(messageg4).addOnCompleteListener {
        }
        }
        //listen and show data changes
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                fire4.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    fire4.text =
                        fire4.text.toString() + "\n" + it.child("name").value.toString() + "      "  + it.child(
                            "message" ).value.toString()

                    editor.putString("date1", txtClear44.text.toString())
                    editor.putString("course4", txtClear44.text.toString())
                    editor.putString("task4", txtClear44.text.toString())
                    editor.putString("due4", txtClear44.text.toString())
                    editor.commit()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Thursday", "Failed to read value.", error.toException())
            }
        })

        btnBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlannerThree::class.java)
            startActivity(intent)
        })

        btnAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivity(intent)
        })
        next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlannerFive::class.java)
            startActivity(intent)
        })

        menu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


    }
}


