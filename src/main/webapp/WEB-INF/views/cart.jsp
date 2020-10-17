<%--
  Created by IntelliJ IDEA.
  User: agaflak
  Date: 14.10.2020
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>My Cart</title>
</head>
<body>
My Cart:
<table>
    <tr>
        <th>Product Name</th>
        <th></th>
        <th>Quantity</th>
        <th></th>
        <th>Price</th>
    </tr>

    <c:forEach items="${cartItems}" var="item">
        <tr>
            <td style="columns: max-content">${item.product.name}</td>
            <td>
                <a href="/decrease/${item.product.name}"/>
                    <button style="size: 15px">-</button>
                </a>
            </td>
            <td style="text-align: center">${item.quantity}</td>
            <td>
                <a href="/increase/${item.product.name}"/>
                <button style="size: 15px">+</button>
                </a>
            </td>
            <td style="text-align: end">${item.product.price} PLN</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
