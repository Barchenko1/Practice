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
    <title>Customer Page</title>
</head>
<body>
    <h5 class="logo-text-color text-center p-3">Random Request</h5>
    <jsp:include page="navigateBar.jsp" />
    <form:form method="post" action="/randomRequest/execute">
        <table>
            <tr>
                <td align="right">Type</td>
                <td>
                    <textarea class="form-control" aria-label="With textarea" name="query"></textarea>
                </td>
            </tr>

            <tr>
                <td>
                    <p><input class="btn btn-success" method="post" type="submit" name="Submit" value="OK"> <a href="/randomRequest/" class="btn btn-success" role="button" aria-pressed="true">Cancel</a></p>
                </td>
            </tr>
        </table>
    </form:form>
    <table class="tableBorder">
        <c:forEach var="mass" items="${objectList}" varStatus="i">
            <tr>
            <c:forEach var="ob" items="${mass}" varStatus="i">
                <td>${ob}</td>
            </c:forEach>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
