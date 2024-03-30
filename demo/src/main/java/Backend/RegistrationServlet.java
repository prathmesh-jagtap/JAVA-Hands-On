package Backend;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegistrationServlet extends HttpServlet {

    Connection con;
    PreparedStatement stm;
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone_no");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            out.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "192000");
            // String Query = "insert into user(name,dob,email,phone_no)" + "values('" +
            // name + "','" + dob + "','" + email
            // + "','" + phone + "')";
            String Query = "INSERT INTO user values(?, ?, ?, ?)";
            stm = con.prepareStatement(Query);
            stm.setString(1, name);
            stm.setString(2, dob);
            stm.setString(3, email);
            stm.setString(4, phone);
            if (stm.executeUpdate() > 0) {
                response.sendRedirect("show");
            } else {
                out.println("<font color='#e00'>Unable to Enter Data</font>");
            }
            stm.close();
            con.close();
        } catch (SQLException e) {
            out.println("<font color='#e00'>Error:" + e.getMessage() + "</font>");
        }
    }
}
