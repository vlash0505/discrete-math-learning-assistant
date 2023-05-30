package com.example.discretemathlearningassistant.graphs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.discretemathlearningassistant.R

class GraphTheoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph_theory)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}