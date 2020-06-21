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
    <title>Books Page</title>
</head>
<body>
    <h5 class="logo-text-color text-center p-3">Информация по книгам</h5>
    <jsp:include page="navigateBar.jsp" />
    <div class="addLink">
        <a href="/item/create">Add new title</a>
    </div>
    <p class="addLink">
        Sort by: <a href="/item/sortAuthor">author name</a> <a href="/item/sortPrice">price</a>
    </p>
    <form:form method="post" action="/item/search">
        <table>
            <tr>
                <td align="right">Search by title:</td>
                <td>
                    <input name="searchString" type="text">
                </td>
            </tr>
            <tr>
                <td>
                    <p><input class="btn btn-success" method="post" type="submit" name="Submit" value="OK"> <a href="/item/" class="btn btn-success" role="button" aria-pressed="true">Return List</a></p>
                </td>
            </tr>
        </table>
    </form:form>
    <table class="tableBorder">
        <tr>
            <th>title</th>
            <th>price</th>
            <th>circulation</th>
            <th>author name</th>
            <th>author surname</th>
            <th>author pay</th>
            <th>income</th>
            <th>actions</th>
        </tr>
        <c:forEach var="dto" items="${itemDtoList}" varStatus="i">
            <tr>
                <td>${dto.title}</td>
                <td>${dto.price}</td>
                <td>${dto.circulation}</td>
                <td>${dto.f_name}</td>
                <td>${dto.l_name}</td>
                <td>${dto.author_pay}</td>
                <td>${dto.income}</td>
                <td>
                    <a href="/item/update/${dto.book_id}/${dto.author_id}">update</a>
                    <a href="/item/delete/${dto.book_id}/${dto.author_id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p class="addLink">
        <a href="/item/pdfReport">Generate item PDF proposal</a>
    </p>
</body>
</html>
