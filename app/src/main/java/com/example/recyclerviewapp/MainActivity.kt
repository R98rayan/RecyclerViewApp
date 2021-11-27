package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var texts = ArrayList<String>()

    lateinit var myButton: Button
    lateinit var myText: TextView
    lateinit var myRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val colors = listOf("Red","Green","Blue")

        myRV = findViewById<RecyclerView>(R.id.rvMain)
        myRV.adapter = RecyclerViewAdapter(texts)
        myRV.layoutManager = LinearLayoutManager(this)

        myButton = findViewById(R.id.submitButton)
        myButton.setOnClickListener{ addText() }

        myText = findViewById<TextView>(R.id.textLabel)
    }

    private fun addText() {

        if(myText.text.toString() == "") return

        texts.add(myText.text.toString())
        myText.text = ""
        print("the size of the list is now ${texts.size}")
        
        val insertIndex = 2

        myRV.adapter?.notifyDataSetChanged()
    }
}