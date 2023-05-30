package com.example.discretemathlearningassistant.trees.visual

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View

class InorderBinaryTreeTraversalView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val nodeRadius = 30f
    private val nodePaint = Paint().apply { color = Color.BLUE }
    private val nodeVisitedPaint = Paint().apply { color = Color.RED }
    private val textPaint = Paint().apply {
        color = Color.WHITE
        textSize = 30f
        textAlign = Paint.Align.CENTER
    }
    private val linePaint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 4f
    }

    private var tree: TreeNode? = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3).apply {
            left = TreeNode(6)
            right = TreeNode(7)
        }
    }

    private val inorderTraversal: List<TreeNode> = listOf(
        tree!!.left!!.left!!,
        tree!!.left!!,
        tree!!.left!!.right!!,
        tree!!,
        tree!!.right!!.left!!,
        tree!!.right!!,
        tree!!.right!!.right!!
    )
    private val visitedNodes: MutableList<TreeNode> = mutableListOf()

    private val handler = Handler(Looper.getMainLooper())
    private var stepIndex = 0

    init {
        handler.post(object : Runnable {
            override fun run() {
                if (stepIndex < inorderTraversal.size) {
                    visitedNodes.add(inorderTraversal[stepIndex])
                    stepIndex++
                    invalidate()

                    handler.postDelayed(this, 1000)
                }
            }
        })
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        tree?.let { drawTree(it, canvas, width / 2f, 100f, width / 4f) }
    }

    private fun drawTree(node: TreeNode, canvas: Canvas, x: Float, y: Float, horizontalSpacing: Float) {
        val paint = if (visitedNodes.contains(node)) nodeVisitedPaint else nodePaint
        canvas.drawCircle(x, y, nodeRadius, paint)
        canvas.drawText(node.value.toString(), x, y + textPaint.textSize / 3, textPaint)

        node.left?.let {
            canvas.drawLine(x, y, x - horizontalSpacing, y + 200, linePaint)
            drawTree(it, canvas, x - horizontalSpacing, y + 200, horizontalSpacing / 2)
        }
        node.right?.let {
            canvas.drawLine(x, y, x + horizontalSpacing, y + 200, linePaint)
            drawTree(it, canvas, x + horizontalSpacing, y + 200, horizontalSpacing / 2)
        }
    }
}

data class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null)


