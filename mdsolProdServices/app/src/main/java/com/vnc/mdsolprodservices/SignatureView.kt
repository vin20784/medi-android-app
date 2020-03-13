package com.vnc.mdsolprodservices

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class SignatureView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val STROKE_WIDTH = 5f
    private val HALF_STROKE_WIDTH = STROKE_WIDTH / 2
    private val paint = Paint()
    private val path = Path()

    private val lastTouchX = 0f
    private val lastTouchY = 0f
    private val dirtyRect = RectF()

    init {
        paint.isAntiAlias = true
        paint.color       = Color.BLACK
        paint.style       = Paint.Style.STROKE
        paint.strokeJoin  = Paint.Join.ROUND
        paint.strokeWidth = STROKE_WIDTH
    }

    @Override
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}