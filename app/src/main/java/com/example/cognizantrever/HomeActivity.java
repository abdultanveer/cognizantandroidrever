package com.example.cognizantrever;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //getintent which started this activity
       String dataReceived = getIntent().getExtras().getString("mykey");
        //from the intent i get extras -- mykey
        //set it on a textview
        TextView homeView = findViewById(R.id.tvHome);
        homeView.setText(dataReceived);

    }
}