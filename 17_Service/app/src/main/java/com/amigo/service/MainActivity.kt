package com.amigo.service

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        val tvService=findViewById<TextView>(R.id.tvService)

        findViewById<Button>(R.id.btnStart).setOnClickListener {
            Intent(this,MyService::class.java).also {
                startService(it)
                tvService.text="Service Started"
            }
        }
        findViewById<Button>(R.id.btnStop).setOnClickListener {
            Intent(this,MyService::class.java).also {
                stopService(it)
                tvService.text="Service Stopped"
            }
        }
        findViewById<Button>(R.id.btnSendData).setOnClickListener {
            val etData=findViewById<EditText>(R.id.etData).text.toString()
            Intent(this,MyService::class.java).also {
                it.putExtra("EXTRA_DATA",etData)
                startService(it)
                tvService.text="Service Started"
            }
        }
    }
}