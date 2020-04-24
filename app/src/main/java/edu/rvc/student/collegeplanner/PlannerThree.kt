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

class PlannerThree : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner_three)


        val btnBack = findViewById<Button>(R.id.btnMenu4)
        val next = findViewById<Button>(R.id.btnNext3)
        val menu = findViewById<Button>(R.id.btnMenu5)
        val btnAdd = findViewById<Button>(R.id.btnAdd4)
        val txtTomDate = findViewById<TextView>(R.id.txtDateTomorrow2)
        val fire3 = findViewById<TextView>(R.id.txtDisplay3)
        val txtToday333 = findViewById<TextView>(R.id.txtToday333)
        val txtClear33 = findViewById<TextView>(R.id.txtClear33)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        var ref = FirebaseDatabase.getInstance().getReference("Wednesday")

        //import current date
        var dateTime = LocalDateTime.now()
        var counter = (preferences.getInt("counter4", 0))
        dateTime += Period.ofDays(counter)
        txtTomDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        if (counter == 0){
            txtToday333.text = "TODAY"
        }
        if (counter == 1){
            txtToday333.text = "TOMORROW"
        }

        val course = (preferences.getString("course3", ""))
        var task = (preferences.getString("task3", ""))
        val due = (preferences.getString("due3", ""))
        task = "$task      $due"

        if(course.toString() != "") {
            var messageid3 = ref.push().key
            var messageg3 = Message(messageid3.toString(), course.toString(), task.toString(), due.toString()
            )
            ref.child(messageid3.toString()).setValue(messageg3).addOnCompleteListener {
                Toast.makeText(this, "Task Added!", Toast.LENGTH_LONG).show()
            }
        }
        //listen and show data changes
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                fire3.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    fire3.text =
                        fire3.text.toString() + "\n" + it.child("name").value.toString() + "      "  + it.child(
                            "message" ).value.toString()

                    editor.putString("date1", txtClear33.text.toString())
                    editor.putString("course3", txtClear33.text.toString())
                    editor.putString("task3", txtClear33.text.toString())
                    editor.putString("due3", txtClear33.text.toString())
                    editor.commit()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Wednesday", "Failed to read value.", error.toException())
            }
        })

        btnBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Nextplanner::class.java)
            startActivity(intent)
        })

        btnAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivity(intent)
        })
        next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlannerFour::class.java)
            startActivity(intent)
        })

        menu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


    }
}
