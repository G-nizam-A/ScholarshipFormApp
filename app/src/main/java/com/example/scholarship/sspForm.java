package com.example.scholarship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class sspForm extends AppCompatActivity   implements DatePickerDialog.OnDateSetListener {
    TextView sspDOB;
EditText  sspName, sspFatherName,  sspDur, sspTenReg, sspTenPass, sspRegNo, sspDis;
Spinner sspDay, sspCourseType,sspRen;

    Button btPickDate, sspApply;

    FirebaseDatabase db12 = FirebaseDatabase.getInstance();
    DatabaseReference stdref1=db12.getReference().child("Scholarship1");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssp_form);

        sspName= findViewById(R.id.sspName);
        sspFatherName= findViewById(R.id.sspFatherName);
        sspDur= findViewById(R.id.sspDur);
        sspTenReg= findViewById(R.id.sspTenReg);
        sspTenPass= findViewById(R.id.sspTenPass);
        sspRegNo= findViewById(R.id. sspRegNo);
        sspDis= findViewById(R.id.sspDis);
        sspRen = findViewById(R.id.sspRen);
        sspCourseType = findViewById(R.id.sspCourseType);
        sspDay= findViewById(R.id. sspDay);
        sspApply= findViewById(R.id.sspApply);

        sspDOB = findViewById(R.id.sspDOB);

        btPickDate = findViewById(R.id.btPickDate);

        btPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Please note that use your package name here
                com.example.scholarship.DatePicker mDatePickerDialogFragment;
                mDatePickerDialogFragment = new com.example.scholarship.DatePicker();
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
            }
        });
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        sspDOB.setText(selectedDate);

        sspApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSSPData();
            }
        });
    }

    private void insertSSPData() {
        String ssName =sspName.getText().toString();
        String ssFatherName = sspFatherName.getText().toString();
        String ssDur = sspDur.getText().toString();
        String ssTenReg = sspTenReg.getText().toString();
        String  ssTenPass = sspTenPass.getText().toString();
        String ssRegNo = sspRegNo.getText().toString();
        String ssDis = sspDis.getText().toString();
        String ssDay = sspDay.getSelectedItem().toString();
        String ssDOB = sspDOB.getText().toString();
        String ssRen = sspRen.getSelectedItem().toString();
        String ssCourseType = sspCourseType.getSelectedItem().toString();


        sspData sspD = new sspData(ssName,  ssFatherName,ssCourseType,ssDur, ssTenReg,  ssTenPass,  ssRegNo,  ssDay, ssRen,  ssDis);

        stdref1.push().setValue(sspD);
        Toast.makeText(sspForm.this, "Applied Successfully", Toast.LENGTH_SHORT).show();
    }
}
