package com.food;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/jsp/admin-dashboard.jsp", 
        "/jsp/user-list.jsp",
        "/jsp/ngo-list.jsp",
        "/jsp/view-donation.jsp",
        "/jsp/track-requested-food.jsp"})

public class AdminAccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        // Check if there is no active session or roleId attribute is not present
        if (session == null || session.getAttribute("roleId") == null) {
            // Redirect to the login page if there is no session or roleId attribute
            httpResponse.sendRedirect("/OnlineFoodDonationWebsite/jsp/login.jsp");
            System.out.println("Validated Filter");
        } else {
            // Check the roleId and take appropriate actions
            int roleId = (int) session.getAttribute("roleId");
            if (roleId == 1) { // Admin roleId
                // If the roleId is 1 (admin), allow access to admin pages

                // Add cache-control headers to prevent caching
                httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //
                httpResponse.setHeader("Pragma", "no-cache"); //
                httpResponse.setDateHeader("Expires", 0); //

                System.out.println("Validated Filter");

                chain.doFilter(request, response);
            } else {
                // If the roleId is not 1, redirect to the login page
                httpResponse.sendRedirect("/OnlineFoodDonationWebsite/jsp/login.jsp");
                System.out.println("Unauthorized Access - Redirect to Login");
            }
        }
    }




    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}
