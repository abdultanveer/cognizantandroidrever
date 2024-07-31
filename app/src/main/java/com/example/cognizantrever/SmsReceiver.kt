package com.example.cognizantrever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SmsReceiver : BroadcastReceiver() {
//android - 6 runtime permission

    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG, "abdul u 've sms -- cognizant")
    }

    companion object{
        var TAG = SmsReceiver::class.java.simpleName
    }
}