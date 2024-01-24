// NgoDAO.java
package com.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NgoDAO {
    private Connection connection;

    public NgoDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addNgo(Ngo ngo) {
        String sql = "INSERT INTO user (firstName, lastName, email, password, mobileNo, gender, roleId, roleName, uniqueId) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, ngo.getOwnerFirstName());
            statement.setString(2, ngo.getOwnerLastName());
            statement.setString(3, ngo.getEmail());
            statement.setString(4, ngo.getPassword());
            statement.setString(5, ngo.getMobileNo());
            statement.setString(6, ngo.getGender());
            statement.setInt(7, 3); // Assuming roleId 3 is for NGOs
            statement.setString(8, "NGO");
            statement.setString(9, ngo.getUniqueId());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                // Retrieve the auto-generated keys (User ID)
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int userId = generatedKeys.getInt(1);

                    // Insert into the ngo table using the obtained userId
                    insertIntoNgoTable(userId, ngo.getNgoName());

                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void insertIntoNgoTable(int userId, String ngoName) throws SQLException {
        String ngoSql = "INSERT INTO ngo (id, ngoname) VALUES (?, ?)";
        try (PreparedStatement ngoStatement = connection.prepareStatement(ngoSql)) {
            ngoStatement.setInt(1, userId);
            ngoStatement.setString(2, ngoName);
            ngoStatement.executeUpdate();
        }
    }
}
