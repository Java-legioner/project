<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

    <title>Welcome!</title>
</head>
<body class="security-app">

<div class="lc-block">
    <h1>Welcome!</h1>
    <div class="alert-normal">
        Click <a href="<spring:url value='/login' />">here</a> to login
        <span><a href="/user">User</a></span>
    </div>
    <form action="/logout" method="post">
        <input type="submit" class="button red big" value="Sign Out" /> <input
            type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>
</body>
</html>