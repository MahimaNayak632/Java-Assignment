<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Coffee Records</title>
</head>
<body>
<%
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root"; // change if needed
    String password = ""; // change if needed

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    // Get form data
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

        // Insert only if form submitted
        if (idStr != null && name != null && priceStr != null) {
            int id = Integer.parseInt(idStr);
            double price = Double.parseDouble(priceStr);

            pstmt = conn.prepareStatement("INSERT INTO coffee VALUES (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
            out.println("<p style='color:green;'>Record inserted successfully!</p>");
        }

        // Show all records
        out.println("<h2>All Coffee Records:</h2>");
        rs = stmt.executeQuery("SELECT * FROM coffee");

        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Price</th></tr>");
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

