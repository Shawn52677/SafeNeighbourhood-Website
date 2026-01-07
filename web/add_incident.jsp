<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>Add Incident</title>
</head>
<body>
    <h1>Report an Incident</h1>
    <form action="AddIncidentServlet" method="post">
        <label for="title">Title:</label>
        <input type="text" name="title" required><br>
        <label for="description">Description:</label>
        <textarea name="description" required></textarea><br>
        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required>
        <label for="reportedBy">Reported By:</label>
        <input type="text" id="reportedBy" name="reportedBy" required><br>
        <input type="submit" value="Submit">
    </form>
    <style>
    body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            display: flex;
            justify-content: center;
            align-items: center;
            color: #fff;
            flex-direction: column;
            width: 100%;
        }

        .container {
            width: 90%;
            max-width: 600px;
            background: rgba(255, 255, 255, 0.1);
            padding: 2rem;
            border-radius: 15px;
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        h1 {
            font-size: 2.5rem;
            margin-bottom: 1.5rem;
            color: #fff;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 1rem;
        }

        label {
            text-align: left;
            font-size: 1rem;
        }

        input, select, textarea, button {
            width: 100%;
            padding: 0.8rem;
            border: none;
            border-radius: 10px;
            font-size: 1rem;
            background: rgba(255, 255, 255, 0.2);
            color: #fff;
            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        button {
            background: #6a11cb;
            color: #fff;
            border: none;
            padding: 0.8rem 2rem;
            font-size: 1rem;
            border-radius: 10px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        button:hover {
            background: #2575fc;
        }
        </style>
</body>
</html>
