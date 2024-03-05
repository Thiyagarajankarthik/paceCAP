package com.project.pacecap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class userDetails extends AppCompatActivity {
    EditText firstname,lastname,phonenumber,enterotp;
    Button next,getotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        phonenumber = findViewById(R.id.phone);
        enterotp = findViewById(R.id.enterotp);
        getotp =findViewById(R.id.otp);
        next=findViewById(R.id.next);
        getotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //auth
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(userDetails.this,deviceDetails.class);
                startActivity(i);
            }
        });
    }
}