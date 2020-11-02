package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Calendar extends AppCompatActivity {


    private ListView mListView;
    private ArrayAdapter aAdapter;
    private List<String> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        CalendarContentResolver calendarContentResolver = new CalendarContentResolver(Calendar.this);
        users = calendarContentResolver.getCalendars();
        mListView = (ListView) findViewById(R.id.eventList);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        mListView.setAdapter(aAdapter);
    }
}