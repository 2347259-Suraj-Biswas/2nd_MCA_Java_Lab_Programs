<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <title>Online Food Donation</title>
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
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </nav>
        </div>
    </header>
    
    <section class="hero">
        <div class="container">
            <div class="hero-content">
                <h2>Make a Difference with Food Donations</h2>
                <p>Join us in our mission to help those in need by contributing food donations.</p>
                <a href="/OnlineFoodDonationWebsite/jsp/user-registration.jsp" class="cta-button">Donate Now</a>
            </div>
        </div>
    </section>

    <section class="main-content">
        <div class="container">
            <h2>Latest Donations</h2>
            <div class="donation-card">
                <h3>Donor Name</h3>
                <p>Donated: Canned Goods, Non-perishables</p>
            </div>
            <div class="donation-card">
                <h3>Another Donor</h3>
                <p>Donated: Fresh Produce, Dairy Products</p>
            </div>
        </div>
    </section>

    <footer>
        <div class="container">
            <p>&copy; 2024 | Online Food Donation</p>
        </div>
    </footer>
</body>
</html>
