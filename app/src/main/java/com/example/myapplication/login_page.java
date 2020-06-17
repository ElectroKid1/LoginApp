package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_page extends AppCompatActivity {
    Button b_login,b_register;
    TextView l1,l2;
    EditText e_name,e_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        b_login=(Button)findViewById(R.id.btn_login);
        b_register=(Button)findViewById(R.id.btn_register);
        l1=(TextView)findViewById(R.id.lbl_heading1);
        l2=(TextView)findViewById(R.id.lbl_ques);
        e_name=(EditText)findViewById(R.id.txt_name);
        e_pass=(EditText)findViewById(R.id.txt_pass);


        }
        public void do_login(View view){
            Toast.makeText(getApplicationContext(),"HELLO WORLD",Toast.LENGTH_SHORT).show();

        }
        public void do_register(View view){
            //Toast.makeText(getApplicationContext(),"This is to register you ",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,register_page.class);
            startActivity(intent);

        }

    }
