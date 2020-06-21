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
<h1 align="center">Update Customer</h1>
<br/>
<jsp:include page="navigateBar.jsp" />
<form:form method="post" action="/customer/update/${customer.customer_id}">
    <table>
        <tr>
            <td align="right">First Name</td>
            <td>
                <input name="f_name" type="text" value="${customer.f_name}">
            </td>
        </tr>
        <tr>
            <td align="right">Surname</td>
            <td>
                <input name="l_name" type="text" value="${customer.l_name}">
            </td>
        </tr>
        <tr>
            <td align="right">Age</td>
            <td>
                <input name="age" type="number" value="${customer.age}">
            </td>
        </tr>
        <tr>
            <td align="right">Email</td>
            <td>
                <input name="email" type="email" value="${customer.email}">
            </td>
        </tr>
        <tr>
            <td align="right">Phone</td>
            <td>
                <input name="phone" type="text" value="${customer.phone}">
            </td>
        </tr>

        <tr>
            <td>
                <p><input class="btn btn-success" method="post" type="submit" name="Submit" value="OK"> <a href="/customer/" class="btn btn-success" role="button" aria-pressed="true">Cancel</a></p>
            </td>
        </tr>
    </table>
</form:form>
<div class="center">
    <c:out value="${error}"/>
</div>
</body>
</html>
