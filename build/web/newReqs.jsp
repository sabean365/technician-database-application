<%@include file="/includes/header.html"%>
<%-- 
    Document   : newRequests-web page to enter new service request
    Created on : December 3, 2017, 8:36:40 AM
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
    <h5>SUBMIT NEW REQUEST</h5>
    <p>Please enter the information below:</p>

    <p><i>${message}</i></p>
    <div class="form">  
        <form action="${pageContext.request.contextPath}/requests" method="post">
            <input type="hidden" name="action" value="add">
            <label>Last Name:</label>
            <input type="text" name="firstName" value="${requests.lastName}" required><br>
            <label>Request Date:</label>
            <input type="text" name="lastName" value="${requests.reqDate}" required><br>
            <label>Completion Date:</label>
            <input type="password" name="phone" value="${requests.compDate}"><br>
            <label>Request Description:</label>
            <input type="text" name="firstName" value="${requests.reqDesc}" required><br>
            <label>Request Notes:</label>
            <input type="text" name="lastName" value="${requests.notes}" required><br>
            <button type="submit" value="requests">REQUEST</button>
        </form>
    </div>
</section>


<%@include file="/includes/footer.jsp"%>