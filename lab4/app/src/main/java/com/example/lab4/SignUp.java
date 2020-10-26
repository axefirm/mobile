package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SignUp extends AppCompatActivity {

    EditText inputPassword1, inputAge, inputGender, inputMsisdn;
    DatePicker datePickerOfBirth;
    Button btnRegister, btnCancel;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        inputPassword1 = (EditText) findViewById(R.id.inputPassword1);
        inputAge = (EditText) findViewById(R.id.inputAge);
        inputGender = (EditText) findViewById(R.id.inputGender);
        inputMsisdn = (EditText) findViewById(R.id.inputMsisdn);
        datePickerOfBirth = (DatePicker) findViewById(R.id.datePickerOfBirth);


        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        db = new DBHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String username = intent.getStringExtra("username");
                String password = intent.getStringExtra("password");

                String password1 = inputPassword1.getText().toString();
                String age = inputAge.getText().toString();
                String gender = inputGender.getText().toString();
                String mobile = inputMsisdn.getText().toString();
                int day = datePickerOfBirth.getDayOfMonth();
                int month = datePickerOfBirth.getMonth();
                int year = datePickerOfBirth.getYear();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String formatedDate = sdf.format(calendar.getTime());

                Boolean result;
                Intent returnIntent = new Intent();


                if (password1.equals("") || age.equals("") || gender.equals("") || formatedDate.equals("")) {
                    Toast.makeText(SignUp.this, "Please enter all the fields", Toast.LENGTH_LONG).show();
                } else {
                    if (password.equals(password1)) {
                        result = db.insertData(username, password, age, gender, formatedDate, mobile);
                        if (result)
                            Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SignUp.this, "Register failed", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(SignUp.this, "Password is not same.", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

    }
}