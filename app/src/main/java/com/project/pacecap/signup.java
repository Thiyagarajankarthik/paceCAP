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

public class signup extends AppCompatActivity {

    EditText Email, password, confirmpassword;
    Button signup;
    TextView existaccount;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword);
        signup = findViewById(R.id.signup);
        auth=FirebaseAuth.getInstance();
        existaccount = findViewById(R.id.existaccount);

        existaccount.setOnClickListener(view -> {
            Intent i = new Intent(signup.this, Login.class);
            startActivity(i);
        });

        signup.setOnClickListener(view -> {
            String userEmail = Email.getText().toString();
            String userPassword = password.getText().toString();

            String userConfirmPassword = confirmpassword.getText().toString();
            if (userEmail.isEmpty()) {
                Email.setError("Enter Your Email");
            } else if (userPassword.isEmpty()) {
                password.setError("Enter Your Password");
            } else if (userConfirmPassword.isEmpty()) {
                confirmpassword.setError("Enter Confirm Password");
            }
            else if(!userPassword.equals(userConfirmPassword)){
                confirmpassword.requestFocus();
                confirmpassword.setError("Enter Correct Account Number");
            }
            else {
                signUp(userEmail, userPassword);
            }
        });


    }

    private void signUp(String userEmail, String userPassword) {
        auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                sendVerificationEmail();
                Toast.makeText(signup.this, "Verification Link Send To Your Email", Toast.LENGTH_SHORT).show();
            }
            else {
                // Registration failed
                Toast.makeText(signup.this, "Already Exist Login Your Account", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendVerificationEmail() {
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            user.sendEmailVerification()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup.this, "Verification email sent to Your EMAIL", Toast.LENGTH_SHORT).show();
                            // You can add code to navigate to a verification activity or handle the UI accordingly
                        } else {
                            Toast.makeText(signup.this, "Failed to send verification email", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

}