package com.dassault_systemes.medidata
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dassault_systemes.mdsolprodservices.R


class MySplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_splash_screen)

        Handler().postDelayed({

            startActivity(Intent(this,
                MainActivity::class.java))

            // close this activity
            finish()
        }, 2000)
    }
}
