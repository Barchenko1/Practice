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
    <link rel="stylesheet" href="../../style/css/myStyles.css">
    <title>Books Page</title>
</head>
<body>
    <h5 class="logo-text-color text-center p-3">Наши книги</h5>
    <jsp:include page="navigateBar.jsp" />
    <div class="addLink">
        <a href="/book/create">Add new book</a>
    </div>
    <table class="tableBorder">
        <tr>
            <th>№</th>
            <th>title</th>
            <th>price</th>
            <th>circulation</th>
            <th>advance</th>
            <th>public date</th>
            <th>type</th>
            <th>actions</th>

        </tr>
        <c:forEach var="book" items="${bookList}" varStatus="i">
            <tr>
                <td></td>
                <td>${book.title}</td>
                <td>${book.price}</td>
                <td>${book.circulation}</td>
                <td>${book.advance}</td>
                <td>${book.public_date}</td>
                <td>${book.type_name}</td>
                <td>
                    <a href="/book/update?">update</a>
                    <a href="/book/delete?">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
