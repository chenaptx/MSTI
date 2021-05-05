package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class SqlitelistActivity extends AppCompatActivity {
    ListView listView01;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_list);

        Toast.makeText(this,"register success！",Toast.LENGTH_LONG).show();

        listView01 = findViewById(R.id.listView01);

        dbHelper = new DatabaseHelper(this,"user.db",1);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(dbHelper.USER_TABLE,new String[]{"_id","username"},null,null,null,null,null,null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{"_id","username"},
                new int[]{android.R.id.text1,android.R.id.text1},
                0
        );
        listView01.setAdapter(adapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}
