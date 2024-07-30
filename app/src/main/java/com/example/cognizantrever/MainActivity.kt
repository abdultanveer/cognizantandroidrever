package com.example.cognizantrever

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

    }

    fun clickHandler(view: View) {
       // EditText nameEdittext = findViewById(R.id.etName)
        var nameEditText : EditText = findViewById(R.id.etName)
        var mainTextView : TextView = findViewById(R.id.tvMain)

        var data = nameEditText.text.toString();
        mainTextView.setText(data)

        var hIntention = Intent(this,HomeActivity::class.java)
        hIntention.putExtra("mykey",data)
        startActivity(hIntention)

    }
}