package com.zhang.providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add_data = findViewById(R.id.add_data);
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.zhang.databasetest.provider/Book");
                ContentValues values = new ContentValues();
                values.put("name", "Just a book");
                values.put("author", "Unknown");
                values.put("pages", 1040);
                values.put("price", 22.85);

                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
            }
        });

        Button queryButton = findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.zhang.databasetest.provider/Book");
                Cursor cursor = getContentResolver().query(uri,
                        null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex
                                ("name"));
                        double price = cursor.getDouble(cursor.getColumnIndex
                                ("price"));

                        Log.d(TAG, String.format("Name: %s, Price: %f", name, price));
                    }

                    cursor.close();
                }
            }
        });

        Button updateData = findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.zhang.databasetest.provider/Book/" + newId);
                ContentValues updatedValues = new ContentValues();
                updatedValues.put("name", "Just a book(Updated)");
                getContentResolver().update(uri, updatedValues, null, null);
            }
        });

        Button deleteButton = findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.zhang.databasetest.provider/Book/" + newId);
                getContentResolver().delete(uri, null, null);
            }
        });
    }
}
