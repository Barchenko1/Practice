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
    <h5 class="logo-text-color text-center p-3">Информация по книгам</h5>
    <jsp:include page="navigateBar.jsp" />
    <table class="tableBorder">
        <tr>
            <th>№</th>
            <th>title</th>
            <th>price</th>
            <th>circulation</th>
            <th>author name</th>
            <th>author surname</th>
            <th>author pay</th>
        </tr>
        <c:forEach var="dto" items="${titleDtoList}" varStatus="i">
            <tr>
                <td></td>
                <td>${dto.title}</td>
                <td>${dto.price}</td>
                <td>${dto.circulation}</td>
                <td>${dto.f_name}</td>
                <td>${dto.l_name}</td>
                <td>${dto.author_pay}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
