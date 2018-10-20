package com.example.user.lolascupcakes.Models;

import com.example.user.lolascupcakes.Controlers.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Member {
    Connection con = null;
    PreparedStatement ps = null;
    public Member(){
        con = MyConnection.getconnection();
    }
    public PreparedStatement UserReg(String firstname, String lastname, String email, String password,int roleid)  {
        con = MyConnection.getconnection();
        String query = "INSERT INTO `users`(`fname`, `lname`, `email`, `password`, `role_id`) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setInt(5, roleid);

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return ps;

    }

}


