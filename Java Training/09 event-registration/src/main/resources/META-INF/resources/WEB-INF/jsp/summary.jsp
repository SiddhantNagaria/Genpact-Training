<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Summary</title>
    <style>
        body { font-family: Arial; background: #f4f6f8; padding: 20px; }
        table { width: 100%; border-collapse: collapse; background: #fff; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background: #007bff; color: #fff; }
    </style>
</head>
<body>
<h2>Last 5 Registered Users</h2>
<table>
    <tr>
        <th>Name</th><th>Email</th><th>Session</th><th>City</th><th>Technologies</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.name}</td>
            <td>${u.email}</td>
            <td>${u.session}</td>
            <td>${u.city}</td>
            <td>
                <c:forEach var="tech" items="${u.technologies}">
                    ${tech} 
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
<p> <a href="/register">Register Another User</a></p>
</body>
</html>