package com.amigo.datapassinginactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.btnSendData).setOnClickListener {
            val name=findViewById<EditText>(R.id.etName).text.toString()
            val age=findViewById<EditText>(R.id.etAge).text.toString().toInt()
            val country=findViewById<EditText>(R.id.etCountry).text.toString()

            Intent(this,SecondActivity::class.java).also {
                it.putExtra("nameMain",name)
                it.putExtra("ageMain",age)
                it.putExtra("countryMain",country)
                startActivity(it)
            }
        }
    }
}