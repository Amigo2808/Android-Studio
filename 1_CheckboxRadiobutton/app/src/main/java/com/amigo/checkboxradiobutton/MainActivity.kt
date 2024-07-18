package com.amigo.checkboxradiobutton

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
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
        val rgMeat=findViewById<RadioGroup>(R.id.rgMeat)

        val cbSalad=findViewById<CheckBox>(R.id.cbSalad)
        val cbOnion=findViewById<CheckBox>(R.id.cbOnion)
        val cbCucumber=findViewById<CheckBox>(R.id.cbCucumber)

        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            val checkMeatId=rgMeat.checkedRadioButtonId
            val meat=findViewById<RadioButton>(checkMeatId)
            val salad=cbSalad.isChecked
            val onion=cbOnion.isChecked
            val cucumber=cbCucumber.isChecked

            val orderString="You have ordered a burger with :\n"+
                    "${meat.text}"+
                    (if (salad) "\nSalad" else "")+
                    (if (onion) "\nOnion" else "")+
                    (if (cucumber) "\nCucumber" else "")

            findViewById<TextView>(R.id.tvOrderString).text = orderString
        }
    }
}