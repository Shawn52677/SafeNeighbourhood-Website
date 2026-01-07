<%@ page import="model.DBConnection"%>
<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>View Incidents</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }

        /* Styling for the action buttons */
        .action-buttons {
            display: flex;
            gap: 10px; /* Space between buttons */
            justify-content: center; /* Center the buttons */
        }

        .action-buttons button {
            padding: 8px 16px;
            font-size: 14px;
            cursor: pointer;
            border: none;
            border-radius: 4px;
        }

        .update-btn {
            background-color: #4CAF50;
            color: white;
        }

        .delete-btn {
            background-color: #f44336;
            color: white;
        }

        .update-btn:hover {
            background-color: #45a049;
        }

        .delete-btn:hover {
            background-color: #e53935;
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
            color: #fff;
            flex-direction: column;
            width: 100%;
        }

        .container {
            width: 90%;
            max-width: 900px;
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

        table {
            width: 100%;
            margin-top: 1.5rem;
            border-collapse: collapse;
            color: #fff;
        }

        table th, table td {
            padding: 10px;
            text-align: left;
            border: 1px solid rgba(255, 255, 255, 0.2);
        }

        table th {
            background: rgba(255, 255, 255, 0.2);
            color: #fff;
            text-transform: uppercase;
        }

        table tbody tr:hover {
            background: rgba(255, 255, 255, 0.2);
            cursor: pointer;
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
    .report-button {
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

    </style>
</head>
<body>
    <%
        // Check if user is logged in
        String role = (String) session.getAttribute("role"); // Role: "admin" or "user"
        if (role == null) {
            // Redirect to login if no session exists
            response.sendRedirect("login.jsp");
            return;
        }
    %>

    <h1>List of Incidents</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Location</th>
            <th>Reported By</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <%
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = DBConnection.getConnection();
                String sql = "SELECT * FROM incident";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String location = rs.getString("location");
                    String reportedBy = rs.getString("reported_by");
                    String status = rs.getString("status");
        %>
        <tr>
            <td><%= id %></td>
            <td><%= title %></td>
            <td><%= description %></td>
            <td><%= location %></td>
            <td><%= reportedBy %></td>
            <td><%= status %></td>

            <%
                if ("admin".equals(role)) {
            %>
            <td>
                <div class="action-buttons">
                    <!-- Form to update status -->
                    <form action="UpdateIncidentStatusServlet" method="POST">
                        <input type="hidden" name="id" value="<%= id %>" />
                        <select name="status">
                            <option value="reported" <%= status.equals("reported") ? "selected" : "" %>>Reported</option>
                            <option value="in progress" <%= status.equals("in progress") ? "selected" : "" %>>In Progress</option>
                            <option value="resolved" <%= status.equals("resolved") ? "selected" : "" %>>Resolved</option>
                        </select>
                        <button class="update-btn" type="submit">Update Status</button>
                    </form>

                    <!-- Form for Deleting an incident -->
                    <form action="DeleteIncidentServlet" method="POST" onsubmit="return confirm('Are you sure you want to delete this incident?');">
                        <input type="hidden" name="id" value="<%= id %>" />
                        <button class="delete-btn" type="submit">Delete</button>
                    </form>
                </div>
            </td>
            <%
                }
            %>
        </tr>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
        %>
        <tr>
            <td colspan="7">An error occurred while fetching data.</td>
        </tr>
        <%
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>
    </table>

    <%
        // Role-specific navigation
        if ("admin".equals(role)) {
    %>
        <a href="admin_dashboard.jsp" class="button report-button">Back</a>
    <%
        } else if ("user".equals(role)) {
    %>
        <a href="user_dashboard.jsp" class="button report-button">Back</a>
    <%
        }
    %>
</body>
</html>
