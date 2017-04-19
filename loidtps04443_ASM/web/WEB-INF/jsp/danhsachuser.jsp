<%-- 
    Document   : danhsachuser
    Created on : Feb 10, 2017, 8:51:58 AM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>

    </head>
    <body >
        <div class="container">
            <header>ABC GROUP</header>
            <!--begin menu-->
            <div class="menu"> 
                <a href="staff/report.htm"><s:message code="label.login.home"/></a>
                <a href="pb/showdepart.htm"><s:message code="label.login.depart"/></a>
                <a href="nv/showall.htm"><s:message code="label.login.staff"/></a>
                <a href="login/showall.htm"><s:message code="label.login.account"/></a>
                <a href="staff/report.htm"><s:message code="label.login.tt"/></a>
                <a href="record/insert.htm"><s:message code="label.login.dg"/></a>
                <div class="dann">
                    <form action="" method="POST">    
                        <a href="login/showall.htm?lang=en">English</a> | <a href="login/showall.htm?lang=vi">Tiếng Việt</a>  
                    </form>
                </div>
            </div>
            <!--end menu-->
            <!--begin left-->
            <div class="left">
                <div class="menu2">
                    <jsp:include page="menu2.jsp"/>
                </div>
            </div>
            <!--end lefft-->
            <!--begin right-->
            <div class="right"> 

                <h1>Danh sách tài khoản</h1>
                <div class="borderr">
                    <form:form action="login.htm" modelAttribute="user">
                        <div>Username</div>
                        <form:input path="username"/>
                        <div>Password</div>
                        <form:input path="password"/>
                        <div>Fullname</div>
                        <form:input path="fullname"/>
                        <div>
                            <button class="button" name="btnInsert">Insert</button>
                            <button class="button" name="btnUpdate">Update</button>         
                        </div>
                    </form:form>
                </div>
                <br>
                <table border="1" class="border1">
                    <thead>
                        <tr>
                            <td>Username</td>
                            <td>Password</td>
                            <td>Fullname</td>
                            <td>Edit</td>
                            <td>Delete</td>
                        </tr>
                    </thead>
                    <c:forEach var="rows" items="${listUser}">
                        <form action="login/delete.htm">
                            <tbody>
                                <tr>
                                    <td>${rows.username}</td>
                                    <td>${rows.password}</td>
                                    <td>${rows.fullname}</td>
                                    <c:url var="del" value="login/edit.htm">
                                        <c:param name="txtUsername" value="${rows.username}"/>
                                        <c:param name="txtPassword" value="${rows.password}"/>
                                        <c:param name="txtFullname" value="${rows.fullname}"/>
                                    </c:url>
                                    <td><a href="${del}">Edit</a></td>
                                    <td>
                                        <input type="hidden" name="txtUsername" value="${rows.username}"/>
                                        <input class="buttonde" type="submit" name="action" value="Delete"/>
                                    </td>
                                </tr>
                            </tbody>
                        </form>
                    </c:forEach>    
                </table>
            </div>
            <!--end right-->
            <div class="footer">ABC GROUP</div>
        </div>
    </body>
</html>
