package com.example.discretemathlearningassistant.fundamentals.functions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.discretemathlearningassistant.R

class FunctionTerminologyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function_terminology)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
