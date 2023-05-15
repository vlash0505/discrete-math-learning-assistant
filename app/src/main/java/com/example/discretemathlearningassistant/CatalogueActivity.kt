package com.example.discretemathlearningassistant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.discretemathlearningassistant.fundamentals.sets_theory.SetsActivity

class CatalogueActivity : AppCompatActivity() {
    private lateinit var btnFundamentals: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogue)

        btnFundamentals = findViewById(R.id.btnFundamentals)
        btnFundamentals.setOnClickListener {
            val intent = Intent(this, SetsActivity::class.java)
            startActivity(intent)
        }
    }
}