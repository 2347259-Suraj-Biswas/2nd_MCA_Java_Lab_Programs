// ViewRequestedFoodServlet.java
package com.food;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewRequestedFood")
public class ViewRequestedFoodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch data from the database
        List<RequestFood> requestedFoodList = fetchRequestedFoodDataFromDatabase();

        // Set the data in request attribute
        request.setAttribute("requestedFoodList", requestedFoodList);

        // Forward to the JSP page
        request.getRequestDispatcher("/WEB-INF/view-requested-food.jsp").forward(request, response);
    }

    // Database code to fetch data
    private List<RequestFood> fetchRequestedFoodDataFromDatabase() {
        // Implement your database logic here to fetch data from the "requestfood" table
        // Use JDBC or an ORM framework like Hibernate

        // For example (using a hypothetical DbUtil class):
        List<RequestFood> requestedFoodList = DbUtil.fetchRequestedFoodData();
        
        return requestedFoodList;
    }
}
