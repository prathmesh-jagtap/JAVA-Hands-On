<%@ page import="java.sql.*" %>
<%
  String username = request.getParameter("username");
  String password = request.getParameter("password");

  try {
    Connection connection = (Connection)application.getAttribute("connection");
    PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
    statement.setString(1, username);
    statement.setString(2, password);

    if (statement.executeUpdate() > 0) {
      out.println("Registration successful");
    } else {
      out.println("Failed to register user");
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
%>
