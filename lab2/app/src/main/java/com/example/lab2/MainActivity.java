package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///ADD
        Button btnAdd = (Button) findViewById(R.id.btAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc(Action.ADD);
            }
        });

        ///SUB
        Button btSub = (Button) findViewById(R.id.btSub);

        btSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc(Action.SUB);
            }
        });

        ///MULTIPLE
        Button btMulti = (Button) findViewById(R.id.btMulti);

        btMulti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc(Action.MULTIPLE);
            }
        });


        ///DIVIDE
        Button btDivide = (Button) findViewById(R.id.btDivide);

        btDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc(Action.DIVIDE);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAdd:
                calc(Action.ADD);
                break;
            case R.id.menuSub:
                calc(Action.SUB);
                break;
            case R.id.menuMultiply:
                calc(Action.MULTIPLE);
                break;
            case R.id.menuDivide:
                calc(Action.DIVIDE);
                break;
        }
        return true;
    }

    public enum Action {
        ADD,
        SUB,
        MULTIPLE,
        DIVIDE,
    }

    public void calc(Action action){

        EditText etValueA = (EditText) findViewById(R.id.etValueA);
        EditText etValueB = (EditText) findViewById(R.id.etValueB);
        EditText etResult = (EditText) findViewById(R.id.etResult);

        int result;
        String firstValue = etValueA.getText().toString();
        String secondValue = etValueB.getText().toString();
        if (firstValue.matches("") || secondValue.matches("")) {
            Log.d("ERROR: ", "EDIT TEXT IS EMPTY!");
            return;
        } else {
            switch (action){
                case ADD:
                    result = Integer.valueOf(etValueA.getText().toString()) + Integer.valueOf(etValueB.getText().toString());
                    Log.d("ACTION: ", String.valueOf(Action.ADD));
                    Log.d("RESULT: ", String.valueOf(result));
                    etResult.setText(String.valueOf(result));
                    break;
                case SUB:
                    result = Integer.valueOf(etValueA.getText().toString()) - Integer.valueOf(etValueB.getText().toString());
                    Log.d("ACTION: ", String.valueOf(Action.SUB));
                    Log.d("RESULT: ", String.valueOf(result));
                    etResult.setText(String.valueOf(result));
                    break;
                case MULTIPLE:
                    result = Integer.valueOf(etValueA.getText().toString()) * Integer.valueOf(etValueB.getText().toString());
                    Log.d("ACTION: ", String.valueOf(Action.MULTIPLE));
                    Log.d("RESULT: ", String.valueOf(result));
                    etResult.setText(String.valueOf(result));
                    break;
                case DIVIDE:
                    result = Integer.valueOf(etValueA.getText().toString()) / Integer.valueOf(etValueB.getText().toString());
                    Log.d("ACTION: ", String.valueOf(Action.DIVIDE));
                    Log.d("RESULT: ", String.valueOf(result));
                    etResult.setText(String.valueOf(result));
                    break;
            }
        }
    }
}