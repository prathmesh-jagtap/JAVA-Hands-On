package Students;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/marks")
public class MarksServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int[] marks = new int[6];
        for (int i = 0; i < 6; i++) {
            marks[i] = Integer.parseInt(request.getParameter("subject" + (i + 1)));
        }

        HttpSession session = request.getSession();
        session.setAttribute("marks", marks);

        response.sendRedirect("result");
    }
}
