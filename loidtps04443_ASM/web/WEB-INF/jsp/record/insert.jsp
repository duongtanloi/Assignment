<%-- 
    Document   : insert
    Created on : Feb 21, 2017, 8:34:47 AM
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
                        <a href="record/insert.htm?lang=en">English</a> | <a href="record/insert.htm?lang=vi">Tiếng Việt</a>  
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
                
                ${message}
                <form:form action="record/insert.htm" modelAttribute="record">
                    <div>
                        <label>Nhân viên</label> 
                        <form:select path="staff.id" items="${staffs}" itemValue="id" itemLabel="name"/>
                    </div>
                    <div>
                        <label>Loại</label>
                        <form:radiobutton path="type" value="1" label="Thành tích"/> 
                        <form:radiobutton path="type" value="0" label="Kỷ luật"/>
                    </div>
                    <div>
                        <label>Lý do</label>
                        <form:textarea path="reason" rows="3"/>
                    </div>
                    <div>
                        <button>Insert</button>
                    </div>
                </form:form>
                
            </div>
            <!--end right-->
            <div class="footer">ABC GROUP</div>
        </div>
    </body>
</html>
