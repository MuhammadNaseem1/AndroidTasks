package com.example.readwritefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText text;
    String filename="myfile.txt";
    TextView tv;
    FileOutputStream f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.t);
        tv=findViewById(R.id.tv);
    }
    public void onclickButton(View view)
    {
        String t=text.getText().toString();

    try {
        f= openFileOutput(filename,MODE_APPEND);
             f.write(t.getBytes());

          //   text.getText().clear();

             f.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    }
    public void onshowbutton(View v)
    {
        File directory=this.getFilesDir();
        File file=new File(directory,filename);
        try {

            Scanner s=new Scanner(file);
            while(s.hasNext())
            {
                String line=s.nextLine();
                tv.setText(line);
            }
            s.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
