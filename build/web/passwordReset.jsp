<%@include file="/includes/header.html"%>
<%-- 
    Document   : passwordReset -- This page is for staff to reset passwords.
    Created on : November 13, 2017, 3:16:12 PM
    Author     : Sarah Bean
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="business.Tech"%>


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

    <h5>RESET PASSWORD</h5>
    <p>Change your password in the form below:</P>


    <p><i>${message}</i></p>
    <form method="post" action="${pageContext.request.contextPath}/passwordReset">
        <input type="hidden" name="action" value="add"> 
        <label>Last Name:</label>
        <input type="text" name="lastName" value="${tech.lastName}"/><br>
        <label>First Name:</label>
        <input type="text" name="lastName" value="${tech.firstName}"/><br>
        <label>New Password:</label>
        <input type="text" name="newPword" value="${tech.newPword}"><br>
        <label>Confirm:</label>
        <input type="text" name="confirmPword" value="${tech.confirmPword}"><br>
        <button type="submit" value="update">UPDATE</button>
    </form>  


</section>


<%@ include file="/includes/footer.jsp" %>