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
    <h1 align="center">Add Order</h1>
    <br/>
    <p align="center">
        Для того что бы соединить таблицы вам нужно вписать номер (№) книги и номер автора
    </p>
    <jsp:include page="navigateBar.jsp" />
    <form:form method="post" action="/order/create">
        <table>
            <tr>
                <td align="right">Book id</td>
                <td>
                    <input name="book_id" type="number">
                </td>
            </tr>
            <tr>
                <td align="right">Customer id</td>
                <td>
                    <input name="customer_id" type="number">
                </td>
            </tr>

            <tr>
                <td>
                    <p><input class="btn btn-success" method="post" type="submit" name="Submit" value="OK"> <a href="/order/" class="btn btn-success" role="button" aria-pressed="true">Cancel</a></p>
                </td>
            </tr>
        </table>
    </form:form>
<div class="center">
    <c:out value="${error}"/>
</div>
</body>
</html>
