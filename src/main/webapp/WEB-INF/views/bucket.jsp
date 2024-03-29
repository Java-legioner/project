<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="cotextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="
      <c:url value="/css/main.css"/>"/>
</head>
<body class="security-app">
<div class="lc-block">
    <!-- Sidebar -->
    <div class="w3-sidebar w3-light-grey w3-bar-block " style="width:15%">
        <h3 class="w3-bar-item">Menu</h3>

        <a href="/home" class="w3-bar-item w3-button">Home</a>
        <security:authorize access="hasAuthority('ADMIN')">
        <a href="/create-periodical" class="w3-bar-item w3-button">Create periodical</a>
        </security:authorize>

        <security:authorize access="hasAuthority('USER')">
        <a href="/buckets" class="w3-bar-item w3-button">Bucket</a>
        </security:authorize>

        <security:authorize access="hasAuthority('ADMIN')">
        <a href="/user" class="w3-bar-item w3-button">Users</a>
        </security:authorize>

        <form style="margin-left: 5%;margin-top: 5%;" action="/logout" method="post">
            <input type="submit" class="button red big" value="Sign Out"/> <input
                type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
    <!-- Page Content -->

    <div style="margin-left:15%">
        <div class="w3-container w3-teal card-text">
            <h1> Applicants</h1>
        </div>
        <div class="w3-container">
            <h2>Welcome! ${pageContext.request.userPrincipal.name}</h2>
        </div>
        <div class="container">
            <div class="table-responsive" style="overflow-x: hidden;">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-8"><h2>Bucket</h2></div>
                            <div class="col-sm-4">
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Photo</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <c:if test="${not empty bucketItems}">
                            <c:forEach items="${bucketItems}" var="bucket">
                                <tbody>
                                <tr>
                                    <td>${bucket.id}</td>
                                    <td style="width: 25%"><img src="data:image/jpg;base64, ${bucket.periodical.encodedImage}" style="width:25% "> </td>
                                    <td>${bucket.periodical.name}</td>
                                    <td>${bucket.periodical.description}</td>
                                    <td>${bucket.periodical.price}</td>
                                    <td>
<%--                                        <a href="bucket?id=${bucket.id}" class="view" title="View" data-toggle="tooltip"><i--%>
<%--                                                class="material-icons">&#xE417;</i></a>--%>
<%--                                        <a href="bucket?id=${bucket.id}" class="edit" title="Edit" data-toggle="tooltip"><i--%>
<%--                                                class="material-icons">&#xE254;</i></a>--%>
                                        <a href="bucket?id=${bucket.id}" class="delete" title="Delete" data-toggle="tooltip"><i
                                                class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
                                </tbody>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>