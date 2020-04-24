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

class PlannerSeven : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner_seven)

        val btnBack = findViewById<Button>(R.id.btnBack6)
        val next = findViewById<Button>(R.id.btnNext7)
        val btnAdd = findViewById<Button>(R.id.btnAdd8)
        val txtTomDate = findViewById<TextView>(R.id.txtDateTomorrow6)
        val fire7 = findViewById<TextView>(R.id.txtDisplay7)
        val txtToday777 = findViewById<TextView>(R.id.txtToday777)
        val txtClear77 = findViewById<TextView>(R.id.txtClear77)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        var ref = FirebaseDatabase.getInstance().getReference("Sunday")

        //import current date
        var dateTime = LocalDateTime.now()
        var counter = (preferences.getInt("counter8", 0))
        dateTime += Period.ofDays(counter)
        txtTomDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        if (counter == 0){
            txtToday777.text = "TODAY"
        }
        if (counter == 1){
            txtToday777.text = "TOMORROW"
        }
        val course = (preferences.getString("course7", ""))
        var task = (preferences.getString("task7", ""))
        val due = (preferences.getString("due7", ""))
        task = "$task      $due"

        if(course.toString() != "") {
            var messageid7 = ref.push().key
            var messageg7 = Message(messageid7.toString(), course.toString(), task.toString(), due.toString()
            )
            ref.child(messageid7.toString()).setValue(messageg7).addOnCompleteListener {
            }
        }
        //listen and show data changes
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                fire7.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    fire7.text =
                        fire7.text.toString() + "\n" + it.child("name").value.toString() + "      "  + it.child(
                            "message" ).value.toString()

                    editor.putString("date1", txtClear77.text.toString())
                    editor.putString("course7", txtClear77.text.toString())
                    editor.putString("task7", txtClear77.text.toString())
                    editor.putString("due7", txtClear77.text.toString())
                    editor.commit()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Sunday", "Failed to read value.", error.toException())
            }
        })

        btnBack.setOnClickListener(View.OnClickListener {
            counter-=1
            editor.putInt("dayCounter", counter)
            editor.commit()
            val intent = Intent(this, PlannerSix::class.java)
            startActivity(intent)
        })

        btnAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivity(intent)
        })
        next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


    }
}

