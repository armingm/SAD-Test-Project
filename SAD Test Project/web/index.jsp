<%@ page import="com.sadproject.model.DatabaseConnection" %>
<%@ page import="com.sadproject.model.exceptions.DatabaseConnectionException" %>
<%@ page import="java.sql.SQLException" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    Hello <br>
    This is a database connection test. <br>
    <%
        DatabaseConnection db = new DatabaseConnection();
        try {
            db.openConnection("localhost", "root", "", "SADProject_DB");
            out.println("Database properly connected.");
        } catch (SQLException e){
            out.println(e.getMessage());
        }
    %>
  </body>
</html>