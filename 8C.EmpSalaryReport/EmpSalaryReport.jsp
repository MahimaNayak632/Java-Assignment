<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employee Salary Report</title>
</head>
<body>
    <h2>Enter Employee Record</h2>
    <form method="post">
        <label>Employee No:</label>
        <input type="number" name="empno" required><br><br>

        <label>Employee Name:</label>
        <input type="text" name="empname" required><br><br>

        <label>Basic Salary:</label>
        <input type="number" name="salary" required><br><br>

        <input type="submit" value="Add Employee">
    </form>

    <hr>

<%
    String url = "jdbc:mysql://localhost:3306/Employee";
    String user = "root"; // change if needed
    String pass = "";     // change if needed

    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;

    String empnoStr = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String salaryStr = request.getParameter("salary");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        // Create table if not exists
        st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS Emp (" +
                         "Emp_No INT PRIMARY KEY, " +
                         "Emp_Name VARCHAR(100), " +
                         "BasicSalary DOUBLE)");

        // Insert record if form submitted
        if (empnoStr != null && empname != null && salaryStr != null) {
            int empno = Integer.parseInt(empnoStr);
            double salary = Double.parseDouble(salaryStr);

            ps = con.prepareStatement("INSERT INTO Emp VALUES (?, ?, ?)");
            ps.setInt(1, empno);
            ps.setString(2, empname);
            ps.setDouble(3, salary);
            ps.executeUpdate();

            out.println("<p style='color:green;'>Employee added successfully!</p><hr>");
        }

        // Display salary report
        rs = st.executeQuery("SELECT * FROM Emp");

        double totalSalary = 0;
        out.println("<h2>Salary Report</h2>");
        while (rs.next()) {
            int no = rs.getInt("Emp_No");
            String name = rs.getString("Emp_Name");
            double sal = rs.getDouble("BasicSalary");

            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
            out.println("Emp_No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: " + no + "<br>");
            out.println("Emp_Name&nbsp;&nbsp;: " + name + "<br>");
            out.println("Basic&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: " + sal + "<br>");
            totalSalary += sal;
        }
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
        out.println("<b>Grand Salary&nbsp;&nbsp;&nbsp;: " + totalSalary + "</b><br>");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");

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

