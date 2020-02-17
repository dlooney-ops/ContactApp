package com.example.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewPersonContact extends AppCompatActivity {

    Button btn_cancel, btn_save;
    EditText et_name, et_phoneNumber, et_hobby, et_description, et_streetAddress, et_city, et_state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact2);

        btn_save.findViewById(R.id.btn_ok);

        et_name = findViewById(R.id.et_name);
        et_phoneNumber= findViewById(R.id.et_phoneNumber);
        et_hobby = findViewById(R.id.et_hobby);
        et_description = findViewById(R.id.et_description);
        et_streetAddress = findViewById(R.id.et_streetAddress);
        et_city = findViewById(R.id.et_city);
        et_state = findViewById(R.id.et_state);

        Bundle incomingIntent = getIntent().getExtras();

        if (incomingIntent != null) {
            String name = incomingIntent.getString("Name");
            int phoneNumber = incomingIntent.getInt("Phone Number");
            String hobby = incomingIntent.getString("Hobby");
            String description = incomingIntent.getString("Description");
            String streetAddress = incomingIntent.getString("Street Address");
            String city = incomingIntent.getString("City");
            String state = incomingIntent.getString("State");

            et_name.setText(name);
            et_phoneNumber.setText(Integer.toString(phoneNumber));
            et_hobby.setText(hobby);
            et_description.setText(description);
            et_streetAddress.setText(streetAddress);
            et_city.setText(city);
            et_state.setText(state);
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newName = et_name.getText().toString();
                String newPhoneNumber = et_phoneNumber.getText().toString();
                String newHobby = et_hobby.getText().toString();
                String newDescription = et_description.getText().toString();
                String newStreetAddress = et_streetAddress.getText().toString();
                String newCity = et_city.getText().toString();
                String newState = et_state.getText().toString();




                Intent i = new Intent(v.getContext(), MainActivity.class);

                i.putExtra("Name", newName);
                i.putExtra("Phone Number", newPhoneNumber);
                i.putExtra("Hobby", newHobby);
                i.putExtra("Description", newDescription);
                i.putExtra("Street Address", newStreetAddress);
                i.putExtra("City", newCity);
                i.putExtra("State", newState);

                startActivity(i);
            }
        });
    }
}