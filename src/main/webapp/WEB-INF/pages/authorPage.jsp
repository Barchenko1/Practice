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
    <div class="addLink">
        <a href="/book/create">Add new author</a>
    </div>
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
                <td></td>
                <td>${author.f_name}</td>
                <td>${author.l_name}</td>
                <td>${author.age}</td>
                <td>${author.email}</td>
                <td>${author.phone}</td>
                <td>${author.card_code}</td>
                <td>
                    <a href="/book/update?">update</a>
                    <a href="/book/delete?">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
