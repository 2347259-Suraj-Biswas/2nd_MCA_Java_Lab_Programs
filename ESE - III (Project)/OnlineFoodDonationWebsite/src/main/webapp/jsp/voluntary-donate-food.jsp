<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/OnlineFoodDonationWebsite/css/styles.css">
    <title>Voluntary Donate Food - Online Food Donation</title>
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
        .voluntary-donate-food-content {
            text-align: center;
            margin-top: 20px;
        }

        /* Add form styling */
        .donation-form {
            width: 60%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .donation-form h2 {
            border-bottom: 1px solid #ddd;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }

        .form-group {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .form-group label {
            flex: 1;
            margin-right: 10px;
            text-align: right;
        }

        .form-group input,
        .form-group select {
            flex: 2;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 100%;
        }

        .save-button {
            background-color: #3498db;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .save-button:hover {
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

    <div class="voluntary-donate-food-content">
        <h2>Donate Food</h2>
        <hr>

        <!-- Donation form -->
        <form class="donation-form" action="#" method="post">
            <div class="form-group">
                <label for="foodCategory">Food Category:</label>
                <input type="text" id="foodCategory" name="foodCategory" placeholder="Enter Category Here" required>
            </div>

            <div class="form-group">
                <label for="foodName">Food Name:</label>
                <input type="text" id="foodName" name="foodName" placeholder="Enter Food Name Here" required>
            </div>

            <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" placeholder="Enter Quantity"  required>
            </div>

            <div class="form-group">
                <label for="ngoName">NGO Name:</label>
                <select id="ngoName" name="ngoName">
                    <option value="" selected>----------Select----------</option>
                    <!-- Populate with values from the database -->
                    <option value="ngo1">NGO 1</option>
                    <option value="ngo2">NGO 2</option>
                    <!-- Add more options dynamically -->
                </select>
            </div>

            <button class="save-button" type="submit">Save</button>
        </form>
    </div>

    <footer>
        <div class="container">
            <p>&copy; 2024 Online Food Donation</p>
        </div>
    </footer>
</body>
</html>
