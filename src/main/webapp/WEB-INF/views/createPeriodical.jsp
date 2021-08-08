<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="cotextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>


    <title>Create Periodical</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

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
        <form style="margin-left: 10px;" action="/logout" method="post">
            <input type="submit" class="button red big" value="Sign Out"/> <input
                type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>

    <!-- Page Content -->
    <div style="margin-left:15%">

        <div class="w3-container w3-teal">
            <h1> Create new periodical</h1>
        </div>
        <div class="w3-container">
           <form:form method="POST" action="${contextPath}/addPeriodical" enctype="multipart/form-data">
               <table>
                   <tr>
                       <td>Name</td>
                       <td><input type="text" name="name"></td>
                   </tr>
                   <tr>
                       <td>Description</td>
                       <td><input type="text" name="description"></td>
                   </tr>
                   <tr>
                       <td>Price</td>
                       <td><input type="number" name="price"></td>
                   </tr>
                   <tr>
                       <td>Select photo</td>
                       <td><input type="file" name="image"></td>
                   </tr>
                   <tr>
                       <td><input type="submit" value="Submit"/></td>
                   </tr>
               </table>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

           </form:form>
        </div>

    </div>


</div>
</body>
</html>