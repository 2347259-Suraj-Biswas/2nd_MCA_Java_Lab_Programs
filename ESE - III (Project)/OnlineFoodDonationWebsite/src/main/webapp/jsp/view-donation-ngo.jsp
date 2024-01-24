<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/OnlineFoodDonationWebsite/css/styles.css">
    <title>View Donation - Online Food Donation</title>
    <style>
        /* Add common login styles */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 0 auto;
        }

        header {
            background-color: #3498db;
            color: #fff;
            padding: 1em 0;
        }

        .header-content {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        nav ul li {
            display: inline;
            margin-right: 20px;
        }

        nav a {
            color: #fff;
            text-decoration: none;
        }

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
        .view-donation-content {
            text-align: center;
            margin-top: 20px;
        }

        /* Add table styling */
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #3498db;
            color: #fff;
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
                    <li><a href="/OnlineFoodDonationWebsite/jsp/ngo-dashboard.jsp">Home</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/request-food.jsp">Request Food</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/view-donation-ngo.jsp">View Donation</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/track-requested-food-ngo.jsp">Track Requested Food</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div class="view-donation-content">
        <h2>View Donation</h2>
        <hr>

        <!-- Donation table -->
        <table>
            <thead>
                <tr>
                    <th>Donor Name</th>
                    <th>Category</th>
                    <th>Food</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <!-- Add dynamic content based on your backend logic -->
                <tr>
                    <td>John Doe</td>
                    <td>Canned Goods</td>
                    <td>Canned Vegetables</td>
                    <td>50</td>
                </tr>
                <!-- Add more rows dynamically -->
            </tbody>
        </table>
    </div>

    <footer>
        <div class="container">
            <p>&copy; 2024 Your Food Donation Website</p>
        </div>
    </footer>
</body>
</html>
