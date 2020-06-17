package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class display_dbdata extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        TextView t;
        Button b;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_dbdata);

        t=(TextView)findViewById(R.id.lbl_display);
        b=(Button)findViewById(R.id.btn_delete_data);

        final SQLiteDatabase sqldb=openOrCreateDatabase("Users_DB",MODE_PRIVATE,null);

        Cursor resultSet = sqldb.rawQuery("SELECT * FROM Registered_users",null);
        int total_rows=resultSet.getCount();
        resultSet.moveToFirst();
        for(int i=0;i<total_rows;i++){
            resultSet.moveToPosition(i);
            String existing_text = t.getText().toString();
            t.setText(existing_text+" "+resultSet.getString(0)+" "+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+"\n");

        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqldb.execSQL("DELETE FROM Registered_users");
            }
        });



    }

}
