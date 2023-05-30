package com.example.discretemathlearningassistant.trees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.discretemathlearningassistant.R

class TreeTraversalsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tree_traversals)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}