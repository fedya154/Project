package com.company;

import java.sql.*;
import java.sql.SQLException;
public class Manager extends Employees {
    int m_salary;
    String m_duties;
    private Connection connection;

    public Manager(Connection connection) {
        this.connection = connection;
    }

    public Manager() {

    }


    public int m1(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT m_salary FROM Manager WHERE employee_id = ?" )) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
                return (resultSet.getInt("m_salary"));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public String getM_duties() {
        return m_duties;
    }

    public void setM_duties(String m_duties) {
        this.m_duties = m_duties;
    }

    public int getM_salary() {
        return m_salary;
    }

    public void setM_salary(int m_salary) {
        this.m_salary = m_salary;
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
            String sql = "Create table Manager" + "(employee_id int not null  ,"+
                     "m_salary int not null," +
                    "m_duties varchar not null,"+
                    "Foreign key (employee_id) references Employees (employee_id));"+
            "INSERT INTO Manager (VALUES (234,200000,'Makes the project structure'));";
stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}




