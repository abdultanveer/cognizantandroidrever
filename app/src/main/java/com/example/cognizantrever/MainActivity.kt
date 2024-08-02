package com.example.cognizantrever

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cognizantrever.networking.MarsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var jsonButton: Button
    var TAG = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        jsonButton = findViewById(R.id.btnJson)

        jsonButton.setOnClickListener {
            getMarsPhotos()
        }
    }

    private fun getMarsPhotos() {
        GlobalScope.launch(Dispatchers.IO) {
            val listResult = MarsApi.retrofitService.getPhotos()
            Log.i(TAG,listResult)

        }
    }


    fun clickHandler(view: View) {
       // EditText nameEdittext = findViewById(R.id.etName)
        var nameEditText : EditText = findViewById(R.id.etName)
        var mainTextView : TextView = findViewById(R.id.tvMain)

        var data = nameEditText.text.toString();
        mainTextView.setText(data)

        var hIntention = Intent(this,HomeActivity::class.java)//explicit intent
        hIntention.putExtra("mykey",data)
        startActivity(hIntention)

    }

    fun openDialer(view: View) {
        var dialerIntention = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"))
        startActivity(dialerIntention)
    }

    fun setAlarm(view: View) {
        createAlarm("cognizantrev",20,43)
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        //if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        //}
    }

    fun openMyCalendar(view: View) {
        var calIntent = Intent("ineed.water")//AnyActivity -- implicit intent
        startActivity(calIntent)
    }

    fun sendFlightBroadcast(view: View) {
        var flightIntent = Intent("ihave.flight")
        intent.setComponent(
            ComponentName(
                "com.example.secondcognizant",
                "com.example.secondcognizant.FlightReceiver"
            )
        )

        sendBroadcast(flightIntent,"mypermission.password.portugal")
    }
}