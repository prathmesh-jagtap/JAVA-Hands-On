package Students;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String id = (String) session.getAttribute("id");
        String department = (String) session.getAttribute("department");
        int[] marks = (int[]) session.getAttribute("marks");

        // Calculate total marks and pass/fail
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        Boolean result = (totalMarks >= 240); // Assuming pass mark is 40% of 600

        request.setAttribute("name", name);
        request.setAttribute("id", id);
        request.setAttribute("department", department);
        request.setAttribute("totalMarks", totalMarks);
        request.setAttribute("result", result);
        request.setAttribute("marks", marks);

        RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
        dispatcher.forward(request, response);
    }
}
