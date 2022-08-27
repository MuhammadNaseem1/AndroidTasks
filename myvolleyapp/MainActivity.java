package com.example.myvolleyapp;
import android.graphics.Bitmap;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
String url="https://unsplash.com/photos/PAHUfjEdAKM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view)
    {
        RequestQueue queue= Volley.newRequestQueue(this);
    ImageRequest request= new ImageRequest(Request.Method.GET, url, new Response.Listener<Bitmap>() {
        @Override
        public void onResponse(ImageRequest response) {
System.out.println("Resposne");

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }

    );
queue.add(request);

    }
}