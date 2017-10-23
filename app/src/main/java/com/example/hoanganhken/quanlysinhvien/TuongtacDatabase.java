package com.example.hoanganhken.quanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Hoang Anh Ken on 10/22/2017.
 */

public class TuongtacDatabase {
    Database database;
    SQLiteDatabase sqLiteDatabase;

    String arr[] = new String[]{database.COLUMN_ID
            , database.COLUMN_EMAIL
            , database.COLUMN_NAME
            , database.COLUMN_GT
            , database.COLUMN_LOP
            , database.COLUMN_SDT};

    public TuongtacDatabase(Context context) {
        database = new Database(context);
    }

    //  ham mo database
    public void open() {
        sqLiteDatabase = database.getWritableDatabase();
    }

    //ham dong datatbase
    public void close() {
        database.close();
    }

    // ham them sv vao bang
    public long themSV(SinhVien sv) {
        ContentValues cv = new ContentValues();
        cv.put(database.COLUMN_NAME, sv.getTen());
        cv.put(database.COLUMN_EMAIL, sv.getEmail());
        cv.put(database.COLUMN_GT, sv.getGioiTinh());
        cv.put(database.COLUMN_LOP, sv.getLopHoc());
        cv.put(database.COLUMN_SDT, sv.getSdt());

        return sqLiteDatabase.insert(database.TABLE_NAME, null, cv);

    }

    //ham sua sv trong bang
    public long suaSV(SinhVien sv) {
        ContentValues cv = new ContentValues();
        cv.put(database.COLUMN_NAME, sv.getTen());
        cv.put(database.COLUMN_EMAIL, sv.getEmail());
        cv.put(database.COLUMN_GT, sv.getGioiTinh());
        cv.put(database.COLUMN_LOP, sv.getLopHoc());
        cv.put(database.COLUMN_SDT, sv.getSdt());

        return sqLiteDatabase.update(database.TABLE_NAME, cv, database.COLUMN_ID + " = " + sv.getId(), null);

    }

    // ham xoa sv trong bang
    public long xoa(int id) {
        return sqLiteDatabase.delete(database.TABLE_NAME, database.COLUMN_ID + "=" + id, null);
    }

    // ham lay ra sll sv trong bang
    public ArrayList<SinhVien> getAllData() {
        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + database.TABLE_NAME + " ;", null);
        ArrayList<SinhVien> arr = new ArrayList<>();

        while (cursor.moveToNext()) {
            SinhVien sv = new SinhVien();
            sv.setId(cursor.getInt(cursor.getColumnIndex(database.COLUMN_ID)));
            sv.setTen(cursor.getString(cursor.getColumnIndex(database.COLUMN_NAME)));
            sv.setEmail(cursor.getString(cursor.getColumnIndex(database.COLUMN_EMAIL)));
            sv.setGioiTinh(cursor.getString(cursor.getColumnIndex(database.COLUMN_GT)));
            sv.setLopHoc(cursor.getString(cursor.getColumnIndex(database.COLUMN_LOP)));
            sv.setSdt(cursor.getString(cursor.getColumnIndex(database.COLUMN_SDT)));
            arr.add(sv);
        }
        return arr;
    }
}
