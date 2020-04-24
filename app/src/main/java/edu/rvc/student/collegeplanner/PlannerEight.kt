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

class PlannerEight : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner_eight)

        val btnBack = findViewById<Button>(R.id.btnBack7)
        val next = findViewById<Button>(R.id.btnNext8)
        val btnAdd = findViewById<Button>(R.id.btnAdd9)
        val txtTomDate = findViewById<TextView>(R.id.txtDateTomorrow7)
        val fire8 = findViewById<TextView>(R.id.txtDisplay8)
        val txtToday888 = findViewById<TextView>(R.id.txtToday888)
        val txtClear88 = findViewById<TextView>(R.id.txtClear88)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        var ref = FirebaseDatabase.getInstance().getReference("Message8")

        //import current date
        var dateTime = LocalDateTime.now()
        //get planner date
        var counter = (preferences.getInt("counter1", 0))
        dateTime += Period.ofDays(counter)
        txtTomDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        if (counter == 0){
            txtToday888.text = "TODAY"
        }
        if (counter == 1){
            txtToday888.text = "TOMORROW"
        }

        val course = (preferences.getString("course8", ""))
        var task = (preferences.getString("task8", ""))
        val due = (preferences.getString("due8", ""))
        task = "$task      $due"

        if(course.toString() != "") {
            var messageid8 = ref.push().key
            var messageg8 = Message(
                messageid8.toString(),
                course.toString(),
                task.toString(),
                due.toString()
            )
            ref.child(messageid8.toString()).setValue(messageg8).addOnCompleteListener {
                Toast.makeText(this, "Task Added!", Toast.LENGTH_LONG).show()
            }
        }
        //listen and show data changes
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                fire8.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    fire8.text =
                        fire8.text.toString() + "\n" + it.child("name").value.toString() + "      "  + it.child(
                            "message" ).value.toString()

                    editor.putString("date1", txtClear88.text.toString())
                    editor.putString("course8", txtClear88.text.toString())
                    editor.putString("due8", txtClear88.text.toString())
                    editor.putString("task8", txtClear88.text.toString())
                    editor.commit()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Message8", "Failed to read value.", error.toException())
            }
        })

        btnBack.setOnClickListener(View.OnClickListener {
            counter+=1
            editor.putInt("dayCounter", counter)
            editor.commit()
            val intent = Intent(this, Planner1::class.java)
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
