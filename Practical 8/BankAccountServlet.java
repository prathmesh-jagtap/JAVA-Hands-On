import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class BankAccountServlet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String accountNumber = request.getParameter("accountNumber");
    String accountHolderName = request.getParameter("accountHolderName");
    BankAccount account = new BankAccount(accountNumber, accountHolderName);

    if (request.getParameter("action").equals("deposit")) {
      double amount = Double.parseDouble(request.getParameter("amount"));
      account.deposit(amount);
    } else if (request.getParameter("action").equals("withdraw")) {
      double amount = Double.parseDouble(request.getParameter("amount"));
      account.withdraw(amount);
    }

    request.setAttribute("account", account);
    request.getRequestDispatcher("/display.jsp").forward(request, response);
  }
}
