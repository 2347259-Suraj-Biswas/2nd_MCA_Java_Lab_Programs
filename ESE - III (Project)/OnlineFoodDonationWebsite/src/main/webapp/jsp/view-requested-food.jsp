<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.food.RequestFood" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/OnlineFoodDonationWebsite/css/styles.css">
    <title>View Requested Food - Online Food Donation</title>
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
        .view-requested-food-content {
            text-align: center;
        }

        /* Add card-style display */
        .food-cards-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        .food-card {
            width: 300px; /* Adjust the width as needed */
            margin: 10px;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .food-card h3 {
            margin-bottom: 10px;
        }

        .food-card p {
            margin: 5px 0;
        }

        .donate-button {
            background-color: #3498db;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .donate-button:hover {
            background-color: #2980b9;
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
                    <li><a href="/OnlineFoodDonationWebsite/jsp/user-dashboard.jsp">Home</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/view-requested-food.jsp">View Requested Food</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/voluntary-donate-food.jsp">Voluntary Donate Food</a></li>
                    <li><a href="/OnlineFoodDonationWebsite/jsp/donation-history.jsp">Donation History</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div class="view-requested-food-content">
        <h2>Requested Food</h2>

        <!-- Example cards for requested food (to be generated dynamically) -->
        <div class="food-cards-container">
		<div class="food-cards-container">
   		 <% List<RequestFood> requestedFoodList = (List<RequestFood>) request.getAttribute("requestedFoodList");
   		 if (requestedFoodList != null) {
       	  for (RequestFood food : requestedFoodList) { %>
            <div class="food-card">
                <h3>NGO Name: <%= food.getNgoName() %></h3>
                <p>Quantity: <%= food.getQuantity() %></p>
                <p>Food Name: <%= food.getFood() %></p>
                <p>Category: <%= food.getCategory() %></p>
                <p>Address: <%= food.getAddress() %></p>
                <button class="donate-button">Click Here to Donate</button>
            </div>
    <% }
    } %>
</div>
    </div>

    <footer>
        <div class="container">
            <p>&copy; 2024 Online Food Donation</p>
        </div>
    </footer>
</body>
</html>
