package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class  DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = DatabaseHelper.class.getSimpleName();
    public static final String DB_NAME = "user.db";

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";

    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_CNFRMPASS = "cnfrmpassword";
    public int id=3;

    public DatabaseHelper(@Nullable Context context, @Nullable String name, int version) {
        super(context, name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("mine", "create Database");

        db.execSQL(" CREATE TABLE " + USER_TABLE +
                "(" + "_id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + COLUMN_EMAIL + " TEXT, " + COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " + COLUMN_CNFRMPASS + " TEXT " +")");
        Log.d("mine", "Finished Database");
        db.execSQL( "INSERT INTO users VALUES (1,'admin@163.com','admin',123,123)"
        );
        db.execSQL(  "INSERT INTO users VALUES (2,'zhangsan@163.com','zhangsan',123,123)"
                );

    }
    public void addUser(String email, String username, String password, String cnfrmpassword) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        id++;
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_CNFRMPASS, cnfrmpassword);
        db.insert(USER_TABLE, null, values);
        db.close();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
