/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanager;

import java.sql.*;

/**
 *
 * @author justin
 */
public class DBHandler {

    Connection connection = null;

    DBHandler() {
        try {

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:contacts.db");
            System.out.println("Connected to contacts database.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        

    }

    boolean insertRow(
            String firstName,
            String lastName,
            String phone,
            String email) {
        String sql = "insert into Contact (FirstName, LastName, Phone, Email) values (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.executeQuery();
            ResultSet rs = ps.getGeneratedKeys();
            System.out.println(rs.getInt(0));
            System.out.println(rs.getInt(0));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace();
        }
        return true;

    }

    String[] selectRow() {
        String[] row = null;
        String sql = "insert into Country (CountryName, Population) values (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
        } catch (SQLException e) {

        }
        return row;
    }
    
    
}
