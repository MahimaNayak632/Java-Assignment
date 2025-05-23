<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
    <h2>Update Employee Record</h2>
    <form method="post">
        <label>Employee No (ID to Update):</label>
        <input type="number" name="empno" required><br><br>

        <label>New Name:</label>
        <input type="text" name="empname" required><br><br>

        <label>New Basic Salary:</label>
        <input type="number" name="salary" required><br><br>

        <input type="submit" value="Update Employee">
    </form>

    <hr>

<%
    String url = "jdbc:mysql://localhost:3306/Employee";
    String user = "root"; // adjust as needed
    String pass = "";     // adjust as needed

    String empnoStr = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String salaryStr = request.getParameter("salary");

    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        // Create table if not exists (safety)
        st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS Emp (" +
                         "Emp_No INT PRIMARY KEY, " +
                         "Emp_Name VARCHAR(100), " +
                         "BasicSalary DOUBLE)");

        // Perform update if form submitted
        if (empnoStr != null && empname != null && salaryStr != null) {
            int empno = Integer.parseInt(empnoStr);
            double salary = Double.parseDouble(salaryStr);

            ps = con.prepareStatement("UPDATE Emp SET Emp_Name=?, BasicSalary=? WHERE Emp_No=?");
            ps.setString(1, empname);
            ps.setDouble(2, salary);
            ps.setInt(3, empno);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<p style='color:green;'>Record updated successfully!</p>");
            } else {
                out.println("<p style='color:red;'>No employee found with Emp_No: " + empno + "</p>");
            }
        }

        // Display updated table
        rs = st.executeQuery("SELECT * FROM Emp");

        out.println("<h3>All Employee Records</h3>");
        out.println("<table border='1'><tr><th>Emp_No</th><th>Emp_Name</th><th>BasicSalary</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>" + rs.getInt("Emp_No") + "</td><td>" +
                        rs.getString("Emp_Name") + "</td><td>" +
                        rs.getDouble("BasicSalary") + "</td></tr>");
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

