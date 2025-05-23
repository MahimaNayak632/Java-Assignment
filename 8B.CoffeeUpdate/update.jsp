<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update Coffee Product</title>
</head>
<body>
    <h2>Update Coffee Product</h2>
    <form method="post">
        <label>Enter ID of Coffee to Update:</label>
        <input type="number" name="id" required><br><br>

        <label>New Coffee Name:</label>
        <input type="text" name="name" required><br><br>

        <label>New Price:</label>
        <input type="number" step="0.01" name="price" required><br><br>

        <input type="submit" value="Update">
    </form>

    <hr>

<%
    // Database connection details
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root"; // Update if different
    String password = ""; // Update if password is set

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    // Read form inputs
    String idStr = request.getParameter("id");
    String name = request.getParameter("name");
    String priceStr = request.getParameter("price");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);

        // Create table if not exists
        stmt = conn.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS coffee (" +
                           "id INT PRIMARY KEY, " +
                           "coffee_name VARCHAR(100), " +
                           "price DECIMAL(10,2))");

        // Update record only if form submitted
        if (idStr != null && name != null && priceStr != null) {
            int id = Integer.parseInt(idStr);
            double price = Double.parseDouble(priceStr);

            pstmt = conn.prepareStatement(
                "UPDATE coffee SET coffee_name = ?, price = ? WHERE id = ?");
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                out.println("<p style='color:green;'>Record updated successfully!</p>");
            } else {
                out.println("<p style='color:red;'>No record found with ID " + id + ".</p>");
            }
        }

        // Display all records
        rs = stmt.executeQuery("SELECT * FROM coffee");
        out.println("<h3>All Coffee Records:</h3>");
        out.println("<table border='1'><tr><th>ID</th><th>Coffee Name</th><th>Price</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                        rs.getString("coffee_name") + "</td><td>" +
                        rs.getDouble("price") + "</td></tr>");
        }
        out.println("</table>");

    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
</body>
</html>
