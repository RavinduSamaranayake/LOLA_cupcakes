package com.example.user.lolascupcakes.Models;
public class User {

    int id;
    String email;
    String fname;
    String lname;
    String passwrd;
    int levelid;

    // constructors
    public User() {
    }

    public User(String email,String fname,String lname,String passwrd,int levelid ) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.passwrd = passwrd;
        this.levelid = levelid;
    }
    // setters



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public int getLevelid() {
        return levelid;
    }

    public void setLevelid(int levelid) {
        this.levelid = levelid;
    }


}











/*import com.example.user.lolascupcakes.Controlers.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    static Connection con = null;
    static PreparedStatement ps = null;

    public User() {
        con = MyConnection.getconnection();

    }

    public PreparedStatement UserLogin(String email, String passwd ) {  //GET role ID from user Table


        try {
            ps = con.prepareStatement("SELECT `role_id` FROM `users` WHERE `email` = ? AND `password` = ?");
            ps.setString(1, email);
            ps.setString(2, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;





    }
} */
