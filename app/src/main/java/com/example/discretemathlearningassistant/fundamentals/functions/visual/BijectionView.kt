package com.example.discretemathlearningassistant.fundamentals.functions.visual

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BijectionView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val pointPaint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 10f
        style = Paint.Style.FILL
    }
    private val linePaint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 2f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val points = listOf(0.2f, 0.4f, 0.6f, 0.8f)

        // Draw domain and range points
        for (i in points.indices) {
            val y = height * points[i]

            canvas.drawCircle(width * 0.3f, y, 10f, pointPaint)
            canvas.drawCircle(width * 0.7f, y, 10f, pointPaint)

            // Draw a line from domain point to range point
            canvas.drawLine(width * 0.3f, y, width * 0.7f, y, linePaint)
        }
    }
}
