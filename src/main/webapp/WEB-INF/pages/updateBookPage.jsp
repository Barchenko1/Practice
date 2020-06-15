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
<h1 align="center">Add Book</h1>
<br/>
<jsp:include page="navigateBar.jsp" />
<form:form method="post" action="/book/update/${book.book_id}" name="userform" >
    <table>
        <tr>
            <td align="right">Title</td>
            <td>
                <input name="title" type="text" value="${book.title}">
            </td>
        </tr>
        <tr>
            <td align="right">Price</td>
            <td>
                <input name="price" type="number" value="${book.price}">
            </td>
        </tr>
        <tr>
            <td align="right">Circulation</td>
            <td>
                <input name="circulation" type="number" value="${book.circulation}">
            </td>
        </tr>
        <tr>
            <td align="right">Advance</td>
            <td>
                <input name="advance" type="number" value="${book.advance}">
            </td>
        </tr>
        <tr>
            <td align="right">Public Date</td>
            <td>
                <input name="public_date" type="date" value="${book.public_date}">
            </td>
        </tr>
        <tr>
            <td align="right">Type</td>
            <td>
                <input name="type_name" value="${type.type_name}">
            </td>
        </tr>

        <tr>
            <td>
                <p><input class="btn btn-success" method="post" type="submit" name="Submit" value="OK"> <a href="/book/" class="btn btn-success" role="button" aria-pressed="true">Cancel</a></p>
            </td>
        </tr>
    </table>
</form:form>
<div class="center">
    <c:out value="${error}"/>
</div>
</body>
</html>
