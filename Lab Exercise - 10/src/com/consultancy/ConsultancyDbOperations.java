package com.consultancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultancyDbOperations {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/consultancy_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void addClient(ConsultancyClient client) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO clients (name, contact, type, age, isActive) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, client.name);
                preparedStatement.setString(2, client.contact);
                preparedStatement.setString(3, client.type);
                preparedStatement.setInt(4, client.age);
                preparedStatement.setBoolean(5, client.isActive);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Client added to the database successfully.");
                } else {
                    System.out.println("Failed to add client to the database.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<ConsultancyClient> getAllClients() {
        List<ConsultancyClient> clients = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM clients";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String contact = resultSet.getString("contact");
                    String type = resultSet.getString("type");
                    int age = resultSet.getInt("age");
                    boolean isActive = resultSet.getBoolean("isActive");
                    ConsultancyClient client = new ConsultancyClient(name, contact, type, age, isActive);
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }    
    
    public static void deleteAllClients() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM clients";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Deleted successfully: " + rowsAffected + " row(s)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void updateClientContact(String clientName, String newContact) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "UPDATE clients SET contact = ? WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, newContact);
                preparedStatement.setString(2, clientName);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Client contact updated in the database successfully.");
                } else {
                    System.out.println("Failed to update client contact in the database.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 
}






