package com.example.discretemathlearningassistant.fundamentals.sets_theory.venn_diagrams

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class IntersectionVennDiagramView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }
    private val labelPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 40f
        color = Color.BLACK
    }
    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()

        // Draw the union region
        val pathA = path.apply {
            addCircle(width * 0.4f, height * 0.5f, height * 0.3f, Path.Direction.CW)
        }
        val pathB = path.apply {
            addCircle(width * 0.6f, height * 0.5f, height * 0.3f, Path.Direction.CW)
        }
        val intersectionPath = path.apply {
            op(pathA, pathB, Path.Op.INTERSECT)
        }
        circlePaint.color = Color.argb(127, 255, 127, 0)
        canvas.drawPath(intersectionPath, circlePaint)

        // Draw circle outlines
        circlePaint.style = Paint.Style.STROKE
        circlePaint.color = Color.BLACK
        canvas.drawPath(pathA, circlePaint)
        canvas.drawPath(pathB, circlePaint)


        // Draw labels
        canvas.drawText("A", width * 0.4f, height * 0.5f, labelPaint)
        canvas.drawText("B", width * 0.6f, height * 0.5f, labelPaint)
    }
}