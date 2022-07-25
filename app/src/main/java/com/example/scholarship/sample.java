package com.example.scholarship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sample extends AppCompatActivity {
    TextView ebtn;
    EditText ename, erollno;
    Spinner ecourse;

    FirebaseDatabase db1 = FirebaseDatabase.getInstance();
    DatabaseReference stdref=db1.getReference().child("Scholarship");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        ename = findViewById(R.id.ename);
        erollno = findViewById(R.id.erollno);
        ecourse = findViewById(R.id.ecourse);
        ebtn = (TextView) findViewById(R.id.ebtn);
        ebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertStudentData();
            }
        });
    }

    private void insertStudentData() {
        String addName = ename.getText().toString();
        String addRollno = erollno.getText().toString();
        String addCourse = ecourse.getSelectedItem().toString();

        studentData s = new studentData(addName, addRollno, addCourse);

        stdref.push().setValue(s);

        Toast.makeText(sample.this, "Done.", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),get.class));
    }
}

