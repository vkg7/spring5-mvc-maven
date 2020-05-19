<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
<div align="center">
    <h2 class="hello-title" th:text="'Welcome to Login Page'"></h2>
    <form:form method="post" action="/login" modelAttribute="login" onsubmit="return checkForm(this)">
        <table border="0">
            <tr>
                <td><label>User Name</label></td>
                <td><form:input path="username" maxlength="15" placeholder="Enter a valid user name" required="true"/></td>
                <td align="center"><form:errors path="username" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Password</label></td>
                <td><form:password path="password" maxlength="16" placeholder="Enter a valid password" required="true"/></td>
                <td align="center"><form:errors path="password" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><input type="submit" value="Login" cssClass="button"/></td>
            </tr>
        </table>
    </form:form>
</div
<div id="error" align="center" cssClass="error">
    <label style="color:red;text-align:center;">${exception.message}</label>
</div>
<div align="center">
    <a href="register"><label>Add New User</label></a>
</div>
</body>
</html>