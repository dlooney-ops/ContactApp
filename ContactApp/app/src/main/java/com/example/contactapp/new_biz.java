package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class new_biz extends AppCompatActivity {

    EditText et_bizName, et_bizNum, et_bizLocation, et_hourStart, et_hourEnd, et_website;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_biz);

        et_bizName = findViewById(R.id.et_bizName);
        et_bizNum = findViewById(R.id.et_bizNum);
        et_bizLocation = findViewById(R.id.et_bizLocation);
        et_hourStart = findViewById(R.id.et_hourStart);
        et_hourEnd = findViewById(R.id.et_hourEnd);
        et_website = findViewById(R.id.et_website);

        btn_save = findViewById(R.id.btn_save);

        Bundle incomingIntent = getIntent().getExtras();

        if (incomingIntent != null) {
            String bizName = incomingIntent.getString("Name");
            int bizNum = incomingIntent.getInt("Phone Number");
            String bizLocation = incomingIntent.getString("Location");
            int hourStart = incomingIntent.getInt("Hour Start");
            int hourEnd = incomingIntent.getInt("Hour End");
            String website = incomingIntent.getString("Website");

            et_bizName.setText(bizName);
            et_bizNum.setText(bizNum);
            et_bizLocation.setText(bizLocation);
            et_hourStart.setText(hourStart);
            et_hourEnd.setText(hourEnd);
            et_website.setText(website);
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newBizName = et_bizName.getText().toString();
                String newBizNum = et_bizNum.getText().toString();
                String newBizLocation = et_bizLocation.getText().toString();
                String newHourStart = et_hourStart.getText().toString();
                String newHourEnd = et_hourEnd.getText().toString();
                String newWebsite = et_website.getText().toString();

                Intent i = new Intent(v.getContext(), Type.class);


                i.putExtra("Name", newBizName);
                i.putExtra("Phone Number", newBizNum);
                i.putExtra("Location", newBizLocation);
                i.putExtra("Hour Start", newHourStart);
                i.putExtra("Hour End", newHourEnd);
                i.putExtra("Website", newWebsite);

                startActivity(i);
            }
        });
    }
}
