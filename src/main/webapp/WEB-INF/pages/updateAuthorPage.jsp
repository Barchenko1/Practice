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
<h1 align="center">Update Author</h1>
<br/>
<jsp:include page="navigateBar.jsp" />
<form:form method="post" action="/author/update">
    <table>
        <tr>
            <td align="right">First Name</td>
            <td>
                <input name="f_name" type="text" value="${author.f_name}">
            </td>
        </tr>
        <tr>
            <td align="right">Surname</td>
            <td>
                <input name="l_name" type="text" value="${author.l_name}">
            </td>
        </tr>
        <tr>
            <td align="right">Age</td>
            <td>
                <input name="age" type="number" value="${author.age}">
            </td>
        </tr>
        <tr>
            <td align="right">Phone</td>
            <td>
                <input name="phone" type="tel" value="${author.phone}">
            </td>
        </tr>
        <tr>
            <td align="right">Email</td>
            <td>
                <input name="email" type="email" value="${author.email}">
            </td>
        </tr>
        <tr>
            <td align="right">Pay</td>
            <td>
                <input name="author_pay" type="number" value="${author.author_pay}">
            </td>
        </tr>
        <tr>
            <td align="right">Card code</td>
            <td>
                <input name="card_code" type="text" value="${author.card_code}">
            </td>
        </tr>

        <tr>
            <td>
                <p><input class="btn btn-success" type="submit" name="Submit" value="OK"> <a href="/author/" class="btn btn-success" role="button" aria-pressed="true">Cancel</a></p>
            </td>
        </tr>
    </table>
</form:form>
<div class="center">
    <c:out value="${error}"/>
</div>
</body>
</html>
