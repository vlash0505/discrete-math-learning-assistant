package com.example.discretemathlearningassistant.fundamentals.functions.visual

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SurjectionView(context: Context, attrs: AttributeSet) : View(context, attrs) {
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

        val domainPoints = listOf(0.2f, 0.4f, 0.6f, 0.8f)
        val rangePoints = listOf(0.2f, 0.4f, 0.8f) // less points in the range

        // Draw domain and range points
        for (i in domainPoints.indices) {
            val domainY = height * domainPoints[i]
            canvas.drawCircle(width * 0.3f, domainY, 10f, pointPaint)

            // Draw a line from domain point to range point
            val rangeY = height * rangePoints[i % rangePoints.size] // use modulo to repeat range points
            canvas.drawCircle(width * 0.7f, rangeY, 10f, pointPaint)
            canvas.drawLine(width * 0.3f, domainY, width * 0.7f, rangeY, linePaint)
        }
    }
}
