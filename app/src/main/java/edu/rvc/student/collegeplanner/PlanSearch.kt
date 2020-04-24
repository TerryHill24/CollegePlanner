package edu.rvc.student.collegeplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener

class PlanSearch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_search)
        val v1 = findViewById<TextView>(R.id.txtv1)
        val v2 = findViewById<TextView>(R.id.txtv2)
        val v3 = findViewById<TextView>(R.id.txtv3)
        val v4 = findViewById<TextView>(R.id.txtv4)
        val v5 = findViewById<TextView>(R.id.txtv5)
        val v6 = findViewById<TextView>(R.id.txtv6)
        val v7 = findViewById<TextView>(R.id.txtv7)
        val search = findViewById<EditText>(R.id.txtSrch)
        val btnBack = findViewById<Button>(R.id.btnMainMenu2)
        val btnSearch = findViewById<Button>(R.id.btnSearchTask)

        search.requestFocus()
        var ref1 = FirebaseDatabase.getInstance().getReference("Monday")
        ref1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                v1.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    v1.text =
                        v1.text.toString() + "\n" + it.child("name").value.toString() + "      " + it.child(
                            "message"
                        ).value.toString() }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Monday", "Failed to read value.", error.toException()) }
        })

        var ref2 = FirebaseDatabase.getInstance().getReference("Tuesday")
        ref2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                v2.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    v2.text =
                        v2.text.toString() + "\n" + it.child("name").value.toString() + "      " + it.child(
                            "message"
                        ).value.toString() }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Tuesday", "Failed to read value.", error.toException()) }
        })
        var ref3 = FirebaseDatabase.getInstance().getReference("Wednesday")
        ref3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                v3.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    v3.text =
                        v3.text.toString() + "\n" + it.child("name").value.toString() + "      " + it.child(
                            "message"
                        ).value.toString() }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Wednesday", "Failed to read value.", error.toException()) }
        })

        var ref4 = FirebaseDatabase.getInstance().getReference("Thursday")
        ref4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                v4.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    v4.text =
                        v4.text.toString() + "\n" + it.child("name").value.toString() + "      " + it.child(
                            "message"
                        ).value.toString() }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Thursday", "Failed to read value.", error.toException()) }
        })

        var ref5 = FirebaseDatabase.getInstance().getReference("Friday")
        ref5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                v5.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    v5.text =
                        v5.text.toString() + "\n" + it.child("name").value.toString() + "      " + it.child(
                            "message"
                        ).value.toString() }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Friday", "Failed to read value.", error.toException()) }
        })

        var ref6 = FirebaseDatabase.getInstance().getReference("Saturday")
        ref6.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
               v6.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    v6.text =
                        v6.text.toString() + "\n" + it.child("name").value.toString() + "      " + it.child(
                            "message"
                        ).value.toString() }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Saturday", "Failed to read value.", error.toException()) }
        })

        var ref7 = FirebaseDatabase.getInstance().getReference("Sunday")
        ref7.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                v7.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    v7.text =
                        v7.text.toString() + "\n" + it.child("name").value.toString() + "      " + it.child(
                            "message"
                        ).value.toString() }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Sunday", "Failed to read value.", error.toException())
            }
        })

        search.requestFocus()
        btnSearch.setOnClickListener(View.OnClickListener {

            if (v1.text.toString().contains(search.text.toString(), true)) {
                val intent = Intent(this, Planner1::class.java)
                startActivity(intent) }
            if (v2.text.toString().contains(search.text.toString(), true)) {
                val intent = Intent(this, Nextplanner::class.java)
                startActivity(intent) }
            if (v3.text.toString().contains(search.text.toString(), true)) {
                val intent = Intent(this, PlannerThree::class.java)
                startActivity(intent) }
            if (v4.text.toString().contains(search.text.toString(), true)) {
                val intent = Intent(this, PlannerFour::class.java)
                startActivity(intent) }
            if (v5.text.toString().contains(search.text.toString(), true)) {
                val intent = Intent(this, PlannerFive::class.java)
                startActivity(intent) }
            if (v6.text.toString().contains(search.text.toString(), true)) {
                val intent = Intent(this, PlannerSix::class.java)
                startActivity(intent) }
            if (v7.text.toString().contains(search.text.toString(), true)) {
                val intent = Intent(this, PlannerSeven::class.java)
                startActivity(intent) }



            })


        btnBack.setOnClickListener(View.OnClickListener {
            this.finish()
        })



        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }
}

