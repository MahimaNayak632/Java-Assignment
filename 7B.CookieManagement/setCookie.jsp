<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Setting Cookie</title>
    <style>
        .info-box {
            margin: 20px;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .success {
            color: green;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="info-box">
        <%
            // Get parameters
            String name = request.getParameter("cookieName");
            String domain = request.getParameter("domain");
            String maxAge = request.getParameter("maxAge");

            if (name != null && domain != null && maxAge != null) {
                try {
                    // Get or create cookie list from session
                    @SuppressWarnings("unchecked")
                    List<Map<String, String>> cookieList = (List<Map<String, String>>) session.getAttribute("cookieList");
                    if (cookieList == null) {
                        cookieList = new ArrayList<>();
                    }

                    // Get current timestamp
                    long currentTimeSeconds = System.currentTimeMillis() / 1000;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String timestamp = sdf.format(new Date());

                    // Create new cookie entry
                    Map<String, String> cookieEntry = new HashMap<>();
                    cookieEntry.put("name", name);
                    cookieEntry.put("domain", domain);
                    cookieEntry.put("maxAge", maxAge);
                    cookieEntry.put("setTime", String.valueOf(currentTimeSeconds));

                    // Create and configure actual Cookie object
                    Cookie cookie = new Cookie(name, "value");
                    cookie.setMaxAge(Integer.parseInt(maxAge));

                    // Setting domain only if not localhost
                    if (!"localhost".equalsIgnoreCase(domain)) {
                        cookie.setDomain(domain);
                    }

                    response.addCookie(cookie);

                    // Add to session list
                    cookieList.add(cookieEntry);
                    session.setAttribute("cookieList", cookieList);
        %>
                    <h3 class="success">Cookie Set Successfully</h3>
                    <p><strong>Cookie Name:</strong> <%= name %></p>
                    <p><strong>Domain:</strong> <%= domain %></p>
                    <p><strong>Max Age:</strong> <%= maxAge %> seconds</p>
                    <p><strong>Set Time:</strong> <%= timestamp %></p>
        <%
                } catch (Exception e) {
        %>
                    <p class="error">Error setting cookie: <%= e.getMessage() %></p>
        <%
                }
            } else {
        %>
                <p class="error">Missing required fields. Please go back and fill all values.</p>
        <%
            }
        %>
        <p><a href="index.jsp">Return to Cookie List</a></p>
    </div>
</body>
</html>