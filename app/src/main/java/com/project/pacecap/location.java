package com.project.pacecap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class location extends AppCompatActivity {

    EditText address,city,pincode,state,country;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        address=findViewById(R.id.address);
        city=findViewById(R.id.city);
        pincode=findViewById(R.id.pincode);
        state=findViewById(R.id.state);
        country=findViewById(R.id.country);
        next=findViewById(R.id.next);

        next.setOnClickListener(view -> {
            Intent i=new Intent(location.this,caretaker.class);
            startActivity(i);
        });
    }
}