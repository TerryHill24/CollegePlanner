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

class PlannerFive : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner_five)

        val btnBack = findViewById<Button>(R.id.btnMenu9)
        val next = findViewById<Button>(R.id.btnNext5)
        val btnAdd = findViewById<Button>(R.id.btnAdd6)
        val menu = findViewById<Button>(R.id.btnMenu8)
        val txtTomDate = findViewById<TextView>(R.id.txtDateTomorrow4)
        val fire5 = findViewById<TextView>(R.id.txtDisplay5)
        val txtToday555 = findViewById<TextView>(R.id.txtToday555)
        val txtClear55 = findViewById<TextView>(R.id.txtClear55)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        var ref = FirebaseDatabase.getInstance().getReference("Friday")

        //import current date
        var dateTime = LocalDateTime.now()
        var counter = (preferences.getInt("counter6", 0))
        dateTime += Period.ofDays(counter)
        txtTomDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        if (counter == 0){
            txtToday555.text = "TODAY"
        }
        if (counter == 1){
            txtToday555.text = "TOMORROW"
        }

        val course = (preferences.getString("course5", ""))
        var task = (preferences.getString("task5", ""))
        val due = (preferences.getString("due5", ""))
        task = "$task      $due"

        if(course.toString() != "") {
            var messageid5 = ref.push().key
            var messageg5 = Message(
                messageid5.toString(),
                course.toString(),
                task.toString(),
                due.toString()
            )
            ref.child(messageid5.toString()).setValue(messageg5).addOnCompleteListener {
            }
        }
        //listen and show data changes
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                fire5.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    fire5.text =
                        fire5.text.toString() + "\n" + it.child("name").value.toString() + "      "  + it.child(
                            "message" ).value.toString()

                    editor.putString("date1", txtClear55.text.toString())
                    editor.putString("course5", txtClear55.text.toString())
                    editor.putString("task5", txtClear55.text.toString())
                    editor.putString("due5", txtClear55.text.toString())
                    editor.commit()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Friday", "Failed to read value.", error.toException())
            }
        })

        btnBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlannerFour::class.java)
            startActivity(intent)
        })

        btnAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivity(intent)
        })
        next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlannerSix::class.java)
            startActivity(intent)
        })

        menu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


    }
}


