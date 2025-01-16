<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style ="color:red "> Login Success</h1>
<%
         ResultSet resultSet =(ResultSet)request.getAttribute("Data");
    while(resultSet.next())
    {
%>
<h1><%=resultSet.getInt(1) %></h1>
<h1><%=resultSet.getString(2) %></h1>
<h1><%=resultSet.getString(3) %></h1>
<h1><%=resultSet.getString(4) %></h1>
<h1><%=resultSet.getDouble(5) %></h1>

<%
}
%>
</body>
</html>