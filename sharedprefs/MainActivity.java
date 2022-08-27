package com.example.sharedprefs;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("myapp", MODE_PRIVATE);
        String name = prefs.getString("name", "Not Found");
        String password = prefs.getString("password", "Not Found");
        if (!name.equals("Not Found") && !password.equals("Not Found")) {
            Intent i = new Intent(this, welcome.class);
            startActivity(i);
        }

    }

    public void signup(View v) {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    public void Validate(View view) {
        String username = prefs.getString("name", "Not Found");
        String password = prefs.getString("password", "Not Found");

        EditText txtname = findViewById(R.id.name);
        EditText txtpassword = findViewById(R.id.password1);
        if (txtname.getText().toString().equals(username) && txtpassword.getText().toString().equals(password)) {
            Intent intent = new Intent(this, welcome.class);
            startActivity(intent);
        }
    }
}