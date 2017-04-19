<%-- 
    Document   : login
    Created on : Feb 10, 2017, 7:39:04 AM
  
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <link href="<c:url value="/css/log.css"/>" rel="stylesheet">
       <!-- <link href="css/log.css" rel="stylesheet" type="text/css"/>-->
    </head>
    <body class="khung">
        <div class="wrapper">
            <h1>Login</h1>
           <spring:form action="login.htm" class="form">
                
                <p class="clearfix">
                    <!--<label for="login">Username</label>-->
                    <input type="text" name="txtuser" placeholder="Username" class="txtlogin"/>
                </p>
                <p class="clearfix">
                   <!--  <label>Password</label>-->
                    <input type="password" name="txtpass"  placeholder="Password" class="txtlogin"/>
                </p>
                <p class="clearfix">
                    <input type="checkbox" name="remember" id="remember">
                    <label for="remember">Remember me?</label>
                    <a href="#" class="pass">Forgot Password?</a>
                </p>
                
                 <p class="clearfix">
                     <button name="btnlogin" class="btnlogin">Login</button>
                 </p>
                 <p class="loi">${loi}</p>
            </spring:form>
        </div>
    </body>
</html>
