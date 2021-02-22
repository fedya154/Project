package com.company;

import java.sql.*;

public class Layout_Designer extends Manager{
    private Connection connection;
    int l_salary;
    String l_duties;

    public String getL_duties() {
        return l_duties;
    }

    public void setL_duties(String l_duties) {
        this.l_duties = l_duties;
    }

    public int getL_salary() {
        return l_salary;
    }

    public void setL_salary(int l_salary) {
        this.l_salary = l_salary;
    }

    public Layout_Designer(Connection con) {
        super(con);
    }
    public int l1(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT l_salary FROM Layout_Designer WHERE employee_id = ?" )) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
                return (resultSet.getInt("l_salary"));
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
            String sql = "Create table Layout_Designer" + "(employee_id int not null ,"+
                     "l_salary int not null," +
                    "l_duties varchar not null,"+
            "Foreign key (employee_id) references Employees (employee_id));"+
            "INSERT INTO  Layout_Designer (VALUES (123,100000,'does the job of entering HTML code'));";

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
