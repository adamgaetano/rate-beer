package com.mushy.beer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BeerDatabaseHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "beer.db";

    public BeerDatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate (SQLiteDatabase db) {
        db.execSQL(BeerDataContract.BeerEntry.SQL_CREATE_BEER);
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void onDowngrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
