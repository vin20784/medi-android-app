package com.vnc.mdsolprodservices

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Bitmap.CompressFormat
import android.os.Environment
import android.os.SystemClock
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import java.io.FileOutputStream


class SignatureView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var mPath: Path? = null
    private var mPaint: Paint? = null
    private val bgPaint = Paint(Color.TRANSPARENT)

    private var mBitmap: Bitmap? = null
    private var mCanvas: Canvas? = null

    private var curX = 0f
    private  var curY:kotlin.Float = 0f

    private val TOUCH_TOLERANCE = 4
    private val STROKE_WIDTH = 5


    init {
        isFocusable = true
        mPath = Path()
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint!!.color = Color.BLACK
        mPaint!!.style = Paint.Style.STROKE
        mPaint!!.strokeWidth = STROKE_WIDTH.toFloat()
    }

    fun setSigColor(color: Int) {
        mPaint!!.color = color
    }

    fun clearSignature(): Boolean {
        if (mBitmap != null) createFakeMotionEvents()
        when {
            mCanvas != null -> {
                mCanvas!!.drawColor(Color.WHITE)
                mCanvas!!.drawPaint(bgPaint)
                mPath!!.reset()
                invalidate()
            }
            else -> return false
        }
        return true
    }

    //@SuppressLint("WrongThread")
    fun saveBitmap():String?{
        try {
            val root = Environment.getRootDirectory().absolutePath + "/"
            val filepath = root + "signature.jpg"
            val fos = FileOutputStream(filepath)
            mBitmap?.compress(CompressFormat.JPEG, 100, fos)
            fos.flush()
            fos.close()

            return filepath
        } catch (e: Exception) {
            Log.e("Could not save", e.message)
            e.printStackTrace()
        }
        return ""
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        var bitmapWidth = mBitmap?.getWidth() ?: 0
        var bitmapHeight = mBitmap?.getWidth() ?: 0
        if (bitmapWidth >= width && bitmapHeight >= height) return
        if (bitmapWidth < width) bitmapWidth = width
        if (bitmapHeight < height) bitmapHeight = height
        val newBitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
        val newCanvas = Canvas()
        newCanvas.setBitmap(newBitmap)
        if (mBitmap != null)
            newCanvas.drawBitmap(mBitmap!!, 0f, 0f, null)

        mBitmap = newBitmap
        mCanvas = newCanvas
    }

    private fun createFakeMotionEvents() {
        val downEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100, MotionEvent.ACTION_DOWN, 1f, 1f, 0)
        val upEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100, MotionEvent.ACTION_UP, 1f, 1f, 0)
        onTouchEvent(downEvent)
        onTouchEvent(upEvent)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.WHITE)
        mBitmap?.let { canvas.drawBitmap(it, 0f, 0f, mPaint) }
        canvas.drawPath(mPath!!, mPaint!!)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchDown(x, y)
            MotionEvent.ACTION_MOVE -> touchMove(x, y)
            MotionEvent.ACTION_UP -> touchUp()
        }
        invalidate()
        return true
    }

    /**----------------------------------------------------------
     * Private methods
     * --------------------------------------------------------- */
    private fun touchDown(x: Float, y: Float) {
        mPath!!.reset()
        mPath!!.moveTo(x, y)
        curX = x
        curY = y
    }

    private fun touchMove(x: Float, y: Float) {
        val dx = Math.abs(x - curX)
        val dy = Math.abs(y - curY)
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath!!.quadTo(curX, curY, (x + curX) / 2, (y + curY) / 2)
            curX = x
            curY = y
        }
    }

    private fun touchUp() {
        mPath!!.lineTo(curX, curY)
        if (mCanvas == null) {
            mCanvas = Canvas()
            mCanvas!!.setBitmap(mBitmap)
        }
        mCanvas!!.drawPath(mPath!!, mPaint!!)
        mPath!!.reset()
    }
}