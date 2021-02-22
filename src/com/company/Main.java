package com.company;

import java.sql.*;

public class Main {


    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
      Connection con = null;
   ResultSet resultSet = null;
     Statement stmt = null;
        try {

            Class.forName("org.postgresql.Driver");


            con = DriverManager.getConnection(connectionUrl, "postgres", "aidalox2011");


            stmt = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }

Manager m=new Manager(con);
        Layout_Designer l=new Layout_Designer(con);
        Tester t=new Tester(con);
        Web_Designer w=new Web_Designer(con);
      System.out.print(t.t1(345)+m.m1(234)+w.w1(456));




    }
}
