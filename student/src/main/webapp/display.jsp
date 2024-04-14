<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Display Result</title>
  </head>
  <body>
    <table border="1px">
      <tr>
        <center><h2><%= request.getAttribute("name") %> Result</h2></center>
      </tr>
      <tr>
        <td><b>Id</b></td>
        <td><%= request.getAttribute("id") %></td>
        <td><b>Department</b></td>
        <td><%= request.getAttribute("department") %></td>
        <td><b>Result</b></td>
        <% boolean rs = (boolean) request.getAttribute("result"); if (rs){ %>
        <td style="color: green"><b>Pass</b></td>
        <% } else { %>
        <td style="color: red"><b>Fail</b></td>
        <% } %>
      </tr>
      <tr>
        <th>Subject</th>
        <th>Marks</th>
      </tr>
      <tr>
        <td>
          <% for(int i=1; i<=6; i++){ %> Subject<% out.println(i); %>< <% } %>
        </td>
        <td>
          <% int[] marks = (int[]) request.getAttribute("marks"); for(int i:
          marks){ %> <% out.println(i); %> <% } %>
        </td>
      </tr>
      <tr>
        <td><b>Total Marks</b></td>
        <td><%= request.getAttribute("totalMarks") %></td>
      </tr>
    </table>
  </body>
</html>
