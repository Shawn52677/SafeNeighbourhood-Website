<%@page import="model.Incident"%>
<%@page import="model.DBConnection"%>
<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>Admin Dashboard</title>
    <style>
        .notification {
            padding: 10px;
            background-color: #f1f8ff;
            border: 1px solid #c1d8e5;
            color: #007acc;
            margin-bottom: 15px;
            font-family: Arial, sans-serif;
            border-radius: 5px;
            font-size: 14px;
            width: 80%;
            margin-left: auto;
            margin-right: auto;
            display: block;
        }
        .notification h2 {
            font-size: 16px;
            margin: 0;
        }
        .notification p {
            margin: 5px 0;
        }
        .notification button {
            background-color: #007acc;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            font-size: 14px;
            border-radius: 5px;
        }
        .notification button:hover {
            background-color: #005fa3;
        }
        .error {
            color: red;
        }
     body, html {
        margin: 0;
        padding: 0;
        height: 100%;
        font-family: 'Arial', sans-serif;
        background: linear-gradient(135deg, #6a11cb, #2575fc);
        display: flex;
        justify-content: center;
        align-items: center;
        color: #ffffff;
        flex-direction: column;
        width: 100%;
    }

    /* Main Container Styling */
    .container {
        width: 90%;
        max-width: 800px;
        background: rgba(255, 255, 255, 0.1);
        padding: 2rem;
        border-radius: 15px;
        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
        text-align: center;
    }

    h1 {
        font-size: 2.5rem;
        margin-bottom: 1.5rem;
        color: #ffffff;
    }

    /* Buttons Styling */
    .button {
        text-decoration: none;
        color: white;
        font-weight: bold;
        padding: 15px 30px;
        border: none;
        border-radius: 25px;
        display: inline-block;
        font-size: 16px;
        margin: 10px;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
        cursor: pointer;
        position: relative;
        overflow: hidden;
        width: 50px; /* Ensures a consistent button size */
    }

    /* Gradient Buttons */
    .report-button {
        background: linear-gradient(135deg, #ff7eb3, #ff758c);
        box-shadow: 0 5px 15px rgba(255, 117, 140, 0.4);
    }

    .view-button {
        background: linear-gradient(135deg, #42e695, #3bb2b8);
        box-shadow: 0 5px 15px rgba(59, 178, 184, 0.4);
    }

    .logout-button {
        background: linear-gradient(135deg, #ff4b1f, #ff9068);
        box-shadow: 0 5px 15px rgba(255, 144, 104, 0.4);
    }

    /* Hover Effects */
    .button:hover {
        transform: translateY(-3px);
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
    }

    /* Ripple Effect */
    .button:active::after {
        content: '';
        position: absolute;
        top: 50%;
        left: 50%;
        width: 200%;
        height: 200%;
        background: rgba(255, 255, 255, 0.3);
        border-radius: 50%;
        transform: translate(-50%, -50%) scale(0);
        animation: ripple 0.6s ease-out;
    }

    @keyframes ripple {
        to {
            transform: translate(-50%, -50%) scale(1);
            opacity: 0;
        }
    }

    nav ul {
        list-style: none;
        padding: 0;
        margin: 1.5rem 0;
        display: flex;
        justify-content: center;
        flex-wrap: wrap; /* Allow buttons to wrap on smaller screens */
        gap: 1rem; /* Adds spacing between items */
    }

    nav ul li {
        margin: 0.5rem; /* Adds vertical spacing for a cleaner layout */
    }

    /* Statistics Section */
    .stats {
        margin-top: 2rem;
        text-align: left;
        font-size: 1.2rem;
    }

    .stats span {
        font-weight: bold;
    }
</style>
    <script>
        function markAsRead() {
            // Hide the notification
            var notification = document.getElementById("notification");
            notification.style.display = "none";

            // Set session attribute using AJAX to indicate that the notification has been marked as read
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "markAsReadServlet", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("action=markAsRead");
        }
    </script>
</head>
<body>
    <h1>Welcome, Admin: <%= session.getAttribute("username") %></h1>

    <%
        // Check if user is logged in
        String role = (String) session.getAttribute("role"); // Role: "admin" or "user"
        if (role == null) {
            // Redirect to login if no session exists
            response.sendRedirect("login.jsp");
            return;
        }

        // Check if the user has already marked the notification as read
        Boolean isNotificationRead = (Boolean) session.getAttribute("isNotificationRead");
        if (isNotificationRead != null && isNotificationRead) {
            // If notification is marked as read, do not display it
            response.sendRedirect("admin_dashboard.jsp");
            return;
        }
    %>

    <h1>Latest Incident</h1>
    
    <%
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            // Correct SQL query for Apache Derby
            String sql = "SELECT * FROM incident WHERE mark = FALSE ORDER BY id DESC FETCH FIRST 1 ROWS ONLY";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String location = rs.getString("location");
                String reportedBy = rs.getString("reported_by");
                String status = rs.getString("status");
        %>
        <div id="notification" class="notification">
    <p><strong>ID:</strong> <%= rs.getInt("id") %></p>
    <p><strong>Title:</strong> <%= rs.getString("title") %></p>
    <p><strong>Description:</strong> <%= rs.getString("description") %></p>
    <p><strong>Location:</strong> <%= rs.getString("location") %></p>
    <p><strong>Reported By:</strong> <%= rs.getString("reported_by") %></p>
    <form action="MarkAsReadServlet" method="post">
        <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
        <button type="submit">Mark as Read</button>
    </form>
</div>
        <%
            } else {
        %>
        <div class="notification error">
            No incident reported yet.
        </div>
        <%
            }
        } catch (SQLException e) {
            out.println("<div class='notification error'>An error occurred while fetching data: " + e.getMessage() + "</div>");
            e.printStackTrace();
        } catch (Exception e) {
            out.println("<div class='notification error'>Unexpected error: " + e.getMessage() + "</div>");
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    %>

  
        <!-- Buttons -->
<div class="container">
    <h1>Admin Actions</h1>
    <nav>
        <ul>
            <li><a href="view_incident.jsp" class="button report-button">View Incident</a></li>
            <li><a  href="view_user.jsp" class="button view-button">View Users</a></li>
            <li><a href="LogoutServlet" class="button logout-button">Logout</a></li>
        </ul>
    </nav>
</div>
</body>
</html>
