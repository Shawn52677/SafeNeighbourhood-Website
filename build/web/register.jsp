<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>Register</title>
    <style>
        body {
            background-image: url('https://source.unsplash.com/featured/?technology,abstract');
            background-size: cover;
            background-position: center;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 40px;
            width: 90%;
            max-width: 450px;
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.3);
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        form {
            width: 100%;
        }

        label {
            display: block;
            text-align: left;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }

        input[type="text"],
        input[type="password"],
        select {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            margin-top: 15px;
            border-radius: 5px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .back-link {
            margin-top: 15px;
            font-size: 14px;
        }

        .back-link a {
            color: #007bff;
            text-decoration: none;
        }

        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Create an Account</h1>
        <form action="RegisterServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" placeholder="Enter your username" required>

            <label for="password">Password:</label>
            <input type="password" name="password" placeholder="Enter your password" required>

            <label for="role">Select Role:</label>
            <select name="role" required>
                <option value="" disabled selected>Select your role</option>
                <option value="user">User</option>
                <option value="admin">Admin</option>
            </select>

            <input type="submit" value="Register">
        </form>

        <p class="back-link">Already have an account? <a href="login.jsp">Login here</a></p>
    </div>

</body>
</html>
