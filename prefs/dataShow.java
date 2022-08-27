package com.example.prefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class dataShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);
        TextView name1=findViewById(R.id.name1);
        TextView email1=findViewById(R.id.email1);
        TextView phone1=findViewById(R.id.phone1);
        SharedPreferences pref=getSharedPreferences("pref",MODE_PRIVATE);
      String n=  pref.getString("name","name");
      name1.setText(n);
      String e=pref.getString("mail","mail");
      email1.setText(e);
      Integer p=pref.getInt("p",123);
      phone1.setText(p);

    }
}