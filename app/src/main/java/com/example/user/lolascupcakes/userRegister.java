package com.example.user.lolascupcakes;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.lolascupcakes.Controlers.DatabaseHelper;

import com.example.user.lolascupcakes.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userRegister extends AppCompatActivity {
    EditText fname;
    EditText lname;

    EditText passwd;
    EditText conpasswd;
    EditText email;
    Button regAdmin;
    Button regMember;


    String returnEmail=null;
    String returnPassword=null;
    User user;


    DatabaseHelper dbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // getSupportActionBar().hide();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_register);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);

        passwd = (EditText) findViewById(R.id.passwd);
        conpasswd = (EditText) findViewById(R.id.conpasswd);
        email = (EditText) findViewById(R.id.email);
        regAdmin = (Button) findViewById(R.id.regAdmin);
        regMember = (Button) findViewById(R.id.regMember);

        dbase = new DatabaseHelper(this);
        user = new User();

        regAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = email.getText().toString().trim();
                if (fname.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_LONG).show();
                } else if (email.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "email is Empty", Toast.LENGTH_LONG).show();
                }
                 else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
                    Toast.makeText(getApplicationContext(), "Not Valid Email Address", Toast.LENGTH_LONG).show();
                }
                else if (passwd.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "password is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() < 8) {
                    Toast.makeText(getApplicationContext(), "password is short", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() > 20) {
                    Toast.makeText(getApplicationContext(), "password is long", Toast.LENGTH_LONG).show();
                } else if (!String.valueOf(passwd.getText()).equals(String.valueOf(conpasswd.getText()))) {
                    Toast.makeText(getApplicationContext(), "not match your entered passwords", Toast.LENGTH_LONG).show();
                } else {

                    String finame = fname.getText().toString();
                    String laname = lname.getText().toString();
                    String emai = email.getText().toString();
                    returnEmail = emai;
                    String passwrd = passwd.getText().toString();
                    returnPassword = passwrd;
                    //prepared statement of user as a Admin
                   user.setEmail(emai);
                    user.setFname(finame);
                    user.setLname(laname);
                    user.setPasswrd(passwrd);
                    user.setLevelid(0); //Admin Level Id is 0
                    dbase.createUser(user);
                   // dbase.createUser(emai,finame,laname,passwrd,0);
                    Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_LONG).show();
                    adminHomePg();







                }

            }

        });
        regMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = email.getText().toString().trim();
                if (fname.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_LONG).show();
                } else if (email.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "email is Empty", Toast.LENGTH_LONG).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
                    Toast.makeText(getApplicationContext(), "Not Valid Email Address", Toast.LENGTH_LONG).show();
                }
                else if (passwd.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "password is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() < 8) {
                    Toast.makeText(getApplicationContext(), "password is short", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() > 20) {
                    Toast.makeText(getApplicationContext(), "password is long", Toast.LENGTH_LONG).show();
                } else if (!String.valueOf(passwd.getText()).equals(String.valueOf(conpasswd.getText()))) {
                    Toast.makeText(getApplicationContext(), "not match your entered passwords", Toast.LENGTH_LONG).show();
                } else {

                    String finame = fname.getText().toString();
                    String laname = lname.getText().toString();
                    String emai = email.getText().toString();
                    returnEmail = emai;
                    String passwrd = passwd.getText().toString();
                    returnPassword = passwrd;
                    user.setEmail(emai);
                    user.setFname(finame);
                    user.setLname(laname);
                    user.setPasswrd(passwrd);
                    user.setLevelid(1); //Member Level Id is 1
                    dbase.createUser(user);
                    Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_LONG).show();
                    memberHomePg();

                }
            }
        });
    }


    public void adminHomePg() {
        Intent intent = new Intent(this, AdminHome.class);
        intent.putExtra("Email",email.getText().toString()); //for email get to the home page
        intent.putExtra("Password",passwd.getText().toString());
        startActivity(intent);

    }

    public void memberHomePg() {
        Intent intent = new Intent(this, memberHome.class);
       // System.out.println("Email = "+returnEmail);
      //  System.out.println("password = "+returnPassword);
        intent.putExtra("Email",returnEmail);
        intent.putExtra("Password",returnPassword);
        startActivity(intent);
    }

}
