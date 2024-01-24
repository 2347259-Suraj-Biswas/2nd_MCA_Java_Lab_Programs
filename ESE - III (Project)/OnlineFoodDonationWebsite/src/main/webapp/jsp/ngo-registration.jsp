<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/OnlineFoodDonationWebsite/css/styles.css">
	<link rel="stylesheet" href="/OnlineFoodDonationWebsite/css/login-styles.css">    
    <link rel="stylesheet" href="/OnlineFoodDonationWebsite/css/ngo-registration-styles.css">
    <title>NGO Registration - Online Food Donation</title>
    <script>
        function resetForm() {
            document.getElementById("registrationForm").reset();
        }
    </script>
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

    <div class="login-container" style="margin-top:50px; width: 35%;">
        <h2>NGO Registration</h2>
        
        <form id="registrationForm" action="registerNgo" method="post">
            <div class="form-row">
                <div class="form-column">
                    <label for="ownerFirstName">Owner First Name<span class="mandatory">*</span></label>
                    <input type="text" id="ownerFirstName" name="ownerFirstName" placeholder= "Enter First Name" required>
                </div>
                <div class="form-column">
                    <label for="ownerLastName">Owner Last Name<span class="mandatory">*</span></label>
                    <input type="text" id="ownerLastName" name="ownerLastName" placeholder= "Enter Last Name" required>
                </div>
            </div>

            <label for="email">Login Id(Email)<span class="mandatory">*</span></label>
            <input type="email" id="email" name="email" placeholder= "Enter Login Id"required>

            <div class="form-row">
                <div class="form-column">
                    <label for="password">Password<span class="mandatory">*</span></label>
                    <input type="password" id="password" name="password" placeholder= "Enter Password" required>
                </div>
                <div class="form-column">
                    <label for="confirmPassword">Confirm Password<span class="mandatory">*</span></label>
                    <input type="password" id="confirmPassword" name="confirmPassword" placeholder= "Re-Enter Password" required>
                </div>
            </div>

            <label for="gender">Gender<span class="mandatory">*</span></label>
            <select id="gender" name="gender">
                <option value="male" selected>Male</option>
                <option value="female">Female</option>
                <option value="preferNotToSay">Prefer not to say</option>
            </select>

            <label for="mobileNo">Mobile No<span class="mandatory">*</span></label>
            <input type="text" id="mobileNo" name="mobileNo" placeholder= "Enter 10 Digits mobile No." required>

            <label for="uniqueId">Unique Id<span class="mandatory">*</span></label>
            <input type="text" id="uniqueId" name="uniqueId" placeholder= "Enter Unique ID" required>

            <label for="ngoName">NGO Name<span class="mandatory">*</span></label>
            <input type="text" id="ngoName" name="ngoName" placeholder= "Enter NGO Name" required>

            <div class="form-row">
                <button class="login-button2" type="submit">SIGNUP</button>
                <button type="reset">RESET</button>
            </div>
        </form>
    </div>

    <footer>
        <div class="container">
            <p>&copy; 2024 Online Food Donation</p>
        </div>
    </footer>
</body>
</html>
