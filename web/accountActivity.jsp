<%@include file="/includes/header.html"%>
<%-- 
    Document   : Account Activity for technicians to access reports
    Created on : December 3, 2017, 8:11:48 PM
    Author     : Sarah Bean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <h5>TRACKER</h5>

    <c:if test="${tech != null}">
        <p>Welcome ${tech.firstName}<br>${tech.lastName}</p>
        </c:if>
        <c:if test="${tech == null}">
        <p>Not logged in.</p>
    </c:if>

    <c:if test="${tech != null}">
        <h5>REPORTS</h5>
        <p>Select from the following two available reports.</p>        
        <form action="requests" method="post">
            <input type="hidden" name="reportName" value="getTechReport">
            <input type="submit" value="Open Requests Report">
        </form>

        <form action="requests" method="post">
            <input type="hidden" name="action" value="add"> 
            <input type="hidden" name="reportName" value="getTechInfo">
            <input type="submit" value="Tech Report">
        </form>
    </c:if>

</section>

<c:import url="/includes/footer.jsp" />
