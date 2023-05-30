package com.example.discretemathlearningassistant.trees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.discretemathlearningassistant.R

class TreeTerminologyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tree_terminology)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}