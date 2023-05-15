package com.example.discretemathlearningassistant.fundamentals.sets_theory.venn_diagrams

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.discretemathlearningassistant.R

class VennDiagramActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venn_diagram)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}

