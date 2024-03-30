package Backend;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ShowServlet extends HttpServlet {

    Connection con;
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

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            out.println(e.getMessage());
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "192000");

            Statement stm;
            stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery("select * from user");
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

            out.println("<a href='/demo'>Add New User</a>");
            out.println("<table align='center' border=2>");
            out.println("<tr>");

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                out.println("<th>" + rsmd.getColumnName(i).toUpperCase() + "</th>");
            }
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}
