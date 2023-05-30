package com.example.discretemathlearningassistant

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import java.util.*


class BFSView(context: Context) : View(context) {

    data class Node(val x: Int, val y: Int)

    private val gridSize = 10
    private val nodeSize = 50
    private val visitedNodes = mutableSetOf<Node>()
    private val paint = Paint().apply {
        color = Color.BLUE
    }

    init {
        Thread {
            bfs(Node(0, 0))
        }.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (i in 0 until gridSize) {
            for (j in 0 until gridSize) {
                val node = Node(i, j)
                if (visitedNodes.contains(node)) {
                    canvas.drawRect(
                        (i * nodeSize).toFloat(),
                        (j * nodeSize).toFloat(),
                        ((i+1) * nodeSize).toFloat(),
                        ((j+1) * nodeSize).toFloat(),
                        paint
                    )
                }
            }
        }
    }

    private fun bfs(start: Node) {
        val queue: Queue<Node> = LinkedList<Node>()
        queue.add(start)

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            visitedNodes.add(current)
            postInvalidate()

            val neighbours = listOf(
                Node(current.x - 1, current.y),
                Node(current.x + 1, current.y),
                Node(current.x, current.y - 1),
                Node(current.x, current.y + 1)
            )

            for (node in neighbours) {
                if (node.x in 0 until gridSize && node.y in 0 until gridSize && node !in visitedNodes) {
                    queue.add(node)
                    Thread.sleep(500) // Wait a bit before visiting the next node
                }
            }
        }
    }
}

