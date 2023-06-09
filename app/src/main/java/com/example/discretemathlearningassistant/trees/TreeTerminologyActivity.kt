package com.example.discretemathlearningassistant.trees

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.discretemathlearningassistant.R

class TreeTerminologyActivity : AppCompatActivity() {

    private lateinit var btnTreeTraversals: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tree_terminology)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnTreeTraversals = findViewById(R.id.btnTreeTraversals)
        btnTreeTraversals.setOnClickListener {
            val intent = Intent(this, TreeTraversalsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}