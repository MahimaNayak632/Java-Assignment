<%@ page import="java.sql.*" %>
<html>
<head><title>Salary Report</title></head>
<body>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

        stmt = conn.createStatement();

        // Delete employees whose names start with 'S'
        stmt.executeUpdate("DELETE FROM Emp WHERE Emp_Name LIKE 'S%'");

        // Fetch and display remaining records
        rs = stmt.executeQuery("SELECT * FROM Emp");

        double total = 0;
        out.println("<h2>Salary Report</h2>");
        while (rs.next()) {
            int empNo = rs.getInt("Emp_No");
            String empName = rs.getString("Emp_Name");
            double salary = rs.getDouble("Basicsalary");
            total += salary;

            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
            out.println("Emp_No     : " + empNo + "<br>");
            out.println("Emp_Name: " + empName + "<br>");
            out.println("Basic      : " + salary + "<br>");
        }
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
        out.println("<strong>Grand Salary   : " + total + "</strong><br>");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
</body>
</html>

