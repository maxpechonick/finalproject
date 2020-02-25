<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ctg" uri="customtags" %>
<html><head>Time & Locale info</head>
<body>
<ctg:info-time/>
<jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
<form name="Simple" action="controller" method="POST">
    <input type="hidden" name="time" value="${calendar.timeInMillis}"/>
    <input type="submit" name="button" value="Посчитать время"/>
</form>
</body>
</html>