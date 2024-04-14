<%@ page import="java.sql.*" %>
<%
  String username = request.getParameter("username");
  String password = request.getParameter("password");

  try {
    Connection connection = (Connection)application.getAttribute("connection");
    PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
    statement.setString(1, username);
    statement.setString(2, password);
    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      response.sendRedirect("db.jsp");
    } else {
      out.println("Invalid username or password.");
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
%>
