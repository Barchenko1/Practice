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
    <h1 align="center">Statistic</h1>
    <br/>
    <jsp:include page="navigateBar.jsp" />
    <table class="tableBorder">
        <tr>
            <th>book types</th>
            <th>books</th>
            <th>authors</th>
            <th>customers</th>
        </tr>
        <tr>
            <td>${typeCount}</td>
            <td>${bookCount}</td>
            <td>${authorCount}</td>
            <td>${customerCount}</td>
        </tr>
    </table>
</body>
</html>
