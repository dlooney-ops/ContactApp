package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.Date;


public class Type extends AppCompatActivity {

    Button btn_biz, btn_person, btn_home;

    TextView tv_contactList;

    ContactAdapter adapter;

    ListView lv_contacts;

    AddressBook addressBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        btn_biz = findViewById(R.id.btn_biz);
        btn_person = findViewById(R.id.btn_person);
        btn_home = findViewById(R.id.btn_home);
        tv_contactList = findViewById(R.id.tv_contactList);
        lv_contacts = findViewById(R.id.lv_contacts);

        addressBook = ((MyApplication) this.getApplication()).getAddressBook();

        adapter = new ContactAdapter(Type.this, addressBook);

        lv_contacts.setAdapter(adapter);

        Bundle incomingMessages = getIntent().getExtras();

        if (incomingMessages !=null) {

            String name = incomingMessages.getString("Name");
            String phone = incomingMessages.getString("Phone Number");
            Location location = incomingMessages.getParcelable("Location");
            Date birthday = incomingMessages.getParcelable("Date");
            String info = incomingMessages.getString("Info");

            Person p = new  Person(name, phone, location, birthday, info);

            addressBook.getContactList().add(p);
            adapter.notifyDataSetChanged();

        }

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnHome();
            }
        });


        btn_biz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBiz();
            }
        });

        btn_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });

        lv_contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editContact(position);
            }
        });

    }

        public void editContact(int position) {

        Intent i = new Intent(getApplicationContext(), NewContact.class);

        BaseContact x = addressBook.getContactList().get(position);

        i.putExtra("Name", x.getName());
        i.putExtra("Phone", x.getPhone());

        startActivity(i);
        }

        public void returnHome() {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        public void addContact() {
            Intent intent = new Intent(this, NewContact.class);
            startActivity(intent);
        }

        public void addBiz() {
            Intent intent = new Intent(this, new_biz.class);
            startActivity(intent);
        }
}

