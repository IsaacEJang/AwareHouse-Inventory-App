package com.example.a5_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor; // Corrected import for Cursor
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class user_database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "FIRST_NAME";
    public static final String COL_5 = "LAST_NAME";

    public user_database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, PASSWORD TEXT, FIRST_NAME TEXT, LAST_NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUser(String email, String password, String firstName, String lastName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, password);
        contentValues.put(COL_4, firstName);
        contentValues.put(COL_5, lastName);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1; // If result is -1 insertion failed
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { COL_1 },
                "EMAIL = ? AND PASSWORD = ?", new String[] { email, password },
                null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close(); // It's a good practice to close the database when you're done with it
        return cursorCount > 0;
    }
}
