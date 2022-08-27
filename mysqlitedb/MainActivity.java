package com.example.mysqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    sqlhelper helperclass;
    Button add,show,delete;
EditText id,name,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            add=findViewById(R.id.add);
            show=findViewById(R.id.show);
            id=findViewById(R.id.id);
            name=findViewById(R.id.name);
            password=findViewById(R.id.password);
            delete=findViewById(R.id.Delete);
            helperclass=new sqlhelper(getApplicationContext());

                    add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helperclass=new sqlhelper(getApplicationContext());
                    String name1=name.getText().toString();
                    int id1=Integer.parseInt(id.getText().toString());
                    String pass=password.getText().toString();
                    helperclass.insertInLogin(id1,name1,pass);

                }
            });

                    show.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(getApplicationContext(),viewData.class);
                            startActivity(intent);
                        }
                    });
                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                          //  sqlhelper helper=new sqlhelper(getApplicationContext());
                            int value=Integer.parseInt(id.getText().toString());
                            helperclass.deleteRecord(value);
                        }
                    });
        //helperclass.onCreate();
    }
}