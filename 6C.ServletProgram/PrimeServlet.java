package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));
            boolean isPrime = true;

            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            out.println("<html><head><title>Prime Checker</title></head><body>");
            out.println("<h2>Number Entered: " + number + "</h2>");
            if (isPrime) {
                out.println("<p style='color:green;'>" + number + " is a Prime Number.</p>");
            } else {
                out.println("<p style='color:red;'>" + number + " is NOT a Prime Number.</p>");
            }
            out.println("<a href='index.html'>Check another number</a>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<p style='color:red;'>Invalid input. Please enter a valid number.</p>");
            out.println("<a href='index.html'>Try again</a>");
            out.println("</body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}

