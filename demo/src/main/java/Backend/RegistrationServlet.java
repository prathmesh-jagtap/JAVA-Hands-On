package Backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String phone = req.getParameter("telephone");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "192000");
            PreparedStatement stmt = conn
                    .prepareStatement("INSERT INTO user(name, dob, email, phone_no) VALUES(?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, dob);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            int rs = stmt.executeUpdate();
            if (rs > 0) {
                out.print("<p>Record saved successfully!</p>");
                req.getRequestDispatcher("form.html").include(req, resp);
            } else {
                out.println("Unable to enter data!");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
