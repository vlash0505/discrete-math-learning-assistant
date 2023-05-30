package com.example.discretemathlearningassistant.combinatorics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.discretemathlearningassistant.R

class CombinatoricsTerminologyActivity : AppCompatActivity() {
    private lateinit var btnCombinatoricsRules: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combinatorics_terminology)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnCombinatoricsRules = findViewById(R.id.btnCombinatoricsRules)
        btnCombinatoricsRules.setOnClickListener {
            val intent = Intent(this, CombinatoricsRulesActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}