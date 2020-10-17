<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%--
  Created by IntelliJ IDEA.
  User: agaflak
  Date: 17.10.2020
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Dodawanie produktu</title>
</head>
<body>
<div>Add new product to cart:</div>
<form:form method="post"  action="/form">

    <label for="product">Product Name</label>
    <select id="product" name="productList">
        <c:forEach items="${product}" var="product">
            <option value="${product.name}">${product.name}</option>
        </c:forEach>

    </select>

    <input type="submit" value="Add To Cart">

</form:form>
</body>
</html>
