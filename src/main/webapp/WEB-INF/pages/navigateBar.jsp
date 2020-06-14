<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="myTag" uri="/WEB-INF/table.tld" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
    <link rel="stylesheet" href="../../style/css/bootstrap.css">
    <link rel="stylesheet" href="../../style/css/st4.css">
    <link rel="stylesheet" href="../../style/css/myStyles.css">
</head>
<body>
<nav class="col-12 col-md-3 col-lg-2 p-0 vh-100 navBarPosition">
    <h5 class="logo-text-color text-center p-3">ІС "Книжная редакция"</h5>
    <hr>
    <ul class="h5">
        <li class=""><a href="/statistic/">СТАТИСТИКА</a></li>
        <li class=""><a href="/type/">ТИПЫ КНИГ</a></li>
        <li class="active"><a href="/book/">КНИГИ</a></li>
        <li class=""><a href="/author/">АВТОРЫ</a></li>
        <li class=""><a href="/title/">О КНИГАХ</a></li>
        <li class=""><a href="/order/">ЗАКАЗЫ</a></li>
        <li class=""><a href="/customer/">ЗАКАЗЧИКИ</a></li>
    </ul>
    <hr>
</nav>
</body>
</html>
