package com.example.se1405_sprinner_datepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView txtBirthday;
    
    private Spinner spNationality;

    private String selectedSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBirthday = findViewById(R.id.txtBirthday);
        spNationality = findViewById(R.id.nationality);
        List<String> dataSrc = new ArrayList<>();
        dataSrc.add("Kinh");
        dataSrc.add("It nguoi");
        dataSrc.add("Nuoc ngoai");
        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataSrc);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNationality.setAdapter(dataAdapter);
        spNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                selectedSpinner = parent.getItemAtPosition(position).toString();
                selectedSpinner = spNationality.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String birthday = dayOfMonth + "-" + (month + 1) + "-" + year;
        txtBirthday.setText(birthday);
    }

    public void clickToChangeDate(View view) {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(), "DatePicker");
    }

    public void clickToCreate(View view) {
        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("nationality", selectedSpinner);
        intent.putExtra("birthday", txtBirthday.getText().toString());
        startActivity(intent);
    }
}