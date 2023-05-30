package com.example.discretemathlearningassistant.recursion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.discretemathlearningassistant.R
import com.example.discretemathlearningassistant.fundamentals.sets_theory.SetsActivity

class RecursionTerminologyActivity : AppCompatActivity() {

    private lateinit var btnHanoi: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recursion_terminology)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnHanoi = findViewById(R.id.btnHanoi)
        btnHanoi.setOnClickListener {
            val intent = Intent(this, HanoiTowersActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}