package com.example.discretemathlearningassistant.fundamentals.sets_theory

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.discretemathlearningassistant.R
import com.example.discretemathlearningassistant.fundamentals.sets_theory.venn_diagrams.VennDiagramActivity

class SetsActivity : AppCompatActivity() {

    private lateinit var set1EditText: EditText
    private lateinit var set2EditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sets)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        set1EditText = findViewById(R.id.etSet1)
        set2EditText = findViewById(R.id.etSet2)

        val unionButton: Button = findViewById(R.id.button_union)
        val intersectionButton: Button = findViewById(R.id.button_intersection)
        val differenceButton: Button = findViewById(R.id.button_difference)
        val symmetricDifferenceButton: Button = findViewById(R.id.button_symmetric_difference)

        val btnVennDiagrams: Button = findViewById(R.id.btnVennDiagrams)
        val btnRules: Button = findViewById(R.id.btnRules)

        btnVennDiagrams.setOnClickListener {
            val intent = Intent(this, VennDiagramActivity::class.java)
            startActivity(intent)
        }
        btnRules.setOnClickListener {
            val intent = Intent(this, SetLawsActivity::class.java)
            startActivity(intent)
        }

        resultTextView = findViewById(R.id.textView_result)

        unionButton.setOnClickListener { view -> performOperation(view) }
        intersectionButton.setOnClickListener { view -> performOperation(view) }
        differenceButton.setOnClickListener { view -> performOperation(view) }
        symmetricDifferenceButton.setOnClickListener { view -> performOperation(view) }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }


    private fun performOperation(view: View) {
        val set1 = set1EditText.text.toString().split(',').map { it.trim() }.toSet()
        val set2 = set2EditText.text.toString().split(',').map { it.trim() }.toSet()
        val result = when (view.id) {
            R.id.button_union -> set1.union(set2)
            R.id.button_intersection -> set1.intersect(set2)
            R.id.button_difference -> set1.subtract(set2)
            R.id.button_symmetric_difference -> set1.symmetricDifference(set2)
            else -> setOf()
        }
        resultTextView.text = result.joinToString(", ")
    }

    private fun <T> Set<T>.symmetricDifference(other: Set<T>): Set<T> {
        val union = this.union(other)
        val intersection = this.intersect(other)
        return union.subtract(intersection)
    }
}

