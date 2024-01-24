// UserRegistrationServlet.java
package com.food;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/foodonation";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    static {
        // Load the JDBC driver
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobileNo = request.getParameter("mobileNo");
        String gender = request.getParameter("gender");
        String uniqueId = request.getParameter("uniqueId");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setMobileNo(mobileNo);
        user.setGender(gender);
        user.setRoleId(2); // Assuming role 2 is for normal users
        user.setRoleName("User");
        user.setUniqueId(uniqueId);

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            UserDAO userDAO = new UserDAO(connection);

            if (userDAO.addUser(user)) {
                // Set a success message
                request.setAttribute("message", "User Successfully Registered");

                // Display success message using JavaScript
                response.setContentType("text/html");
                response.getWriter().println("<script>alert('User Successfully Registered'); window.location.href='/OnlineFoodDonationWebsite/jsp/login.jsp';</script>");

                // You can redirect to another page if needed
                // response.sendRedirect("success.jsp");
            } else {
                response.getWriter().println("<script>alert('User Registration Failed!'); window.location.href='/OnlineFoodDonationWebsite/jsp/user-registration.jsp';</script>");
                // response.sendRedirect("registration-failure.jsp");
            }

        } catch (SQLException e) {
            // Write the stack trace to the response output stream
            response.setContentType("text/plain");
            response.getWriter().println("Database Error: " + e.getMessage());
            e.printStackTrace(response.getWriter());
        }
    }
}
