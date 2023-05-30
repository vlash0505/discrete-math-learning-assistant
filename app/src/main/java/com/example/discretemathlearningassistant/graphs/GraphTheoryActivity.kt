package com.example.discretemathlearningassistant.graphs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.discretemathlearningassistant.R

class GraphTheoryActivity : AppCompatActivity() {
    private lateinit var btnGraphTraversals: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph_theory)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnGraphTraversals = findViewById(R.id.btnGraphTraversals)
        btnGraphTraversals.setOnClickListener {
            val intent = Intent(this, GraphTraversalsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}