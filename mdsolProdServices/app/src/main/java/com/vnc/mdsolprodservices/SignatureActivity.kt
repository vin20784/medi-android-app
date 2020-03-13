package com.vnc.mdsolprodservices


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.media.MediaScannerConnection
import android.os.Bundle
import android.os.Environment
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signature.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


class SignatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signature)

        signatureView?.setSigColor(Color.WHITE)
        clear = findViewById<Button>(R.id.clear)
        save = findViewById<Button>(R.id.save)
        cancel = findViewById<Button>(R.id.cancel)
        clear!!.setOnClickListener {
            signatureView?.clearSignature()
        }
        save!!.setOnClickListener {
           // bitmap = signatureView?.getImage()
            path = signatureView?.saveBitmap()
        }

        cancel!!.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    var bitmap: Bitmap? = null
    var clear: Button? = null
    var save:Button? = null
    var cancel:Button? = null
    var signatureView: SignatureView? = null
    var path: String? = null
    private val IMAGE_DIRECTORY = "/signdemo"

}
