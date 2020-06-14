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
    <h5 class="logo-text-color text-center p-3">Наши заказчики</h5>
    <jsp:include page="navigateBar.jsp" />
    <table class="tableBorder">
        <tr>
            <th>№</th>
            <th>first name</th>
            <th>surname</th>
            <th>age</th>
            <th>login</th>
            <th>password</th>
            <th>email</th>
            <th>phone</th>
            <th>actions</th>

        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="i">
            <tr>
                <td></td>
                <td>${customer.f_name}</td>
                <td>${customer.l_name}</td>
                <td>${customer.age}</td>
                <td>${customer.login}</td>
                <td>${customer.password}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
                <td>
                    <a href="/book/update?">update</a>
                    <a href="/book/delete?">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
