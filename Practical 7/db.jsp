<%@ page import="java.sql.*" %>
<%
  String url = "jdbc:mysql://localhost:3306/your-database-name";
  String username = "your-username";
  String password = "your-password";

  try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(url, username, password);
    application.setAttribute("connection", connection);
  } catch (Exception e) {
    e.printStackTrace();
  }
%>
