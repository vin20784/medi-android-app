package com.vnc.mdsolprodservices

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity : AppCompatActivity() {

    private lateinit var alarmManager: AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        AddPrd.setOnClickListener(){

            // Get AlarmManager instance
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

            // Intent part
            val intent = Intent(this, MedAlarmBroadcastReceiver::class.java)
            intent.action = "AddPrdNotify"
            //intent.putExtra("PrdName", editText.text)
            //registerReceiver()

            val pendingIntentRequestCode = 100
            //val flag = 0
            //val pendingIntent = PendingIntent.getBroadcast(this, pendingIntentRequestCode, intent, flag)

            val pendingIntent = PendingIntent.getBroadcast(this, pendingIntentRequestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            var intfil = IntentFilter()
                intfil.addAction("com.vnc.mdsolprodservices.MedAlarmBroadcastReceiver")
            registerReceiver(MedAlarmBroadcastReceiver(),intfil)

            val alarmDelayInSecond = 10
            val alarmTimeAtUTC = System.currentTimeMillis() + alarmDelayInSecond * 1_000L

            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTimeAtUTC, pendingIntent)


            Toast.makeText(this, "im sending message", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //alarmManager.cancel()

    }
}
