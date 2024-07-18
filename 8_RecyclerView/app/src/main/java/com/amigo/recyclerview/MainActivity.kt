package com.amigo.recyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        val todos= mutableListOf(
            dataClass("Do you have 10 dollers",false),
            dataClass("Can we go on a date",false),
            dataClass("Will you marry me",false),
            dataClass("Are you a developer",false)
        )

        val rvTodo=findViewById<RecyclerView>(R.id.rvTodo)

        val adapter=Adapter(todos)
        rvTodo.adapter=adapter
        rvTodo.layoutManager=LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
            val title=findViewById<EditText>(R.id.etNewTodo).text.toString()
            val todo=dataClass(title,false)
            todos.add(todo)
            adapter.notifyItemInserted(todos.size-1)
        }
    }
}