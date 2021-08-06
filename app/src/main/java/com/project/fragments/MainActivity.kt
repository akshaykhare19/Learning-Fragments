package com.project.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class MainActivity : AppCompatActivity(), OnRemoveFragmentButtonClickListener {

    lateinit var addFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment = findViewById(R.id.add_fragment)

        addFragment.setOnClickListener {
            if(savedInstanceState == null)
            {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, MyFragment.newInstance(),
                        "MyTag").commit()
            }
        }

    }

    override fun onRemoveFragmentClicked() {

        val fragment = supportFragmentManager.findFragmentByTag("MyTag")
        supportFragmentManager
            .beginTransaction()
            .remove(fragment!!)
            .commit()
    }
}