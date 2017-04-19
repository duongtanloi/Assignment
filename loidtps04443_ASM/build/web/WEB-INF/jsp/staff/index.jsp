<%-- 
    Document   : index
    Created on : Feb 20, 2017, 9:36:21 PM
    Author     : WIN7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
         <table class="table table-hover">
            <tr>
                <th>Ma NV</th>
                <th>Ho va Ten</th>
                <th>Gioi Tinh</th>
                <th>Phong Ban</th>
                <th></th>
            </tr>
            <c:forEach var="s" items="${staffs}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.gender?'Nam':'Nu'}</td>
                    <td>${s.depart.name}</td>

                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
