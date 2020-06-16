<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="myTag" uri="/WEB-INF/table.tld" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
    <link rel="stylesheet" href="../../style/css/bootstrap.css">
    <link rel="stylesheet" href="../../style/css/st4.css">
    <title>Customer Page</title>
</head>
<body>
    <h5 class="logo-text-color text-center p-3">Наши заказы</h5>
    <jsp:include page="navigateBar.jsp" />
    <div class="addLink">
        <a href="/order/create">Add new order</a>
    </div>
    <table class="tableBorder">
        <tr>
            <th>title</th>
            <th>price</th>
            <th>circulation</th>
            <th>advance</th>
            <th>public_date</th>
            <th>customer name</th>
            <th>customer surname</th>
            <th>customer email</th>
            <th>actions</th>
        </tr>
        <c:forEach var="dto" items="${orderDtoList}" varStatus="i">
            <tr>
                <td>${dto.title}</td>
                <td>${dto.price}</td>
                <td>${dto.circulation}</td>
                <td>${dto.advance}</td>
                <td>${dto.public_date}</td>
                <td>${dto.f_name}</td>
                <td>${dto.l_name}</td>
                <td>${dto.email}</td>
                <td>
                    <a href="/order/update/${dto.book_id}/${dto.customer_id}">update</a>
                    <a href="/order/delete/${dto.book_id}/${dto.customer_id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p class="addLink">
        <a href="/order/pdfReport">Generate order PDF proposal</a>
    </p>
</body>
</html>
