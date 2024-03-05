package com.project.pacecap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class deviceDetails extends AppCompatActivity {

    EditText brandName,devicetype,serialNumber,modelNumber,implantNumber;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_details);
        brandName=findViewById(R.id.brandname);
        devicetype=findViewById(R.id.devicetype);
        serialNumber=findViewById(R.id.serialnumber);
        modelNumber=findViewById(R.id.modelnumber);
        implantNumber=findViewById(R.id.implantdate);
        next=findViewById(R.id.next);

        next.setOnClickListener(view -> {
            Intent i=new Intent(deviceDetails.this,location.class);
            startActivity(i);
        });
    }
}