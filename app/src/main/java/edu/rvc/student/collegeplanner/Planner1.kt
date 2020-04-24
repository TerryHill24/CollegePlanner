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
import androidx.annotation.RequiresApi
import java.time.Period
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener

class Planner1 : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner1)
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val next = findViewById<Button>(R.id.btnNext)
        val btnAdd2 = findViewById<Button>(R.id.btnAdd2)
        val menu = findViewById<Button>(R.id.btnMenu111)
        val txtTodayDate = findViewById<TextView>(R.id.txtDateToday)
        val fire = findViewById<TextView>(R.id.txtDisplay1)
        val txtClear11 = findViewById<TextView>(R.id.txtClear11)
        val txtToday111 = findViewById<TextView>(R.id.txtToday111)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        var ref = FirebaseDatabase.getInstance().getReference("Monday")

        //import current date
        var dateTime = LocalDateTime.now()
        var counter = (preferences.getInt("counter2", 0))
        dateTime += Period.ofDays(counter)
        txtTodayDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        if (counter == 0){
            txtToday111.text = "TODAY"
        }
        if (counter == 1){
            txtToday111.text = "TOMORROW"
        }

        val course = (preferences.getString("course1", ""))
        var task = (preferences.getString("task1", ""))
        val due = (preferences.getString("due1", ""))
        task = "$task      $due"

        if(course.toString() != "") {
            var messageid = ref.push().key
            var messageg = Message(
                messageid.toString(), course.toString(), task.toString(), due.toString()
            )
            ref.child(messageid.toString()).setValue(messageg).addOnCompleteListener {
            }
        }
            //listen and show data changes
            ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    fire.text = ""
                    val children = dataSnapshot.children
                    children.forEach {
                        println("data: " + it.toString())
                        fire.text =
                            fire.text.toString() + "\n" + it.child("name").value.toString() + "      "  + it.child(
                                "message" ).value.toString()

                        editor.putString("date1", txtClear11.text.toString())
                        editor.putString("course1", txtClear11.text.toString())
                        editor.putString("due1", txtClear11.text.toString())
                        editor.putString("task1", txtClear11.text.toString())
                        editor.commit()
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w("Monday", "Failed to read value.", error.toException())
                }
            })

        btnMenu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlannerEight::class.java)
            startActivity(intent)
            startActivity(intent)
        })

        btnAdd2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivity(intent)
        })
        next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Nextplanner::class.java)
            startActivity(intent)
        })

        menu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
}


