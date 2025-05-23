<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Employee Salary Report</title>
</head>
<body>
<%
    String empnoStr = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String basicsalaryStr = request.getParameter("basicsalary");

    String url = "jdbc:mysql://localhost:3306/Employee";
    String user = "root";   // Change if needed
    String pass = "";       // Change if needed

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    double grandTotal = 0;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pass);

        // Insert data if form is submitted
        if (empnoStr != null && empname != null && basicsalaryStr != null) {
            int empno = Integer.parseInt(empnoStr);
            double basicsalary = Double.parseDouble(basicsalaryStr);

            String insertSQL = "INSERT INTO Emp VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, empno);
            pstmt.setString(2, empname);
            pstmt.setDouble(3, basicsalary);
            pstmt.executeUpdate();

            out.println("<p style='color:green;'>Employee inserted successfully!</p>");
        }

        // Display report
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM Emp");

        out.println("<h2>Salary Report</h2>");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");

        while (rs.next()) {
            out.println("Emp_No     : " + rs.getInt("Emp_NO") + "<br>");
            out.println("Emp_Name   : " + rs.getString("Emp_Name") + "<br>");
            out.println("Basic      : " + rs.getDouble("Basicsalary") + "<br>");
            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
            grandTotal += rs.getDouble("Basicsalary");
        }

        out.println("<strong>Grand Salary : " + grandTotal + "</strong><br>");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>

<br><br>
<a href="index.html">Add Another Employee</a>
</body>
</html>


