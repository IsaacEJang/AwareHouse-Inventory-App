package com.example.a5_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InventoryDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Inventory.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "inventory";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ITEM_NAME = "item_name";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_QUANTITY = "quantity";

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ITEM_NAME + " TEXT,"
                + COLUMN_LOCATION + " TEXT,"
                + COLUMN_QUANTITY + " INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addItem(String itemName, String location, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM_NAME, itemName);
        values.put(COLUMN_LOCATION, location);
        values.put(COLUMN_QUANTITY, quantity);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void removeItem(String itemName, String location, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Assuming you want to delete items based on all three criteria: name, location, and quantity
        String whereClause = COLUMN_ITEM_NAME + "=? AND " + COLUMN_LOCATION + "=? AND " + COLUMN_QUANTITY + "=?";
        String[] whereArgs = new String[] { itemName, location, String.valueOf(quantity) };
        db.delete(TABLE_NAME, whereClause, whereArgs);
        db.close();
    }

    public Cursor getAllItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
}
