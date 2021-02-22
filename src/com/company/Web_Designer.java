package com.company;

import java.sql.*;

public class Web_Designer extends Manager{
    int w_salary;
    String w_duties;

    public Web_Designer(Connection con) {
        super(con);
    }

    public String getW_duties() {
        return w_duties;
    }

    public void setW_duties(String w_duties) {
        this.w_duties = w_duties;
    }

    public int getW_salary() {
        return w_salary;
    }

    public void setW_salary(int w_salary) {
        this.w_salary = w_salary;
    }
    private Connection connection;
    public int w1(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT m_salary FROM Web_Designer WHERE employee_id = ?" )) {
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
    public static void main(String[] args) {

        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        ResultSet resultSet = null;
        Statement stmt = null;
        try {

            Class.forName("org.postgresql.Driver");


            con = DriverManager.getConnection(connectionUrl, "postgres", "aidalox2011");


            stmt = con.createStatement();
            String sql = "Create table Web_Designer" + "(employee_id int not null ,"+
                    "w_salary int not null," +
                    "w_duties varchar not null,"+
            "Foreign key (employee_id) references Employees (employee_id));"+
            "INSERT INTO Web_Designer (VALUES(456,200000,'comes up with a website design'));";

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
