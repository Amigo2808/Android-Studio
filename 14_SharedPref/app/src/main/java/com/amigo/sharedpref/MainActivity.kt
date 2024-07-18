package com.amigo.sharedpref

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
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
        val sharePref=getSharedPreferences("myPref", MODE_PRIVATE)
        val editor=sharePref.edit()

        val etName=findViewById<EditText>(R.id.etName)
        val etAge=findViewById<EditText>(R.id.etAge)
        val cbAdult=findViewById<CheckBox>(R.id.cbAdult)

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val name=etName.text.toString()
            val age=etAge.text.toString().toInt()
            val adult=cbAdult.isChecked

            editor.apply {
                putString("name",name)
                putInt("age",age)
                putBoolean("adult",adult)
                apply()
            }
        }
        findViewById<Button>(R.id.btnLoad).setOnClickListener {
            val name=sharePref.getString("name","")
            val age=sharePref.getInt("age",0)
            val adult=sharePref.getBoolean("adult",false)

            etName.setText(name)
            etAge.setText(age.toString())
            cbAdult.isChecked=adult
        }
    }
}