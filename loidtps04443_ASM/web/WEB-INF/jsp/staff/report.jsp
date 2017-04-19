<%-- 
    Document   : report
    Created on : Feb 20, 2017, 9:51:48 PM
    Author     : WIN7
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
    <body>
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
                        <a href="staff/report.htm?lang=en">English</a> | <a href="staff/report.htm?lang=vi">Tiếng Việt</a>  
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
                <h1>Thành tích Nhân viên</h1>
                <table class="table table-hover">
                    <tr>
                        <td>Ma NV</td>
                        <td>Tong Thanh Tich</td>
                        <td>Tong Ky Luat</td>
                        <td>Tong ket</td>

                    </tr>
                    <c:forEach var="a" items="${arrays}">
                        <tr>
                            <td>${a[0]}</td>
                            <td>${a[1]}</td>
                            <td>${a[2]}</td>
                            <td>${a[1]-a[2]}</td>


                        </tr>
                    </c:forEach>
                </table>
            </div>
            <!--end right-->
            <div class="footer">ABC GROUP</div>
        </div>

    </body>
</html>
