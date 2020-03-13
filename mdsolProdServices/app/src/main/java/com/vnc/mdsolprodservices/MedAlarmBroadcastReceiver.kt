package com.vnc.mdsolprodservices

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MedAlarmBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // Is triggered when alarm goes off, i.e. receiving a system broadcast
        Toast.makeText(context, "im inbroadcast", Toast.LENGTH_LONG).show()
        if (intent.action == "AddPrdNotify") {
            val fooString = intent.getStringExtra("PrdName")
            Toast.makeText(context, fooString, Toast.LENGTH_LONG).show()
        }
    }
}
