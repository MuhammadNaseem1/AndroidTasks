package com.example.mysqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class viewData extends AppCompatActivity {
sqlhelper helper;
ListView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        helper =new sqlhelper(this);
        myView=findViewById(R.id.list);
        ArrayList<String> array=new ArrayList<>();
        Cursor data=helper.getUserByID();
       while (data.moveToNext())
        {
             array.add(data.getString(1));
            ListAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,array);
            myView.setAdapter(adapter);
        }
    }
}