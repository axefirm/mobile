package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        EditText editTextName = (EditText) findViewById(R.id.name);
        EditText editTextAge = (EditText) findViewById(R.id.age);

        editTextName.setText(getIntent().getStringExtra("name"));
        editTextAge.setText(getIntent().getStringExtra("age"));

        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        Button btnOk = (Button) findViewById(R.id.btnOk);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editTextName = (EditText) findViewById(R.id.name);
                EditText editTextAge = (EditText) findViewById(R.id.age);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("name", editTextName.getText().toString());
                returnIntent.putExtra("age", editTextAge.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }

}