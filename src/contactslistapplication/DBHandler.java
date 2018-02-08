/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactslistapplication;

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

    /**
     * This method inserts a new contact into the SQLite database and returns
     * that row's auto-generated key.
     *
     * @param firstName the first name of the new contact
     * @param lastName the last name of the new contact
     * @param phone the phone of the new contact
     * @param email the email of the new contact
     * @return the id of the new row added
     */
    int insertRow(
            String firstName,
            String lastName,
            String phone,
            String email) {
        String sql = "insert into Contact (FirstName, LastName, Phone, Email) values (?, ?, ?, ?)";
        int id = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            id = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
        return id;
    }

    String[] selectRow(int id) {
        String[] row = null;
        String sql = "select * from Contact where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(2, String.valueOf(id));
        } catch (SQLException e) {

        }
        return row;
    }

}
