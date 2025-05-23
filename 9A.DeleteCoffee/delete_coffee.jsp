<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Delete Coffee Product</title>
</head>
<body>
    <h2>Delete Coffee Product </h2>
    <form method="post">
        <label>Enter Coffee ID to Delete:</label>
        <input type="number" name="id" required>
        <input type="submit" value="Delete">
    </form>
    <hr>

<%
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root"; // change if needed
    String pass = "";     // change if needed

    String idStr = request.getParameter("id");

    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        // Delete record if form submitted
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            ps = con.prepareStatement("DELETE FROM coffee WHERE id = ?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<p style='color:green;'>Record with ID " + id + " deleted successfully!</p>");
            } else {
                out.println("<p style='color:red;'>No coffee found with ID: " + id + "</p>");
            }
        }

        // Display all remaining records
        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM coffee");

        out.println("<h3>Remaining Coffee Products</h3>");
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
        try { if (st != null) st.close(); } catch (Exception e) {}
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
%>
</body>
</html>


