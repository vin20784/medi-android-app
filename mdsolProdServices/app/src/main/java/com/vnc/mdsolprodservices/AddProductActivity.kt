package com.vnc.mdsolprodservices

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vnc.mdsolprodservices.room.ProductDataEntity
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
        newIconimage.setOnClickListener{

//Create an Intent with action as ACTION_PICK

            //Create an Intent with action as ACTION_PICK
            val intent = Intent(Intent.ACTION_PICK)
            // Sets the type as image/*. This ensures only components of type image are selected

            intent.type = "image/*"
            //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.

            val mimeTypes =
                arrayOf("image/jpeg", "image/png")
            intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            // Launching the Intent

            startActivityForResult(intent, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result code is RESULT_OK only if the user selects an Image
        if (resultCode === Activity.RESULT_OK) when (requestCode) {
            2 -> {
                //data.getData returns the content URI for the selected Image
                val selectedImage: Uri? = data!!.data
                newIconimage.setImageURI(selectedImage)
            }
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        //alarmManager.cancel()


    }

    private fun saveProductDataInDB(it: View?) {
        var productDataEntity = ProductDataEntity(System.currentTimeMillis(), "eCoa", "medicle", "test")
        //productViewModel?.insert(productDataEntity);
        println("Data inserted successfully")
       /* var allProduct: List<ProductDataEntity>? = productViewModel?.getMedidataProductData()
        println(allProduct?.size)
        allProduct?.forEach() {
            println(productDataEntity.productName)
        }*/
    }
}
