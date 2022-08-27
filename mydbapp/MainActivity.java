package com.example.mydbapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
EditText t;
FileOutputStream f;
TextView showText;
String filename="myfile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

          public void onClicksave(View v)
          {
             String text=t.getText().toString();
             try {
                 f=openFileOutput(filename,MODE_APPEND);
                 f.write(text.getBytes());
                 t.getText().clear();
                 f.close();
             }catch (Exception e)
             {
                 e.printStackTrace();
             }

          }
          public void onClickShow(View v)
          {
              File directory=this.getFilesDir();
              File file=new File(directory,filename);
try {


    Scanner s = new Scanner(filename);
    while (s.hasNext()) {
        String line = s.nextLine();
        showText.setText(line);


    }
}catch (Exception e)
{
    e.printStackTrace();
}
          }

}