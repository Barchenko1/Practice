<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="myTag" uri="/WEB-INF/table.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <jsp:include page="bookFilter.jsp" />
    <table class="tableBorder bookListTable">
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
                <td>${book.book_id}</td>
                <td>${book.title}</td>
                <td>${book.price}</td>
                <td>${book.circulation}</td>
                <td>${book.advance}</td>
                <td>${book.public_date}</td>
                <td>${book.type_name}</td>
                <td>
                    <a href="/book/update/${book.book_id}">update</a>
                    <a href="/book/delete/${book.book_id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
