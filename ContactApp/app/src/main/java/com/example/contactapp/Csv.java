package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Csv extends AppCompatActivity {

    Button btn_home;

    ListView lv_csv;

    ContactAdapter adapter;

    InputStream inputStream;

    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csv);

        btn_home = findViewById(R.id.btn_home);

        lv_csv = findViewById(R.id.lv_csv);

        lv_csv.setAdapter(adapter);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnHome();
            }
        });

        inputStream = getResources().openRawResource(R.raw.contactlist);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine;

            while ((csvLine = reader.readLine()) != null)
            {
                data = csvLine.split(",");
                try {
                    //Log.e("Data", "" + data[0]);
                    Log.e("Data ", "" + data[0] + "" + data[1]+ "" + data[2]+ "" + data[3]+ "" + data[4]+ "" + data[5]+ "" + data[6]+ "" + data[7]+ "" + data[8]);
                } catch (Exception e) {
                    Log.e("Problem", e.toString());
                }
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error im reading csv file: " + ex);
        }
    }

    public void returnHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
