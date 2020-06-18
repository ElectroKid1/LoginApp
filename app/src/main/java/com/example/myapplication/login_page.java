package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

        b_login = (Button) findViewById(R.id.btn_login);
        b_register = (Button) findViewById(R.id.btn_register);
        l1 = (TextView) findViewById(R.id.lbl_heading1);
        l2 = (TextView) findViewById(R.id.lbl_ques);
        e_name = (EditText) findViewById(R.id.txt_name);
        e_pass = (EditText) findViewById(R.id.txt_pass);

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_entered,pass_entered;
                name_entered=e_name.getText().toString();
                pass_entered=e_pass.getText().toString();
                SQLiteDatabase sqldb = openOrCreateDatabase("Users_DB",MODE_PRIVATE,null);

                try {
                    Cursor resultSet = sqldb.rawQuery("SELECT Name, Password from Registered_users WHERE Name='"+name_entered+"'",null);
                    resultSet.moveToFirst();

                    if(name_entered.equals(resultSet.getString(0)) && pass_entered.equals(resultSet.getString(1))){
                        Toast.makeText(getApplicationContext(),"login successfull",Toast.LENGTH_SHORT).show();
                        e_pass.setText("");
                        e_name.setText("");

                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Wrong password",Toast.LENGTH_SHORT).show();
                        e_pass.setText("");
                        e_name.setText("");
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are not registered user.",Toast.LENGTH_SHORT).show();
                    e_pass.setText("");
                    e_name.setText("");
                }


            }
        });
    }

    public void do_register(View view){
        //Toast.makeText(getApplicationContext(),"This is to register you ",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,register_page.class);
        startActivity(intent);

    }

}
