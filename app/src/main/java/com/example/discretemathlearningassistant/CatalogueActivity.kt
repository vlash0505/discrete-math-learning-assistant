package com.example.discretemathlearningassistant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.discretemathlearningassistant.fundamentals.functions.FunctionTerminologyActivity
import com.example.discretemathlearningassistant.fundamentals.sets_theory.SetsActivity
import com.example.discretemathlearningassistant.graphs.GraphTheoryActivity
import com.example.discretemathlearningassistant.recursion.RecursionTerminologyActivity

class CatalogueActivity : AppCompatActivity() {
    private lateinit var btnSetsTheory: Button
    private lateinit var btnFunctions: Button
    private lateinit var btnRecursion: Button
    private lateinit var btnTrees: Button
    private lateinit var btnGraphTheory: Button
    private lateinit var btnCombinatorics: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogue)

        btnSetsTheory = findViewById(R.id.btnSetsTheory)
        btnFunctions = findViewById(R.id.btnFunctions)
        btnGraphTheory = findViewById(R.id.btnGraphTheory)
        btnRecursion = findViewById(R.id.btnRecursion)
        btnSetsTheory.setOnClickListener {
            val intent = Intent(this, SetsActivity::class.java)
            startActivity(intent)
        }
        btnFunctions.setOnClickListener {
            val intent = Intent(this, FunctionTerminologyActivity::class.java)
            startActivity(intent)
        }
        btnGraphTheory.setOnClickListener {
            val intent = Intent(this, GraphTheoryActivity::class.java)
            startActivity(intent)
        }
        btnRecursion.setOnClickListener {
            val intent = Intent(this, RecursionTerminologyActivity::class.java)
            startActivity(intent)
        }
    }
}