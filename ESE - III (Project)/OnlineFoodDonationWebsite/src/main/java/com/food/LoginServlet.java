package com.food;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM user WHERE email=? AND password=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, password);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int roleId = resultSet.getInt("roleId");
                        String firstName = resultSet.getString("firstName");

                        // Set up session
                        HttpSession session = request.getSession();
                        session.setAttribute("email", email);
                        session.setAttribute("roleId", roleId);
                        session.setAttribute("firstName", firstName);

                        // Redirect based on role
                        if (roleId == 1) { // Admin
                            response.sendRedirect("/OnlineFoodDonationWebsite/jsp/admin-dashboard.jsp");
                        } else if (roleId == 2) { // User
                            response.sendRedirect("/OnlineFoodDonationWebsite/jsp/user-dashboard.jsp");
                        } else if (roleId == 3) { // NGO
                            response.sendRedirect("/OnlineFoodDonationWebsite/jsp/ngo-dashboard.jsp");
                        }
                    } else {
                        // Invalid credentials
//                        response.sendRedirect("login.jsp?error=InvalidCredentials");
                        response.getWriter().println("<script>alert('Invalid credentials'); window.location.href='/OnlineFoodDonationWebsite/jsp/login.jsp';</script>");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<script>alert('Database Error'); window.location.href='/OnlineFoodDonationWebsite/jsp/login.jsp';</script>");
        }
    }
}
