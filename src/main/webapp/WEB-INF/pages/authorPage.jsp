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
    <title>Books Page</title>
</head>
<body>
    <h5 class="logo-text-color text-center p-3">Наши авторы</h5>
    <jsp:include page="navigateBar.jsp" />
    <table class="tableBorder">
        <tr>
            <th>№</th>
            <th>first name</th>
            <th>surname</th>
            <th>age</th>
            <th>email</th>
            <th>phone</th>
            <th>card code</th>
            <th>actions</th>

        </tr>
        <c:forEach var="author" items="${authorList}" varStatus="i">
            <tr>
                <td>${i.index + 1 + (page - 1) * 10}</td>
                <td>${author.title}</td>
                <td>${author.year}</td>
                <td>${author.genre}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
