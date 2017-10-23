package com.example.hoanganhken.quanlysinhvien;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hoang Anh Ken on 10/22/2017.
 */

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "qlsv.sqlite";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "sinhvien";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "ten";
    public static final String COLUMN_GT = "gioTinh";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_SDT = "sdt";
    public static final String COLUMN_LOP = "lop";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                String.format("CREATE TABLE %s( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)"
                        , TABLE_NAME
                        , COLUMN_ID
                        , COLUMN_NAME
                        , COLUMN_GT
                        , COLUMN_SDT
                        , COLUMN_EMAIL
                        , COLUMN_LOP));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
