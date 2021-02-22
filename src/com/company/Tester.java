package com.company;

import java.sql.*;

public class Tester extends Manager{
    int t_salary;
    String t_duties;

    public Tester(Connection con) {
        super(con);
    }

    public String getT_duties() {
        return t_duties;
    }

    public void setT_duties(String t_duties) {
        this.t_duties = t_duties;
    }

    public int getT_salary() {
        return t_salary;
    }

    public void setT_salary(int t_salary) {
        this.t_salary = t_salary;
    }


    private Connection connection;
    public int t1(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT t_salary FROM Tester WHERE employee_id = ?" )) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
                return (resultSet.getInt("t_salary"));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
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
            String sql = "Create table Tester" + "(employee_id int not null ,"+
                    "t_salary int not null," +
                    "t_duties varchar not null,"+
            "Foreign key (employee_id) references Employees (employee_id));"+
            "INSERT INTO Tester (VALUES(345,150000,'test the program for errors'));";

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
