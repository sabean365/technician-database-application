<%@include file="/includes/header.html"%>
<%--
    Document   : Register page for technicians to register on Technician Tracker
    Created on : November 11, 10:34:27 PM
    Author     : Sarah Bean
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<nav>
    <ul>
        <li><a href="index.jsp">HOME</a></li>
        <li><a href="login.jsp">LOGIN</a></li>
        <li><a href="accountActivity.jsp">TRACKER</a></li>
        <li><a href="register.jsp">REGISTER</a></li>
        <li><a href="newReqs.jsp">NEW REQUEST</a></li>
    </ul>

</nav>

<section class="main">
    <h5>REGISTER FOR TECHNICIAN TRACKER</h5>
    <p>Please enter your information below:</p>

    <p><i>${message}</i></p>
    <div class="form">  
        <form action="register" method="post">
            <input type="hidden" name="action" value="add">
            <label>First Name:</label>
            <input type="text" name="firstName" value="${tech.firstName}" required><br>
            <label>Last Name:</label>
            <input type="text" name="lastName" value="${tech.lastName}" required><br>
            <label>Password:</label>
            <input type="password" name="phone" value="${tech.password}" required><br>
            <button type="submit" value="register">REGISTER</button>
        </form>
    </div>
    <br>




    <%@ include file="/includes/footer.jsp" %>
