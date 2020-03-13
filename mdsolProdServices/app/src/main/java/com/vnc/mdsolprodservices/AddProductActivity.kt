package com.vnc.mdsolprodservices

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.vnc.mdsolprodservices.room.ProductDataEntity
import com.vnc.mdsolprodservices.room.ProductDatabase
import com.vnc.mdsolprodservices.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_add_product.*

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity : AppCompatActivity() {

    private lateinit var alarmManager: AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        addPrdButton.setOnClickListener() {

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

            val pendingIntent = PendingIntent.getBroadcast(
                this,
                pendingIntentRequestCode,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            var intfil = IntentFilter()
            intfil.addAction("com.vnc.mdsolprodservices.MedAlarmBroadcastReceiver")
            registerReceiver(MedAlarmBroadcastReceiver(), intfil)

            val alarmDelayInSecond = 10
            val alarmTimeAtUTC = System.currentTimeMillis() + alarmDelayInSecond * 1_000L

            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                alarmTimeAtUTC,
                pendingIntent
            )


            Toast.makeText(this, "im sending message", Toast.LENGTH_LONG).show()

            addPrdButton.setOnClickListener() {
                saveProductDataInDB(it);

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //alarmManager.cancel()


    }

    private fun saveProductDataInDB(it: View?) {
        var productDataEntity =
            ProductDataEntity(System.currentTimeMillis(), "eCoa", "medicle", "test")
        //productViewModel?.insert(productDataEntity);
        println("Data inserted successfully")
       /* var allProduct: List<ProductDataEntity>? = productViewModel?.getMedidataProductData()
        println(allProduct?.size)
        allProduct?.forEach() {
            println(productDataEntity.productName)
        }*/
    }
}
