package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserInfo extends AppCompatActivity {

    DBHelper db;
    TextView name;

    EditText inputAge, inputGender,inputMobile;
    Button btnSave, btnChangePass;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        name = (TextView) findViewById(R.id.name);
        inputAge = (EditText) findViewById(R.id.inputAge);
        inputGender = (EditText) findViewById(R.id.inputGender);
        inputMobile = (EditText) findViewById(R.id.inputMsisdn);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnChangePass = (Button) findViewById(R.id.btnChangePass);
        datePicker = (DatePicker) findViewById(R.id.datePickerOfBirth);

        db = new DBHelper(this);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        Cursor cursor = db.getData(username);
        String UserName, age,gender,mobile,date;
        if (cursor.moveToFirst()){
            do{
                UserName = cursor.getString(cursor.getColumnIndex("username"));
                name.setText(UserName);
                age = cursor.getString(cursor.getColumnIndex("age"));
                inputAge.setText(age);
                gender = cursor.getString(cursor.getColumnIndex("gender"));
                inputGender.setText(gender);
                mobile = cursor.getString(cursor.getColumnIndex("mobile"));
                inputMobile.setText(mobile);
                date = cursor.getString(cursor.getColumnIndex("birthDate"));
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date birthDate = format.parse(date);
                    String day          = (String) DateFormat.format("dd",   birthDate); // 20
                    String monthNumber  = (String) DateFormat.format("MM",   birthDate); // 06
                    String year         = (String) DateFormat.format("yyyy", birthDate);
                    datePicker.init(Integer.parseInt(year), Integer.parseInt(monthNumber), Integer.parseInt(day), new DatePicker.OnDateChangedListener() {
                        @Override
                        public void onDateChanged(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                            // Notify the user.

                        }
                    });
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // do what ever you want here
            }while(cursor.moveToNext());
        }
        cursor.close();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String formatedDate = sdf.format(calendar.getTime());
                Boolean result =  db.updateUserData(name.getText().toString(),inputAge.getText().toString(),inputGender.getText().toString(),formatedDate,inputMobile.getText().toString());
                if(result){
                    Toast.makeText(UserInfo.this,"Updated successfully",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(UserInfo.this,"Update failed",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfo.this, ChangePass.class);
                intent.putExtra("username", name.getText().toString());

                startActivity(intent);
            }
        });
    }
}