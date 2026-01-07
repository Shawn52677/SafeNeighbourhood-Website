<%@ page import="java.sql.*" %>
<%@ page import="model.DBConnection"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>View Users</title>
    <style>
        .message {
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid;
            border-radius: 5px;
        }
        .message.success {
            color: green;
            background-color: #e9f9e9;
            border-color: green;
        }
        .message.error {
            color: red;
            background-color: #f9e9e9;
            border-color: red;
        }
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
            background: rgba(255, 255, 255, 0.2);
        }
        input, select {
            width: 90%;
            padding: 6px;
            margin: 4px;
            box-sizing: border-box;
        }
        .input-container {
            display: flex;
            align-items: center;
        }
        .input-container input,
        .input-container select {
            flex: 1;
        }
        button {
            padding: 6px 12px;
            margin: 4px;
            cursor: pointer;
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
            background: rgba(255, 255, 255, 0.1);
            padding: 2rem;
            border-radius: 15px;
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
            width: 90%;
            max-width: 600px;
            text-align: center;
        }

        h1 {
            margin-bottom: 1.5rem;
            font-size: 2rem;
            color: #fff;
        }

        label {
            display: block;
            margin: 0.5rem 0 0.25rem;
            font-size: 1rem;
        }

        input {
            width: 100%;
            padding: 0.8rem;
            margin-bottom: 1rem;
            border: none;
            border-radius: 10px;
            outline: none;
            font-size: 1rem;
            background: rgba(255, 255, 255, 0.2);
            color: #fff;
            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        input::placeholder {
            color: rgba(255, 255, 255, 0.7);
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

        p {
            margin-top: 1rem;
            font-size: 0.9rem;
        }

        a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
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
        // Check if user is logged in and is an admin
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Fetching the message from session if any (like success or error messages)
        String message = (String) session.getAttribute("message");
        String messageType = (String) session.getAttribute("messageType");

        if (message != null) {
    %>
    <div class="message <%= messageType %>">
        <%= message %>
    </div>
    <%
            session.removeAttribute("message");
            session.removeAttribute("messageType");
        }
    %>

    <h1>List of Users</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        <%
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = DBConnection.getConnection();
                String sql = "SELECT * FROM users";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String userRole = rs.getString("role");
        %>
        <tr id="user_<%= id %>">
            <td><%= id %></td>
            <td>
                <div class="input-container">
                    <input type="text" id="username_<%= id %>" value="<%= username %>" disabled />
                </div>
            </td>
            <td>
                <div class="input-container">
                    <input type="password" id="password_<%= id %>" value="<%= password %>" disabled />
                </div>
            </td>
            <td>
                <div class="input-container">
                    <select id="role_<%= id %>" disabled>
                        <option value="admin" <%= userRole.equals("admin") ? "selected" : "" %>>Admin</option>
                        <option value="user" <%= userRole.equals("user") ? "selected" : "" %>>User</option>
                    </select>
                </div>
            </td>
            <td>
                <button type="button" id="editBtn_<%= id %>" onclick="enableEdit(<%= id %>)">Edit</button>
                <button type="button" id="saveBtn_<%= id %>" onclick="updateUser(<%= id %>)" style="display:none;">Save</button>
                <button type="button" onclick="deleteUser(<%= id %>)">Delete</button>
            </td>
        </tr>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
        %>
        <tr>
            <td colspan="5">Error occurred while fetching data</td>
        </tr>
        <%
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>
    </table>

    <a href="admin_dashboard.jsp" class="button report-button">Back</a>

    <script>
        // Enable editing the user details
        function enableEdit(id) {
            document.getElementById("username_" + id).disabled = false;
            document.getElementById("password_" + id).disabled = false;
            document.getElementById("role_" + id).disabled = false;
            document.getElementById("editBtn_" + id).style.display = 'none';
            document.getElementById("saveBtn_" + id).style.display = 'inline';
        }

        // Update user after editing
        function updateUser(id) {
            var username = document.getElementById("username_" + id).value;
            var password = document.getElementById("password_" + id).value;
            var role = document.getElementById("role_" + id).value;

            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'UpdateUserServlet', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.onload = function() {
                if (xhr.status == 200) {
                    alert("User updated successfully");
                    location.reload(); // Reload the page after update
                } else {
                    alert("Error updating user");
                }
            };
            xhr.send('id=' + id + '&username=' + username + '&password=' + password + '&role=' + role);
        }

        // Delete user
        function deleteUser(id) {
            if (confirm('Are you sure you want to delete this user?')) {
                var xhr = new XMLHttpRequest();
                xhr.open('POST', 'DeleteUserServlet', true);
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                xhr.onload = function() {
                    if (xhr.status == 200) {
                        document.getElementById("user_" + id).remove(); // Remove the row after deletion
                    } else {
                        alert("Error deleting user");
                    }
                };
                xhr.send('id=' + id);
            }
        }
    </script>
</body>
</html>
