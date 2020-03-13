package com.vnc.mdsolprodservices

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MedAlarmBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // Is triggered when alarm goes off, i.e. receiving a system broadcast

        if (intent.action == "AddPrdNotify") {
            Toast.makeText(context, "im inbroadcast and inside intent", Toast.LENGTH_LONG).show()
             val fooString : String = intent.getStringExtra("PrdName")
            Toast.makeText(context, fooString, Toast.LENGTH_LONG).show()
        }
    }
}
