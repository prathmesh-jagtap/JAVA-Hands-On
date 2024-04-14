package Students;

import javax.servlet.http.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;

@WebServlet("redirect/")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String url = req.getParameter("URL");
            RequestDispatcher result = req.getRequestDispatcher(url);
            result.forward(req, resp);
        } catch (Exception e) {
            out.println("Error" + e.getMessage());
        }
    }
}