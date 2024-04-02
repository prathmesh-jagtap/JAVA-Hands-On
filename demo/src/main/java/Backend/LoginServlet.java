package Backend;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Sample servlet class for login related methods
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // JDBC connection parameters
        String url = "jdbc:mysql://localhost:3306/students";
        String dbUsername = "root";
        String dbPassword = "192000";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement stmt = con
                    .prepareStatement("SELECT * FROM logged_in_user WHERE username=? AND password=?");
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // User authenticated, redirect to success page
                request.setAttribute("message", "Welcome, " + username + "!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
                dispatcher.forward(request, response);
            } else {
                // Authentication failed, redirect to login page with error message
                response.sendRedirect("login.jsp?error=1");
            }

            // Close connections
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle database connection errors
            response.sendRedirect("error.jsp");
        }
    }

}
