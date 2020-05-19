<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Users</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
<div align="center">
    <h2>Edit User</h2>
    <form:form action="/updateUser" method="post" modelAttribute="user">
        <table border="0">
            <%--<tr>
                <td>ID:</td>
                <td>${user.id}
                    <form:hidden path="id"/>
                </td>
            </tr>--%>
            <tr>
                <form:hidden path="id"/>
                <td>User Id:</td>
                <td><form:input path="userId" maxlength="15" disabled="true"/></td>
                <td align="center"><form:errors path="userId" cssClass="error"/></td>
            </tr>
            <tr>
                <td>User Name:</td>
                <td><form:input path="userName"/></td>
                <td align="center"><form:errors path="userName" cssClass="error"/></td>
            </tr>
            <tr>
                <td>User Role:</td>
                <td><form:input path="userRole"/></td>
                <td align="center"><form:errors path="userRole" cssClass="error"/></td>
            </tr>
            <tr>
                <td>User Status:</td>
                <td><form:input path="userStatus"/></td>
                <td align="center"><form:errors path="userStatus" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><input type="submit" value="Update"></td>
            </tr>
        </table>
    </form:form>
</div>
<div  id="error" align="center" cssClass="error">
    <label style="color:red;text-align:center;">${exception.message}</label>
</div>
</body>
</html>