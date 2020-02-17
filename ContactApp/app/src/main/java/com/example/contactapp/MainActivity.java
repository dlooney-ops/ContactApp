package com.example.contactapp;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_showContacts, btn_addContact, btn_deleteContact, btn_editContact, btn_searchContact;
    TextView tv_contactList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setContentView(R.layout.search);


        btn_showContacts = findViewById(R.id.btn_showContacts);
        btn_addContact = findViewById(R.id.btn_addContact);
        btn_deleteContact = findViewById(R.id.btn_deleteContact);
        btn_editContact = findViewById(R.id.btn_editContact);
        btn_searchContact = findViewById(R.id.btn_searchContacts);

        tv_contactList = findViewById(R.id.tv_contactList);


        btn_addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newContact();
            }
        });

        btn_showContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listContacts();
            }
        });

        btn_deleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newContact();
            }
        });

        btn_editContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newContact();
            }
        });

        btn_searchContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listContacts();
            }
        });

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }


    }

        private void doMySearch(String query) {

    }

        private void newContact() {
            Intent intent = new Intent(this, Type.class);
            startActivity(intent);
        }

        private void listContacts() {
            Intent intent = new Intent(this, Csv.class);
            startActivity(intent);
        }




}
