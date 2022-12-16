package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="student";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="SURNAME";
    public static final String COL_4="MARK";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" ( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARK INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String surname, String mark){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, mark);
        long res=sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if(res==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String name, String surname, String mark){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, mark);
        sqLiteDatabase.update(TABLE_NAME, contentValues, "ID=?", new String[]{id});
        return true;
    }

    public int deleteData(String id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, "ID=?", new String[]{id});
    }

    public boolean loginFn(String name){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+" where NAME = ?", new String[]{name} );
        if(res==null){
            return false;
        }
        if(res.getCount()==0){
            return false;
        }else{
            return true;
        }
    }

}
