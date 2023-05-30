package com.example.discretemathlearningassistant.graphs.visual

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.*

class DFSGraphTraversalView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val nodeCount = 7
    private val nodes = List(nodeCount) { Node() }
    private val edges = mutableListOf<Edge>()
    private val dfsStack: Stack<Node> = Stack()
    private val visitedNodes = mutableListOf<Node>()

    private val nodePaint = Paint().apply {
        color = Color.BLUE
        strokeWidth = 10f
        style = Paint.Style.FILL
    }
    private val edgePaint = Paint().apply {
        color = Color.GRAY
        strokeWidth = 2f
    }
    private val dfsPaint = Paint().apply {
        color = Color.RED
        strokeWidth = 4f
    }
    private val startNodePaint = Paint().apply {
        color = Color.GREEN
        strokeWidth = 4f
    }

    init {
        // Create nodes arranged in a circle
        for (i in 0 until nodeCount) {
            val angle = 2.0 * Math.PI * i / nodeCount
            nodes[i].x = (0.5 + 0.4 * Math.cos(angle)).toFloat()
            nodes[i].y = (0.5 + 0.4 * Math.sin(angle)).toFloat()
        }

        // Connect each node to its two neighbors and the node across the circle
        for (i in 0 until nodeCount) {
            edges.add(Edge(nodes[i], nodes[(i + 1) % nodeCount]))
            edges.add(Edge(nodes[i], nodes[(i + nodeCount / 2) % nodeCount]))
        }

        // Start the DFS algorithm
        dfsStack.push(nodes.first())
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw edges
        for (edge in edges) {
            val startX = width * edge.node1.x
            val startY = height * edge.node1.y
            val stopX = width * edge.node2.x
            val stopY = height * edge.node2.y
            canvas.drawLine(startX, startY, stopX, stopY, edgePaint)
        }

        // Draw nodes
        for (node in nodes) {
            val cx = width * node.x
            val cy = height * node.y
            val paint = when {
                node == nodes.first() -> startNodePaint // Draw the start node in green
                visitedNodes.contains(node) -> dfsPaint // Draw visited nodes in red
                else -> nodePaint // Draw unvisited nodes in blue
            }
            canvas.drawCircle(cx, cy, 10f, paint)
        }

        // Draw DFS
        if (dfsStack.isNotEmpty()) {
            val node = dfsStack.pop()
            visitedNodes.add(node)

            for (edge in edges) {
                if (edge.node1 == node && !visitedNodes.contains(edge.node2) && !dfsStack.contains(edge.node2)) {
                    dfsStack.push(edge.node2)
                } else if (edge.node2 == node && !visitedNodes.contains(edge.node1) && !dfsStack.contains(edge.node1)) {
                    dfsStack.push(edge.node1)
                }
            }

            // Redraw the view with a delay
            postInvalidateDelayed(1000)
        }
    }

    private data class Node(var x: Float = 0f, var y: Float = 0f)

    private data class Edge(val node1: Node, val node2: Node)
}
