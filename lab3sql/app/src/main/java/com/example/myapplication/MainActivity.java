package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteMisuseException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbhelper;
    EditText username;
    EditText password;
    EditText email;
    AppCompatButton register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper=new DatabaseHelper(this,"user.db",1);
        username=findViewById(R.id.Name);
        password=findViewById(R.id.Password);
        email=findViewById(R.id.Email);
        register=findViewById(R.id.Register);
        SQLiteDatabase  db = dbhelper.getWritableDatabase();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=username.getText().toString();
                String Password=password.getText().toString();
                String Email=email.getText().toString();
                dbhelper.addUser(Email,Name,Password,Password);
                Log.d("mine", "onClick: register");
                Intent intent = new Intent(v.getContext(), SqlitelistActivity.class);
                startActivity(intent);
            }
        });
    }
}
