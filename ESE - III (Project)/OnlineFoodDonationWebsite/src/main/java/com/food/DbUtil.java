package com.food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

    // This method retrieves users with roleid=2 and rolename='User' from the database
    public static List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT firstName, lastName, email, password, mobileno, gender, roleId, roleName, uniqueid " +
                             "FROM user WHERE roleId = 2 AND roleName = 'User'");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setMobileNo(resultSet.getString("mobileno"));
                user.setGender(resultSet.getString("gender"));
                user.setRoleId(resultSet.getInt("roleId"));
                user.setRoleName(resultSet.getString("roleName"));
                user.setUniqueId(resultSet.getString("uniqueid"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return userList;
    }
    
    // Method to get a list of users with roleid = 3 and rolename = 'NGO' along with NGO name
    public static List<User> getNgoUsers() {

        List<User> ngoUsers = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT u.firstname, u.lastname, u.email, u.password, u.mobileno, " +
                             "u.gender, u.roleid, u.rolename, u.uniqueid, n.ngoname " +
                             "FROM user u " +
                             "JOIN ngo n ON u.id = n.id " +
                             "WHERE u.roleid = 3 AND u.rolename = 'NGO'");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String mobileNo = resultSet.getString("mobileno");
                String gender = resultSet.getString("gender");
                int roleId = resultSet.getInt("roleId");
                String roleName = resultSet.getString("roleName");
                String uniqueId = resultSet.getString("uniqueid");
                String ngoName = resultSet.getString("ngoName");

                User user = new User(firstName, lastName, email, password, mobileNo, gender, roleId, roleName, uniqueId);
                user.setNgoName(ngoName); // Assuming there's a setNgoName method in your User class
                ngoUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }

        return ngoUsers;
    }
    
    
    // Add this method to fetch requested food data
    public static List<RequestFood> fetchRequestedFoodData() {
        List<RequestFood> requestedFoodList = new ArrayList<>();

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT ngoname, category, food, quantity, address, sendername, sendercontactno, status " +
                             "FROM requestfood");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String ngoName = resultSet.getString("ngoname");
                String category = resultSet.getString("category");
                String food = resultSet.getString("food");
                int quantity = resultSet.getInt("quantity");
                String address = resultSet.getString("address");
                String senderName = resultSet.getString("sendername");
                String senderContactNo = resultSet.getString("sendercontactno");
                String status = resultSet.getString("status");

                RequestFood requestFood = new RequestFood(ngoName, category, food, quantity, address,
                        senderName, senderContactNo, status);
                requestedFoodList.add(requestFood);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }

        return requestedFoodList;
    }
}
