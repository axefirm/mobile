package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activity1 = (Button) findViewById(R.id.activity1);

        activity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Activity1.class);
                i.putExtra("name", model.getName());
                i.putExtra("age", model.getAge());
                startActivityForResult(i, Activities.activity1);
            }
        });


        Button activity2 = (Button) findViewById(R.id.activity2);

        activity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Activity2.class);
                i.putExtra("checkBox1", model.getCheckBox1());
                i.putExtra("checkBox2", model.getCheckBox2());
                i.putExtra("checkBox3", model.getCheckBox3());
                i.putExtra("day", model.getDay());
                i.putExtra("month", model.getMonth());
                i.putExtra("year", model.getYear());

                startActivityForResult(i, Activities.activity2);
            }
        });


        Button activity3 = (Button) findViewById(R.id.activity3);

        activity3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Activity3.class);
                startActivityForResult(i, Activities.activity3);
            }
        });


        Button activity4 = (Button) findViewById(R.id.activity4);

        activity4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Activity4.class);
                startActivityForResult(i, Activities.activity4);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Activities.activity1) {
            if(resultCode == Activity.RESULT_OK){
                String name = data.getStringExtra("name");
                String age = data.getStringExtra("age");
                model.setAge(age);
                model.setName(name);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        } else if (requestCode == Activities.activity2) {
            if(resultCode == Activity.RESULT_OK){

                String day = data.getStringExtra("day");
                String month = data.getStringExtra("month");
                String year = data.getStringExtra("year");

                String checkBox1 = data.getStringExtra("checkBox1");
                String checkBox2 = data.getStringExtra("checkBox2");
                String checkBox3 = data.getStringExtra("checkBox3");

                model.setDay(day);
                model.setMonth(month);
                model.setYear(year);

                model.setCheckBox1(checkBox1);
                model.setCheckBox2(checkBox2);
                model.setCheckBox3(checkBox3);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        } else if (requestCode == Activities.activity3) {
            if(resultCode == Activity.RESULT_OK){

                String day = data.getStringExtra("day");
                String month = data.getStringExtra("month");
                String year = data.getStringExtra("year");

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    public static class Activities {
        static int activity1 = 1;
        static int activity2 = 2;
        static int activity3 = 3;
        static int activity4 = 4;
        static int activity5 = 5;
    }

}