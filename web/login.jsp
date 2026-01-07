<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>Login</title>
    <style>
        body {
            background-image: url('https://source.unsplash.com/featured/?city,night');
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
            background-color: rgba(255, 255, 255, 0.9);
            padding: 40px;
            width: 90%;
            max-width: 400px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
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
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        .register-link {
            margin-top: 10px;
            font-size: 14px;
        }

        .register-link a {
            color: #007bff;
            text-decoration: none;
        }

        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Login</h1>
        <form action="LoginServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" required><br>
            
            <label for="password">Password:</label>
            <input type="password" name="password" required><br>
            
            <input type="submit" value="Login">
        </form>
        <p class="register-link">Don't have an account? <a href="register.jsp">Register here</a>.</p>
    </div>

</body>
</html>
