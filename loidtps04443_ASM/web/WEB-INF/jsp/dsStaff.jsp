<%-- 
    Document   : staff
    Created on : Feb 17, 2017, 2:35:06 PM
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
                        <a href="nv/showall.htm?lang=en">English</a> | <a href="nv/showall.htm?lang=vi">Tiếng Việt</a>  
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
                <h1>Danh sách nhan vien</h1>
                <div class="borderr">
                    <form:form action="nv.htm" modelAttribute="staff">
                        <div class="phan1">
                            <div>Id</div>
                            <form:input path="id"/>
                            <div>Name</div>
                            <form:input path="name"/>
                            <div>Gender</div>
                            <form:input path="gender"/>
                            <div>Birthday</div>
                            <form:input path="birthday"/>
                            <div>Photo</div>
                            <form:input path="photo"/>
                        </div> 

                        <div>Email</div>
                        <form:input path="email"/>
                        <div>Phone</div>
                        <form:input path="phone"/>
                        <div>Salary</div>
                        <form:input path="salary"/>
                        <div>Note</div>
                        <form:input path="notes"/>
                        <div>DepartId</div>
                        <form:input path="departs.id"/>

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
                        <td>Gender</td>
                        <td>Birthday</td>
                        <td>Photo</td>
                        <td>Email</td>
                        <td>Phone</td>
                        <td>Salary</td>
                        <td>Note</td>
                        <td>DepartId</td>
                        <td>Edit</td>
                        <td>Delete</td>
                    </tr>
                    <c:forEach var="rows" items="${listStaff}">
                        <form action="nv/delete.htm">
                            <tr>
                                <td>${rows.id}</td>
                                <td>${rows.name}</td>
                                <td>${rows.gender}</td>
                                <td>${rows.birthday}</td>
                                <td>${rows.photo}</td>
                                <td>${rows.email}</td>
                                <td>${rows.phone}</td>
                                <td>${rows.salary}</td>
                                <td>${rows.notes}</td>
                                <td>${rows.departs.id}</td>
                                <c:url var="del" value="nv/edit.htm">
                                    <c:param name="txtId" value="${rows.id}"/>
                                    <c:param name="txtName" value="${rows.name}"/>
                                    <c:param name="txtGender" value="${rows.gender}"/>
                                    <c:param name="txtBirthday" value="${rows.birthday}"/>
                                    <c:param name="txtPhoto" value="${rows.photo}"/>
                                    <c:param name="txtEmail" value="${rows.email}"/>
                                    <c:param name="txtPhone" value="${rows.phone}"/>
                                    <c:param name="txtSalary" value="${rows.salary}"/>
                                    <c:param name="txtNote" value="${rows.notes}"/>
                                    <c:param name="txtDepartid" value="${rows.departs.id}"/>
                                </c:url>
                                <td><a href="${del}">Edit</a></td>
                                <td> 
                                    <form action="delete.htm" method =" post" >
                                        <input type="hidden" name="txtId" value="${rows.id}"/>
                                        <input class="buttonde" type="submit" name="action" value="Delete"/>
                                    </form>
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
