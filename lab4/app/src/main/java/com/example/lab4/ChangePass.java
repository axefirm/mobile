package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePass extends AppCompatActivity {

    Button btnSave, btnCancel;

    DBHelper db;
    EditText inputNewPass1, inputNewPass, inputOldPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        db = new DBHelper(this);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        inputNewPass = (EditText) findViewById(R.id.inputNewPass);
        inputNewPass1 = (EditText) findViewById(R.id.inputNewPass1);
        inputOldPass = (EditText) findViewById(R.id.inputOldPass);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String username = intent.getStringExtra("username");
                if (db.checkUsernamePassword(username, inputOldPass.getText().toString())) {
                    if (inputNewPass.getText().toString().equals(inputNewPass1.getText().toString())) {
                        Boolean result = db.changePass(username, inputNewPass.getText().toString());
                        if (result) {
                            Toast.makeText(ChangePass.this, "Password changed successfully", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ChangePass.this, "Password change failed", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(ChangePass.this, "New passwords are not same.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(ChangePass.this, "Old password is wrong", Toast.LENGTH_LONG).show();
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