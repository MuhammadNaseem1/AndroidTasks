package com.example.prefs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


import android.view.View;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SharedPreferences prefs;
EditText name,email,phone;
Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);

        String Name="MyName";
        String Email="alinaseem";
        String Phone="022324343";

        SharedPreferences prefs=getSharedPreferences("prefs",MODE_PRIVATE);
        Button button=findViewById(R.id.button);
        show=findViewById(R.id.show);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String e=email.getText().toString();
                String p=phone.getText().toString();

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(Name,n);
                editor.putString(Email,e);
                editor.putString(Phone,p);
                editor.commit();
                Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,dataShow.class);
                startActivity(i);
            }
        });
    }

}