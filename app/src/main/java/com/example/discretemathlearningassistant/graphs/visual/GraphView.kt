package com.example.discretemathlearningassistant.graphs.visual

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

data class Vertex(val x: Float, val y: Float)
data class Edge(val start: Vertex, val end: Vertex)
data class Graph(val vertices: List<Vertex>, val edges: List<Edge>)


class GraphView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    // Example graph structure
    private val graph = Graph(
        vertices = listOf(
            Vertex(300f, 300f),
            Vertex(300f, 200f),
            Vertex(380f, 240f),
            Vertex(380f, 360f),
            Vertex(300f, 400f),
            Vertex(220f, 360f),
            Vertex(220f, 240f)
        ),
        edges = listOf(
            Edge(Vertex(300f, 300f), Vertex(300f, 200f)),
            Edge(Vertex(300f, 300f), Vertex(380f, 240f)),
            Edge(Vertex(300f, 300f), Vertex(300f, 400f)),
            Edge(Vertex(300f, 300f), Vertex(220f, 360f)),
            Edge(Vertex(300f, 200f), Vertex(380f, 240f)),
            Edge(Vertex(380f, 240f), Vertex(380f, 360f)),
            Edge(Vertex(380f, 360f), Vertex(300f, 400f)),
            Edge(Vertex(220f, 360f), Vertex(220f, 240f)),
            Edge(Vertex(220f, 240f), Vertex(300f, 200f))
        )
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw vertices as circles
        for (vertex in graph.vertices) {
            canvas.drawCircle(vertex.x, vertex.y, 20f, paint)
        }

        // Draw edges as lines
        for (edge in graph.edges) {
            canvas.drawLine(edge.start.x, edge.start.y, edge.end.x, edge.end.y, paint)
        }
    }
}

