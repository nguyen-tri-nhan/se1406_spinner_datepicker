package com.example.se1405_sprinner_datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        txtResult = findViewById(R.id.txtResult);
        Intent intent = this.getIntent();

        String nationality = intent.getStringExtra("nationality");
        String birthday = intent.getStringExtra("birthday");

        txtResult.setText("Nationality: " + nationality + " - Birthday: " + birthday);
    }
}