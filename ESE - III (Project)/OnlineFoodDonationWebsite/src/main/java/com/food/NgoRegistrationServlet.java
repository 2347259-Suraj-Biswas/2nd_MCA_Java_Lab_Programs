// NgoRegistrationServlet.java
package com.food;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerNgo")
public class NgoRegistrationServlet extends HttpServlet {
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
        String ownerFirstName = request.getParameter("ownerFirstName");
        String ownerLastName = request.getParameter("ownerLastName");
        String email = request.getParameter("email");  // Same field as in User
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String mobileNo = request.getParameter("mobileNo");
        String uniqueId = request.getParameter("uniqueId");
        String ngoName = request.getParameter("ngoName");

        Ngo ngo = new Ngo();
        ngo.setOwnerFirstName(ownerFirstName);
        ngo.setOwnerLastName(ownerLastName);
        ngo.setEmail(email);
        ngo.setPassword(password);
        ngo.setGender(gender);
        ngo.setMobileNo(mobileNo);
        ngo.setUniqueId(uniqueId);
        ngo.setNgoName(ngoName);

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            NgoDAO ngoDAO = new NgoDAO(connection);

            if (ngoDAO.addNgo(ngo)) {
                // Set a success message
                request.setAttribute("message", "NGO Successfully Registered");

                // Display success message using JavaScript
                response.setContentType("text/html");
                response.getWriter().println("<script>alert('NGO Successfully Registered'); window.location.href='/OnlineFoodDonationWebsite/jsp/login.jsp';</script>");

                // You can redirect to another page if needed
                // response.sendRedirect("success.jsp");
            } else {
                response.getWriter().println("<script>alert('NGO Registration Failed!'); window.location.href='/OnlineFoodDonationWebsite/jsp/ngo-registration.jsp';</script>");
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
