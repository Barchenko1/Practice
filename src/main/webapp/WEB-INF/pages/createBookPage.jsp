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
<form:form method="post" action="/create" name="userform" >
    <table>
        <tr>
            <td align="right">Title</td>
            <td>
                <input name="title" type="text">
            </td>
        </tr>
        <tr>
            <td align="right">Password</td>
            <td>
                <input name="password" type="text">
            </td>
        </tr>
        <tr>
            <td align="right">Password again</td>
            <td>
                <input name="passwordAgain" type="text">
            </td>
        </tr>
        <tr>
            <td align="right">First Name</td>
            <td>
                <input name="firstName" type="text">
            </td>
        </tr>
        <tr>
            <td align="right">Last Name</td>
            <td>
                <input name="lastName" type="text">
            </td>
        </tr>
        <tr>
            <td align="right">Email</td>
            <td>
                <input name="email" type="email">
            </td>
        </tr>
        <tr>
            <td align="right">Birthday</td>
            <td>
                <input name="birthday" type="date">
            </td>
        </tr>

        <tr>
            <td align="right">Role</td>
            <td><select name="role" class="selectpicker">
                <c:forEach items="${roles}" var="role">
                    <option value="${role.getRoleId()}"><c:out value="${role.getName()}"/></option>
                </c:forEach>
            </select>
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
