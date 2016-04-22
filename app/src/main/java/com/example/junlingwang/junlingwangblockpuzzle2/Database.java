package com.example.junlingwang.junlingwangblockpuzzle2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by junlingwang on 22/04/16.
 */
public class Database extends SQLiteOpenHelper {

    public static int VERSION = 2;

    public Database (Context context ) {
        super (context, "Records", null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        setup(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        setup(db);
    }

    public void setup(SQLiteDatabase db){
        // reset the database
        db.execSQL("CREATE TABLE Records (_id INTEGER PRIMARY KEY, picture TEXT, times TEXT, date TEXT);");
    }

    public void add(String picture, String times, String date){
        this.getWritableDatabase().execSQL("INSERT INTO Records (picture, times, date) VALUES (\"" + picture + "\", \"" + times + "\", \"" + date + "\");");
    }

    public void delete(String picture){
        this.getWritableDatabase().execSQL("DELETE FROM Records WHERE picture = "+ picture +";");
    }

    public Cursor getAllCursor() {
        return getReadableDatabase().rawQuery("SELECT * FROM Records;", null);
    }
}
