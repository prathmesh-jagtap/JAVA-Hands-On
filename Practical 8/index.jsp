<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<html>
<body>
  <form action="BankAccountServlet" method="post">
    <input type="text" name="accountNumber" placeholder="Account Number" required>
    <input type="text" name="accountHolderName" placeholder="Account Holder Name" required>
    <input type="text" name="amount" placeholder="Amount" required>
    <select name="action">
      <option value="deposit">Deposit</option>
      <option value="withdraw">Withdraw</option>
    </select>
    <button type="submit">Submit</button>
  </form>

  <% BankAccount account = (BankAccount)request.getAttribute("account"); %>

  <h2>Account Information</h2>
  <p>Account Holder Name: <%= account.getAccountHolderName() %></p>
  <p>Balance: <%= account.getBalance() %></p>
</body>
</html>
