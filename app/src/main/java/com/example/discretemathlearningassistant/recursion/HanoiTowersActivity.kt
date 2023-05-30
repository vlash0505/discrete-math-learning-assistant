package com.example.discretemathlearningassistant.recursion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.discretemathlearningassistant.R

class HanoiTowersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanoi_towers)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}