package com.example.studentdbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.StringSearch;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbHelperClass extends SQLiteOpenHelper {
    public static final String dbname="Studentdb";
    public static final int version=1;

    public dbHelperClass(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE IF NOT EXISTS STUDENT(Name Text,Phone Text, Street Text, Email Text, Zip Text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertData(String name,String phone,String street,String email,String zip)
    {
        SQLiteDatabase db=getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("Name",name);
        cv.put("Phone",phone);
        cv.put("Street",street);
        cv.put("Email",email);
        cv.put("Zip",zip);

        db.insert("STUDENT",null,cv);
      //  Toast.makeText(this, "hello",Toast.LENGTH_LONG).show();

    }

    public Cursor fetchData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="Select Names from STUDENT";
        Cursor c= db.rawQuery(query,null);
//        ArrayList<Cursor> courseModalArrayList = new ArrayList<>();
        return c;


    }
}
