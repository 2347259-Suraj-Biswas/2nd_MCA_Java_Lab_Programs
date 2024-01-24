<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/OnlineFoodDonationWebsite/css/styles.css">
    <title>Admin Dashboard - Online Food Donation</title>
    <style>
        .login-buttons {
            display: flex;
            align-items: center;
        }

        .login-buttons a {
            margin-right: 20px;
            text-decoration: none;
            color: #fff;
        }

        .login-buttons form button {
            background-color: #3498db;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .login-buttons form button:hover {
            background-color: #2980b9;
        }
                /* Add custom styles for centering content */
        .admin-dashboard-content {
            text-align: center;
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <div class="header-content">
                <h1>Welcome <%= session.getAttribute("firstName") %>!</h1>
                <div class="login-buttons">
                    <a href="/OnlineFoodDonationWebsite/jsp/change-password.jsp">Change Password</a>
                	<div class="login-button">
                   		 <a href="../logout">Logout</a>
                	</div>
                </div>
            </div>
            <nav>
                <ul>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/admin-dashboard.jsp">Home</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/user-list.jsp">User List</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/ngo-list.jsp">NGO List</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/view-donation.jsp">View Donation</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/track-requested-food.jsp">Track Requested Food</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div class="admin-dashboard-content">
        <!-- Content for the admin dashboard goes here -->
        <h2>Welcome to the Admin Dashboard</h2>
        <!-- Additional content for the admin dashboard -->
    </div>

    <footer>
        <div class="container">
            <p>&copy; 2024 Online Food Donation</p>
        </div>
    </footer>
</body>
</html>
