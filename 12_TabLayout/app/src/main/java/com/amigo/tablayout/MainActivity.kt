package com.amigo.tablayout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.amigo.swipableviews.Adapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

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
        val images= listOf(
            R.drawable.wallpaper1,
            R.drawable.wallpaper2,
            R.drawable.wallpaper3,
            R.drawable.wallpaper4,
            R.drawable.wallpaper5
        )

        val viewPager=findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout=findViewById<TabLayout>(R.id.tabLayout)
        val adapter=Adapter(images)
        viewPager.adapter=adapter

        viewPager.orientation=ViewPager2.ORIENTATION_VERTICAL
        
        TabLayoutMediator(tabLayout,viewPager,){tab,position->
            tab.text="Tab ${position+1}"
        }.attach()

        tabLayout.addOnTabSelectedListener(object :OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "${tab?.text} selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })


    }
}