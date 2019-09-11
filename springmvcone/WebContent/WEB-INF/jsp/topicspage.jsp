<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>topics : <%= request.getAttribute("topics") %></h1>
<%
	String topics[]=(String [])request.getAttribute("topics");
	for(String t:topics)
	{%>

		<h1><%= t%></h1>
<% 	}
%>
</body>
</html>