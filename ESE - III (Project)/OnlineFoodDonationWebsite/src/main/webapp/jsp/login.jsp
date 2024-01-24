<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/OnlineFoodDonationWebsite/css/styles.css">
    <link rel="stylesheet" href="/OnlineFoodDonationWebsite/css/login-styles.css">
    <title>Login - Online Food Donation</title>
</head>
<body>
    <header>
        <div class="container">
            <div class="header-content">
                <h1>Welcome to Online Food Donation</h1>
                <div class="login-button">
                    <a href="/OnlineFoodDonationWebsite/jsp/login.jsp">Login</a>
                </div>
            </div>
            <nav>
                <ul>
                    <li><a href="../index.jsp">Home</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div class="login-container">
        <form action="../LoginServlet" method="post">
            <label for="email">Login Id(email)<span class="mandatory">*</span></label>
            <input type="text" id="email" name="email" required>

            <label for="password">Password<span class="mandatory">*</span></label>
            <input type="password" id="password" name="password" required>

            <button class="login-button2" type="submit">Sign In</button>
        </form>

        <div class="register-buttons">
            <button class="register-button" onclick="window.location='/OnlineFoodDonationWebsite/jsp/user-registration.jsp';">USER REGISTER</button>
            <button class="register-button" onclick="window.location='/OnlineFoodDonationWebsite/jsp/ngo-registration.jsp';">NGO REGISTER</button>
        </div>
	</div>
    <footer>
        <div class="container">
            <p>&copy; 2024 Online Food Donation</p>
        </div>
    </footer>
</body>
</html>
