package com.example.discretemathlearningassistant.graphs.visual

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

class DirectedGraphView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    // Example directed graph structure
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
            Edge(Vertex(300f, 300f), Vertex(380f, 360f)),
            Edge(Vertex(300f, 300f), Vertex(300f, 400f)),
            Edge(Vertex(300f, 300f), Vertex(220f, 360f)),
            Edge(Vertex(300f, 300f), Vertex(220f, 240f)),
            Edge(Vertex(300f, 200f), Vertex(380f, 240f)),
            Edge(Vertex(380f, 240f), Vertex(380f, 360f)),
            Edge(Vertex(380f, 360f), Vertex(300f, 400f)),
            Edge(Vertex(300f, 400f), Vertex(220f, 360f)),
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

        // Draw edges as lines with arrowheads
        for (edge in graph.edges) {
            canvas.drawLine(edge.start.x, edge.start.y, edge.end.x, edge.end.y, paint)
            drawArrowhead(canvas, edge.start, edge.end)
        }
    }

    private fun drawArrowhead(canvas: Canvas, start: Vertex, end: Vertex) {
        val arrowPath = Path()
        val arrowHeadSize = 20f
        val dx = end.x - start.x
        val dy = end.y - start.y
        val angle = atan2(dy, dx)

        val x1 = (end.x - arrowHeadSize * cos(angle + PI / 6)).toFloat()
        val y1 = (end.y - arrowHeadSize * sin(angle + PI / 6)).toFloat()
        val x2 = (end.x - arrowHeadSize * cos(angle - PI / 6)).toFloat()
        val y2 = (end.y - arrowHeadSize * sin(angle - PI / 6)).toFloat()
        arrowPath.moveTo(end.x, end.y)
        arrowPath.lineTo(x1, y1)
        arrowPath.moveTo(end.x, end.y)
        arrowPath.lineTo(x2, y2)
        canvas.drawPath(arrowPath, paint)
    }
}


