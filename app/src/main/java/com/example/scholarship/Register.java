package com.example.scholarship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    Button rregister;
    EditText rfname, remail, rpassword, rphone;
    TextView rlogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rfname = findViewById(R.id.rfname);
        remail = findViewById(R.id.remail);
        rpassword = findViewById(R.id.rpassword);
        rphone = findViewById(R.id.rphone);
        rregister = (Button) findViewById(R.id.rregister);
        rlogin = (TextView) findViewById(R.id.rlogin);

        mAuth = FirebaseAuth.getInstance();

        rregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = remail.getText().toString();
                String password = rpassword.getText().toString();

                String fullName = rfname.getText().toString();
                String phone = rphone.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    remail.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    rpassword.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6) {
                    rpassword.setError("Password Must be Alteast 6 Characters");
                    return;
                }

                // create new user or register new user
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Registration Successful!",Toast.LENGTH_LONG).show();

                            // if the user created intent to login activity
                            Intent intent = new Intent(Register.this,SecondActivity.class);
                            startActivity(intent);
                        }
                        else {
                            // Registration failed
                            Toast.makeText(getApplicationContext(),"Registration Failed!!" + " Please Try Again Later",Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
            });

        rlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}




