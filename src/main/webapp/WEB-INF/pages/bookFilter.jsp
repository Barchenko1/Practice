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
    <title>Filter Page</title>
</head>
<body>
    <div></div>
    <table class="tableBorder">
        <tr>
            <th>type</th>
            <th>actions</th>
        </tr>
        <c:forEach var="type" items="${typeList}" varStatus="i">
            <tr>
                <td>${type.type_name}</td>
                <td>
                    <a href="/book/filter/${type.type_id}">filter</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <a href="/book/" class="btn btn-success" role="button" aria-pressed="true">Return List</a></p>
            </td>
        </tr>
    </table>
</body>
</html>
