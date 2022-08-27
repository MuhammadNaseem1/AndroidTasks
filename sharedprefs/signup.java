package com.example.sharedprefs;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.os.Bundle;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void callSignin(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void Validate(View view)
    {
        EditText name=findViewById(R.id.fullname);
        EditText password=findViewById(R.id.password);
      //  EditText email=findViewById(R.id.email);

        SharedPreferences prefs = getSharedPreferences("myApp", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString("name", name.getText().toString());
        prefsEditor.putString("password", password.getText().toString());
      //  prefsEditor.putString("email", email.getText().toString());
        prefsEditor.apply();   // or commit();
        finish();
    }
}
