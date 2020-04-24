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


class Nextplanner : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextplanner)
        val back = findViewById<Button>(R.id.btnMenu2)
        val menu = findViewById<Button>(R.id.btnMenu3)
        val add = findViewById<Button>(R.id.btnAdd3)
        val next = findViewById<Button>(R.id.btnNext2)
        val txtTomDate = findViewById<TextView>(R.id.txtDateTomorrow)
        val fire2 = findViewById<TextView>(R.id.txtDisplay2)
        val txtClear22 = findViewById<TextView>(R.id.txtClear22)
        val txtToday222 = findViewById<TextView>(R.id.txtToday222)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        var ref = FirebaseDatabase.getInstance().getReference("Tuesday")

        //import current date
        var dateTime = LocalDateTime.now()
        var counter = (preferences.getInt("counter3", 0))
        dateTime += Period.ofDays(counter)
        txtTomDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        if (counter == 0){
            txtToday222.text = "TODAY"
        }
        if (counter == 1){
            txtToday222.text = "TOMORROW"
        }

        val course = (preferences.getString("course2", ""))
        var task = (preferences.getString("task2", ""))
        val due = (preferences.getString("due2", ""))
        task = "$task      $due"

        if(course.toString() != "") {
            var messageid2 = ref.push().key
            var messageg2 = Message(
                messageid2.toString(),
                course.toString(),
                task.toString(),
                due.toString()
            )
            ref.child(messageid2.toString()).setValue(messageg2).addOnCompleteListener {
            }
        }
        //listen and show data changes
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                fire2.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    fire2.text =
                        fire2.text.toString() + "\n" + it.child("name").value.toString() + "      "  + it.child(
                            "message" ).value.toString()

                    editor.putString("date1", txtClear22.text.toString())
                    editor.putString("course2", txtClear22.text.toString())
                    editor.putString("task2", txtClear22.text.toString())
                    editor.putString("due2", txtClear22.text.toString())
                    editor.commit()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Tuesday", "Failed to read value.", error.toException())
            }
        })

        back.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Planner1::class.java)
            startActivity(intent)
        })

        add.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivity(intent)
        })
        next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlannerThree::class.java)
            startActivity(intent)
        })
        menu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
}


