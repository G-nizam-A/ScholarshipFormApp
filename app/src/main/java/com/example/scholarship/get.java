package com.example.scholarship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class get extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
   ListView listViewp;


    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    private TextView retrieveTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        listViewp=(ListView)findViewById(R.id.lview);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("Scholarship");

        retrieveTV = findViewById(R.id.idTVRetrieveData);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);

                retrieveTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(get.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
/*

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Scholarship").child("-N7M1NzbvjWmD1gBXoXD");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()) {
                    studentData pd = snapshot1.getValue(studentData.class);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/


    }
}