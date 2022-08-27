package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView t1,t2,t3,t4,t5;
EditText name,phone,street,zip,email;
Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.phone);
        t3=findViewById(R.id.street);
        t4=findViewById(R.id.email);
        t5=findViewById(R.id.zip);

        name=findViewById(R.id.nametext);
        String name1=name.getText().toString();
        phone=findViewById(R.id.phoneText);
        String phone1=phone.getText().toString();

        street=findViewById(R.id.streettext);
        String street1=street.getText().toString();
        email=findViewById(R.id.emailtext);
        String email1=email.getText().toString();

        zip=findViewById(R.id.ziptext);
String zip1=zip.getText().toString();
        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students s=new students(name1,phone1,street1,email1,zip1);
                dbHelperClass helper=new dbHelperClass(getApplicationContext());
                helper.insertData(name1,phone1,street1,email1,zip1);
                Cursor cursor=helper.fetchData();
                final int nameIndex = cursor.getColumnIndex("Name");
                ArrayList<String> names=new ArrayList<>();
                while(cursor.moveToNext())
                {
                    String name=cursor.getString(0);
                    names.add(name);
                    System.out.println(names);
                }

            }
//                try {
//
//                    // If moveToFirst() returns false then cursor is empty
//                    if (!cursor.moveToNext()e) {
//                        return new ArrayList<>();
//                    }
//
//                    final List<> products = new ArrayList<>();
//                }
//                    do {
//                        final String name = cursor.getString(nameIndex);
//                    }while(cursor.moveToNext());
//
//
//                    }
        });


    }
}