<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@page import ="java.sql.SQLException,java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.sql.DriverManager"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%--  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hive select operation</title>
</head>
<body>     
 <h3>Create Pie Chart Dynamically using JFreechart</h3>
        <%
                response.setIntHeader("Refresh", 10);
        %>
        <form id="formId">
           <input type="button" onclick="refreshPage()" value="Refresh Page" />
           <br /> <img src="PieChartServlet" />
        </form>
</body>
</html>

