package com.project.pacecap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText Email,password;
    Button Signin;
    TextView forgotpassword,signup;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        auth=FirebaseAuth.getInstance();
        Signin=findViewById(R.id.signin);
        forgotpassword=findViewById(R.id.forgotpassword);

        signup.setOnClickListener(view -> {
            Intent i=new Intent(Login.this,signup.class);
            startActivity(i);
        });
        Signin.setOnClickListener(view -> {
            String userEmail = Email.getText().toString();
            String userPassword = password.getText().toString();
            if (userEmail.isEmpty()) {
                Email.requestFocus();
                Email.setError("Enter Your Email");
            } else if (userPassword.isEmpty()) {
                password.requestFocus();
                password.setError("Enter Your Password");
            } else {

                signin(userEmail, userPassword);

            }

        });
        forgotpassword.setOnClickListener(view -> {
            Intent i=new Intent(Login.this,forgotPassword.class);
            startActivity(i);
        });
    }
    public void signin(String userEmail, String userPassword) {
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = auth.getCurrentUser();
                if (user != null && user.isEmailVerified()) {
                    Intent i = new Intent(Login.this, MainPage.class);
                    startActivity(i);
                    clearInputFields();
                } else {
                    // Email is not verified
                    Toast.makeText(Login.this, "Email not verified. Check your email for a verification link.", Toast.LENGTH_SHORT).show();

                }
            } else {
                Toast.makeText(Login.this, "Check your Email and Password", Toast.LENGTH_SHORT).show();
            }

        });

    }
    private void clearInputFields() {
        Email.setText("");
        password.setText("");
    }
}