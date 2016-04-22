package com.example.junlingwang.junlingwangblockpuzzle2;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Statistics extends AppCompatActivity {
    private Database records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }
        );

        records = new Database (this);
        Cursor cursor = records.getAllCursor();

//        int count = cursor.getCount();
//        System.out.println("count: " + count);
//        while (cursor.moveToNext()) {
//            String name = cursor.getString(0);
//            String breed = cursor.getString(1);
//            System.out.println(String.format("%s, %s", name, breed));
//        }
//        cursor.close();

        ListView listView = (ListView) findViewById(R.id.listView);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.item_view,
                cursor,
                new String[] {"picture", "times", "date"},
                new int[] {R.id.picture, R.id.times, R.id.date},
                0);
        listView.setAdapter(adapter);
    }

}
