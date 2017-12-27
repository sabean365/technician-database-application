<%-- 
    Document   : footer--footer element for all Technician Tracker web pages
    Created on : November 11, 2017, 9:50:06 AM
    Author     : Sarah Bean
--%>

<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>  
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>

<h4>&copy; Copyright <%= currentYear%> Technician Tracker, Inc.</h4>
</body>
</html>
