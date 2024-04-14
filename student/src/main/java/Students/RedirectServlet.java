package Students;

import javax.servlet.http.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String url = req.getParameter("URL");
            if (url != null && !url.isEmpty()) {
                resp.sendRedirect(url);
            } else {
                out.println("Invalid URL!");
            }
        } catch (Exception e) {
            out.println("Error" + e.getMessage());
        }
    }
}