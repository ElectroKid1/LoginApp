package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class app_page extends AppCompatActivity {
    TextView t;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_page);

        t=(TextView)findViewById(R.id.textView);


    }
}
