package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register_page extends AppCompatActivity {
    EditText e_name,e_mail,e_phone,e_passnew,e_passReenter;
    Button b_register;
    SQLiteDatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        e_name=(EditText)findViewById(R.id.txt_name);
        e_mail=(EditText)findViewById(R.id.txt_email);
        e_phone=(EditText)findViewById(R.id.txt_phone);
        e_passnew=(EditText)findViewById(R.id.txt_pass_new);
        e_passReenter=(EditText)findViewById(R.id.txt_pass_reentered);
        b_register=(Button)findViewById(R.id.btn_register);

        sqldb =openOrCreateDatabase("Users_DB",MODE_PRIVATE,null);
        sqldb.execSQL("CREATE TABLE IF NOT EXISTS Registered_users(Name VARCHAR PRIMARY KEY,Email VARCHAR,Phone_no NUMBER,Password VARCHAR)");





    }
    public void do_register(View view){
        String name_recieved,mail_recieved,passnew_recieved,passReenter_recieved;
        int phone_recieved;
        name_recieved=e_name.getText().toString();
        mail_recieved=e_mail.getText().toString();
        passnew_recieved=e_passnew.getText().toString();
        passReenter_recieved=e_passReenter.getText().toString();
        phone_recieved= Integer.parseInt(e_phone.getText().toString());

        if(passnew_recieved.equals(passReenter_recieved)){

            try {
                sqldb.execSQL("INSERT INTO Registered_users VALUES('" + name_recieved + "','" + mail_recieved + "','" + phone_recieved + "','" + passnew_recieved + "')");
                e_name.setText("");
                e_mail.setText("");
                e_phone.setText("");
                e_passnew.setText("");
                e_passReenter.setText("");
                Toast.makeText(getApplicationContext(),"You are registered successfully",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(this,app_page.class);
                startActivity(intent);


            }catch (Exception e){
                Toast.makeText(getApplicationContext(),"Username already taken",Toast.LENGTH_SHORT).show();
                e_name.setText("");

            }

        }
        else{
            e_passnew.setText("");
            e_passReenter.setText("");

            Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_SHORT).show();

        }

    }
    public void check_db_data(View view){

        Intent intent=new Intent(this,display_dbdata.class);
        startActivity(intent);
    }
}
