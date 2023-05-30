package com.example.discretemathlearningassistant.combinatorics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.discretemathlearningassistant.R

class CombinatoricsRulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combinatorics_rules)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}