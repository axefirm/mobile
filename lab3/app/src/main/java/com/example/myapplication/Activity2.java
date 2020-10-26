package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        Button btnOk = (Button) findViewById(R.id.btnOk);
        checkBox1.setText(getIntent().getStringExtra("checkBox1"));
        checkBox2.setText(getIntent().getStringExtra("checkBox2"));
        checkBox3.setText(getIntent().getStringExtra("checkBox3"));

        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatePicker datePicker;
                datePicker = (DatePicker) findViewById(R.id.datePicker1);

                int   day  = datePicker.getDayOfMonth();
                int   month= datePicker.getMonth();
                int   year = datePicker.getYear();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("day", day);
                returnIntent.putExtra("month", month);
                returnIntent.putExtra("year", year);

                CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
                CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
                CheckBox checkBox3 = (CheckBox)findViewById(R.id.checkBox3);

                returnIntent.putExtra("checkBox1", checkBox1.isChecked());
                returnIntent.putExtra("checkBox2", checkBox2.isChecked());
                returnIntent.putExtra("checkBox3", checkBox3.isChecked());

                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}