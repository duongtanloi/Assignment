<%-- 
    Document   : dsDepart
    Created on : Feb 16, 2017, 7:51:43 PM
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
                        <a href="pb/showdepart.htm?lang=en">English</a> | <a href="pb/showdepart.htm?lang=vi">Tiếng Việt</a>  
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
        <h1>Danh sách Depart</h1>
        <div class="borderr">
        <form:form action="pb.htm" modelAttribute="depart">
            <div>Id</div>
            <form:input path="id"/>
            <div>Name</div>
            <form:select path="name">
                <form:option value="HanhChinh">HanhChinh</form:option>
                <form:option value="KinhDoanh">KinhDoanh</form:option>
                <form:option value="KeToan">KeToan</form:option>
                <form:option value="NhanSu">NhanSu</form:option>
        </form:select>
           
            <div>
            <button class="button" name="btnInsert">Insert</button>
            <button class="button" name="btnUpdate">Update</button>         
            </div>
        </form:form>
        </div>
            <br>
            <table border="1">
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    
                    <td>Edit</td>
                    <td>Delete</td>
                </tr>
                <c:forEach var="rows" items="${listDepart}">
                    <form action="pb/delete.htm">
                        <tr>
                            <td>${rows.id}</td>
                            <td>${rows.name}</td>
                           
                            <c:url var="del" value="pb/edit.htm">
                                <c:param name="txtId" value="${rows.id}"/>
                                <c:param name="txtName" value="${rows.name}"/>
                               
                            </c:url>
                            <td><a href="${del}">Edit</a></td>
                            <td>
                                <input type="hidden" name="txtId" value="${rows.id}"/>
                                <input class="buttonde" type="submit" name="action" value="Delete"/>
                            </td>
                        </tr>
                    </form>
                </c:forEach>    
            </table>
             </div>
            <!--end right-->
            <div class="footer">ABC GROUP</div>
         </div>
    </body>
</html>
