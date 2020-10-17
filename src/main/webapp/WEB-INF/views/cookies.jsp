<%--
  Created by IntelliJ IDEA.
  User: agaflak
  Date: 17.10.2020
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cookies</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <td>Klucz</td>
        <td>Wartość</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="myCookie" items="${cookies}">
        <tr>
            <td>${myCookie.name}</td>
            <td>${myCookie.value}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
