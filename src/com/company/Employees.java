package com.company;


import java.sql.*;
import java.sql.SQLException;
public class Employees {

    public Employees() {
    }
    int position_id;
    String FirstName;
    String LastName;
    int Age;
    int telephone;


    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getAge() {
        return Age;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public static void main(String[] args) {


        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        ResultSet resultSet = null;
        Statement stmt = null;
        try {

            Class.forName("org.postgresql.Driver");


            con = DriverManager.getConnection(connectionUrl, "postgres", "aidalox2011");


            stmt = con.createStatement();
            String sql="Create table Employees"+"(employee_id int not null primary key ,"
                    +"Firstname varchar not null,"+
                    "Lastname varchar not null,"+
                    "Age varchar not null,"+
                    "telephone varchar not null);"+
            "INSERT INTO Employees (VALUES (123,'Nikita','Petrovich','20','8772142341'),"+
                    "(234,'Nurxan','Yertayev','19','8192124124'),"+
                    "(345,'Asema','Asemovna','21','8712371273'),"+
            "(456,'Aleksnadr','Baranov','22','8772336212'));";
stmt.executeUpdate(sql);

        }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }









