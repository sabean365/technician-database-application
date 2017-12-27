<%@include file="/includes/header.html"%>
<%--
    Document   : login page which also contains links to register and reset password.
    Created on : November 25, 2017, 11:03:18 AM
    Author     : Sarah Bean
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
    <h5>LOGIN</h5>
    <p>To login to view your work orders, please enter your name and password below:</p><br>
    <c:if test="${message != null}">
        <p><i>${message}</i></p>
    </c:if>
    <form action="login" method="post">
        <input type="hidden" name="action" value="add">  
        <label>Last Name:</label>
        <input type="text" name="lastName" value="${tech.lastName}" required><br>
        <label>First Name:</label>
        <input type="text" name="firstName" value="${tech.firstName}" required><br>
        <label>Password:</label>
        <input type="password" name="password" value="${tech.password}" required><br>
        <button type="submit" value="/login">LOGIN</button>
    </form>

    <h5>RESET PASSWORD</h5>
    <p>Want to change your password? Reset it here.</p>
    <form method="post" action="/passwordReset.jsp">
        <button type="submit" value="reset">RESET</button>
    </form>

    <h5>REGISTER</h5>
    <p>Would you like to register for TECHNICIAN TRACKER? Click below to register.</p>
    <form action="/register.jsp" method="post">
        <button type="submit" value="register">REGISTER</button>

    </form>
</section>
<%@ include file="/includes/footer.jsp" %>
