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
        <a href="/author/create">Add new author</a>
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
            <th>passport code</th>
            <th>inn code</th>
            <th>actions</th>

        </tr>
        <c:forEach var="author" items="${authorList}" varStatus="i">
            <tr>
                <td>${author.author_id}</td>
                <td>${author.f_name}</td>
                <td>${author.l_name}</td>
                <td>${author.age}</td>
                <td>${author.email}</td>
                <td>${author.phone}</td>
                <td>${author.card_code}</td>
                <td>${author.passport_code}</td>
                <td>${author.inn_code}</td>
                <td>
                    <a href="/author/update/${author.author_id}">update</a>
                    <a href="/author/delete/${author.author_id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
