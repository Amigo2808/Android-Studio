package com.amigo.alertdialog

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
        val addContact=AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_contact)
            .setTitle("Add Contact")
            .setMessage("Add omi to contact list")
            .setNegativeButton("No"){_,_->
                Toast.makeText(this, "You have not added miss omi to contact list", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes"){_,_->
                Toast.makeText(this, "You added miss omi to contact list", Toast.LENGTH_SHORT).show()
            }
        findViewById<Button>(R.id.btnDialog1).setOnClickListener {
            addContact.show()
        }

        val list= arrayOf("first","Second","Third","Fourth")
        val singleChoiceOption=AlertDialog.Builder(this)
            .setTitle("Choose One Option")
            .setSingleChoiceItems(list,0){_,i->
                Toast.makeText(this, "${list[i]} Selected", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_->
                Toast.makeText(this, "You rejected", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes"){_,_->
                Toast.makeText(this, "You accepted", Toast.LENGTH_SHORT).show()
            }
        findViewById<Button>(R.id.btnDialog2).setOnClickListener {
            singleChoiceOption.show()
        }
        val multiChoiceOption=AlertDialog.Builder(this)
            .setTitle("Choose One Option")
            .setMultiChoiceItems(list, booleanArrayOf(false,false,false,false)){ _, i,_,->
                Toast.makeText(this, "${list[i]} Selected", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_->
                Toast.makeText(this, "You rejected", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes"){_,_->
                Toast.makeText(this, "You accepted", Toast.LENGTH_SHORT).show()
            }
        findViewById<Button>(R.id.btnDialog3).setOnClickListener {
            multiChoiceOption.show()
        }
    }
}