package com.example.discretemathlearningassistant.fundamentals.functions.visual

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class InjectionView(context: Context, attrs: AttributeSet) : View(context, attrs) {
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

        val domainPoints = listOf(0.25f, 0.5f, 0.75f)
        val rangePoints = listOf(0.2f, 0.4f, 0.6f, 0.8f)

        // Draw domain and range points
        for (i in rangePoints.indices) {
            val rangeY = height * rangePoints[i]
            canvas.drawCircle(width * 0.7f, rangeY, 10f, pointPaint)

            // Draw a line from domain point to range point
            if (i < domainPoints.size) {
                val domainY = height * domainPoints[i]
                canvas.drawCircle(width * 0.3f, domainY, 10f, pointPaint)
                canvas.drawLine(width * 0.3f, domainY, width * 0.7f, rangeY, linePaint)
            }
        }
    }
}
