package com.example.scholarship;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.common.base.MoreObjects;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class details extends AppCompatActivity {
    EditText erollno, ename;
    Button btn;
Spinner ecourse;
DatabaseReference stdref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        erollno = findViewById(R.id.rollno);
        ecourse = findViewById(R.id.crc);
        ename=findViewById(R.id.name);
        btn = findViewById(R.id.btn);

        stdref = FirebaseDatabase.getInstance().getReference().child("Scholarship");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertStudentData();
            }
        });
    }

    private void insertStudentData()
    {
        String addName =ename.getText().toString();
        String addRollno = erollno.getText().toString();
        String addCourse = ecourse.getSelectedItem().toString();

        studentData s = new studentData(addName,addRollno, addCourse);

        stdref.push().setValue(s);
        Toast.makeText(details.this, "Done.", Toast.LENGTH_SHORT).show();
    }
}
