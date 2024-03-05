package com.project.pacecap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class caretaker extends AppCompatActivity {

    EditText name,mailorphone,relation,address;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caretaker);
        name=findViewById(R.id.name);
        mailorphone=findViewById(R.id.mailorphone);
        relation=findViewById(R.id.relation);
        address=findViewById(R.id.address);
        next=findViewById(R.id.next);

        next.setOnClickListener(view -> {
            Intent i=new Intent(caretaker.this,Login.class);
            startActivity(i);
        });
    }
}