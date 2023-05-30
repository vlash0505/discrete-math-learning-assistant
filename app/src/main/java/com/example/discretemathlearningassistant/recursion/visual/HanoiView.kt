package com.example.discretemathlearningassistant.recursion.visual

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.*

class HanoiView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 5f
    }

    private val numberOfDisks = 5

    private val rods = List(3) { Stack<Int>() }
    private val diskHeight = 20f
    private val diskMaxWidth = 200f
    private val diskMinWidth = 60f

    private val moves = mutableListOf<Pair<Int, Int>>()

    private val moveDisk: Runnable = object : Runnable {
        override fun run() {
            if (moves.isNotEmpty()) {
                val move = moves.removeAt(0)
                rods[move.second].push(rods[move.first].pop())
                invalidate()
                postDelayed(this, 1000)
            }
        }
    }

    init {
        for (i in numberOfDisks downTo 1) {
            rods[0].push(i)
        }

        hanoi(numberOfDisks, 0, 2, 1)
        postDelayed(moveDisk, 1000)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw rods
        for (i in rods.indices) {
            val rodX = (i + 1) * width / 4f
            canvas.drawLine(rodX, height - 50f, rodX, 50f, paint)
        }

        // Draw disks
        for (i in rods.indices) {
            for (j in 0 until rods[i].size) {
                val diskWidth = (diskMinWidth + (rods[i][j] - 1) * (diskMaxWidth - diskMinWidth) / (numberOfDisks - 1))
                val diskX = (i + 1) * width / 4f - diskWidth / 2
                val diskY = height - 50f - j * diskHeight
                canvas.drawRect(diskX, diskY, diskX + diskWidth, diskY + diskHeight, paint)
            }
        }
    }

    private fun hanoi(n: Int, from: Int, to: Int, via: Int) {
        if (n > 0) {
            hanoi(n - 1, from, via, to)
            moves.add(Pair(from, to))
            hanoi(n - 1, via, to, from)
        }
    }
}
