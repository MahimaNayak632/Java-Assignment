 <%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Coffee Starting with 'D'</title>
</head>
<body>
    <h2>Coffee Products Starting with 'D'</h2>

<%
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";  // update if needed
    String pass = "";      // update if needed

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        String sql = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Coffee Name</th><th>Price</th></tr>");

        boolean found = false;
        while (rs.next()) {
            found = true;
            out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                        rs.getString("coffee_name") + "</td><td>" +
                        rs.getDouble("price") + "</td></tr>");
        }

        if (!found) {
            out.println("<tr><td colspan='3'>No coffee names starting with 'D' found.</td></tr>");
        }

        out.println("</table>");

    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
%>

</body>
</html>
 
