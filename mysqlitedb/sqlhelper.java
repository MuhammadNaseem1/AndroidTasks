package com.example.mysqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class sqlhelper extends SQLiteOpenHelper {
    public static String DBNAME = "test.db";
    public static int version = 1;
    Context c;

    public sqlhelper(Context context) {
        super(context, DBNAME, null, version);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE LOGIN(ID INTEGER,username text, password text)";
        db.execSQL(query);

        //ContentValues cv=new ContentValues();
        // cv.put("username","Naseem");
        //cv.put("password" ,123);

        // db.insert("LOGIN",null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertInLogin(int Id, String uname, String Pass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", "ID");
        cv.put("username", uname);

        cv.put("password", Pass);
        long data = db.insert("LOGIN", null, cv);
        if (data != -1) {
            Toast.makeText(c, "Data is successfully inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(c, "Something is wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor getUserByID() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM LOGIN";
        return db.rawQuery(query, null);

    }

    public void deleteRecord(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = getUserByID();
String query="Select * from LOGIN where id="+id;
if(query!="")
{
    db.delete("LOGIN", "id="+id, null);
    Toast.makeText(c, "The given Id Exists and is deleted", Toast.LENGTH_SHORT).show();
}
        /*while (data.moveToNext()) {
            if (data.getString(0).equals(id)) {
                Toast.makeText(c, "The given Id Exists", Toast.LENGTH_SHORT).show();


                String query = "select *  from login where id=" + id;
                //ContentValues cv= new ContentValues();
                db.delete("login", "id=" + id, null);
                Toast.makeText(c, "The given Id Exists and is deleted", Toast.LENGTH_SHORT).show();
            }*/ else {
                Toast.makeText(c, "The given Id Does not Exist", Toast.LENGTH_SHORT).show();
            }
        }


    }




