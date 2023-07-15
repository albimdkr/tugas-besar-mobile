package com.albi.tugas_besar_albi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "datacatatan.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Usercatatan(nama TEXT primary key, catatan TEXT, tgl TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Usercatatan");
    }

    //INSERT
    public Boolean insertdatacatatan(String nama, String catatan, String tgl){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama", nama);
        contentValues.put("catatan", catatan);
        contentValues.put("tgl", tgl);
        long result=DB.insert("Usercatatan", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    //UPDATE
    public Boolean updatedatacatatan(String nama, String catatan, String tgl){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("catatan", catatan);
        contentValues.put("tgl", tgl);
        Cursor cursor = DB.rawQuery("Select * from Usercatatan where nama = ?", new String[]{nama});
        if (cursor.getCount() > 0) {
            long result = DB.update("Usercatatan", contentValues, "nama=?", new String[]{nama});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    //DELETE
    public Boolean deletedatacatatan (String nama){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Usercatatan where nama = ?", new String[]{nama});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Usercatatan", "nama=?", new String[]{nama});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    //GET DATA
    public Cursor getdata () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Usercatatan", null);
        return cursor;

    }
}
