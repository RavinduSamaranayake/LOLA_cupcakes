package com.example.user.lolascupcakes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.lolascupcakes.Controlers.DatabaseHelper;
import com.example.user.lolascupcakes.Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends AppCompatActivity {
    Button tomain;
    Button userregpg;
    EditText username;
    EditText passwd;
    SQLiteDatabase db;
    DatabaseHelper openHelper;
    Cursor cursor;

   // User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tomain = (Button) findViewById(R.id.login);
        userregpg = (Button) findViewById(R.id.regBtn);
        username = (EditText) findViewById(R.id.txtUname);
        passwd = (EditText) findViewById(R.id.txtPasswd);
        openHelper=new  DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        //user = new User();

        tomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String paswd = passwd.getText().toString();
                cursor = db.rawQuery("SELECT "+ DatabaseHelper.KEY_LEVELID + " FROM " + DatabaseHelper.TABLE_USER + " WHERE " + DatabaseHelper.KEY_EMAIL + "=? AND " + DatabaseHelper.KEY_PASWD + "=?", new String[]{uname, paswd});
                if (cursor != null) {

                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst(); //to get the user levelId
                        int levelId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.KEY_LEVELID));

                       if(levelId == 0){
                            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                            adminHomePg();
                        }
                        if(levelId == 1){
                            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                            memberHomePg();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        userregpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load();
                openregpg();
            }
        });


    }
    public void adminHomePg() {
        Intent intent = new Intent(this, AdminHome.class);
        intent.putExtra("Email",username.getText().toString()); //for email get to the home page
        intent.putExtra("Password",passwd.getText().toString());
        startActivity(intent);

    }

    public void memberHomePg() {
        Intent intent = new Intent(this, memberHome.class);
        intent.putExtra("Email",username.getText().toString()); //for email get to the home page
        intent.putExtra("Password",passwd.getText().toString());
        startActivity(intent);
    }
    public void openregpg() {
        Intent intent = new Intent(this,userRegister.class);
        startActivity(intent);
    }
}
