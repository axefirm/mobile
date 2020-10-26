package com.example.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.PublicKey;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key, password TEXT, age TEXT, gender TEXT, birthDate TEXT, mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password, String age, String gender, String birthDate, String mobile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("age", age);
        contentValues.put("gender", gender);
        contentValues.put("birthDate", birthDate);
        contentValues.put("mobile", mobile);

        long result = db.insert("users", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username =?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean updateUserData(String username, String age, String gender, String birthDate, String mobile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("age", age);
        contentValues.put("gender", gender);
        contentValues.put("birthDate", birthDate);
        contentValues.put("mobile", mobile);

        long result = db.update("users", contentValues,
                "username = ? ", new String[]{username});
        if (result > 0)
            return true;
        else
            return false;
    }
    public Boolean changePass(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("password", password);

        long result = db.update("users", contentValues,
                "username = ? ", new String[]{username});
        if (result > 0)
            return true;
        else
            return false;
    }

    public Cursor getData(String username) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from users where username =?";
        Cursor cursor = db.rawQuery(sql, new String[]{username});
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username =? and password =?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
