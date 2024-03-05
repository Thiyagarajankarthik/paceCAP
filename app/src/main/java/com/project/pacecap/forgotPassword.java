package com.project.pacecap;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {

    EditText resetEmail;
    Button submit;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        resetEmail=findViewById(R.id.resetemail);
        submit = findViewById(R.id.submit);
        auth=FirebaseAuth.getInstance();

        submit.setOnClickListener(view -> {
            String email=resetEmail.getText().toString();
            resetpassword(email);
        });

    }
    public void resetpassword(String email){
        auth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Toast.makeText(forgotPassword.this, "Password Reset Link Send To Your Email Kindly Check", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(forgotPassword.this, "Enter Your Registered Email Address", Toast.LENGTH_SHORT).show();
            }
        });
    }
}