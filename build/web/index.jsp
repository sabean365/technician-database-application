<%@include file="/includes/header.html"%>
<%-- 
    Document   : index--home page for Technician Tracker
    Created on : November 25, 2017, 11:01:04 AM
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

<section class=main>
    <h2>WELCOME TO TECHNICIAN TRACKER</h2>
    <aside>
        <div class="content">
            <h3>USER LOGIN</h3>
            <p>Click below to login<br>to your account.</p>
            <a class="btn" title="Login" href="login.jsp">LOGIN</a><br/><br/>           

        </div>
    </aside>

    <div class="w3-content">
        <img class="mySlides"  
             src="images/techTracker1.jpg"
             alt="Male System Administrator">
        <img class="mySlides" 
             src="images/techTracker2.jpg"
             alt="Female System Administrator">
        <img class="mySlides" 
             src="images/techTracker3.jpg"
             alt="Desktop Support">
        <img class="mySlides" 
             src="images/techTracker4.jpg"
             alt="Desktop Training Male/Female">
    </div>

    <script>
        var myIndex = 0;
        carousel();

        function carousel() {
            var i;
            var x = document.getElementsByClassName("mySlides");
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            myIndex++;
            if (myIndex > x.length) {
                myIndex = 1
            }
            x[myIndex - 1].style.display = "block";
            setTimeout(carousel, 4000);
        }
    </script>
    <h5><i>LOGIN TO TRACK OPEN WORK ITEMS</i></h5>


</section>

<section class="bottom">
    <aside>
        <div class="address">
            <h4>Technician Tracker<br>
                222 Central Ave<br> 
                Saint Petersburg, FL 33701</h4>
            <span id="desktop">888-555-5555 </span><br>
            <a href="mailto:contact@techtracker.com">contact@techtracker.com</a><br>
        </div>
    </aside>
</section>

<c:import url="/includes/footer.jsp" />
