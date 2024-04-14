<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Marks</title>
  </head>
  <body>
    <h2>Welcome, <%= session.getAttribute("name") %>!</h2>
    <form action="marks" method="post">
      <u><b>Enter marks for six subjects[out of 100]</b></u
      ><br /><br />
      Enter marks for Subject1<input type="text" name="subject1" /><br /><br />
      Enter marks for Subject2<input type="text" name="subject2" /><br /><br />
      Enter marks for Subject3<input type="text" name="subject3" /><br /><br />
      Enter marks for Subject4<input type="text" name="subject4" /><br /><br />
      Enter marks for Subject5<input type="text" name="subject5" /><br /><br />
      Enter marks for Subject6<input type="text" name="subject6" /><br /><br />
      <input type="submit" value="Generate Result" />
    </form>
  </body>
</html>
