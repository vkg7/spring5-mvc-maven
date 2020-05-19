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
    <h2>Add A User</h2>
    <form:form action="registerUser" method="post" modelAttribute="user" onsubmit="return checkForm(this)">
        <table border="0">
            <tr>
                <td><label>User Id:</label></td>
                <td><form:input path="userId" maxlength="15" placeholder="Enter a valid user id" required="true"/></td>
                <td align="center"><form:errors path="userId" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>User Name:</label></td>
                <td><form:input path="userName" required="true"/></td>
                <td align="center"><form:errors path="userName" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td><form:password path="password" maxlength="16" placeholder="Enter a valid password" required="true"/></td>
                <td align="center"><form:errors path="password" cssClass="error"/></td>
            </tr>
           <%-- <tr>
                <td>Confirm Password:</td>
                <td><form:password onfocus="this.value=''" path="confirmPassword"/></td>
            </tr>--%>
            <tr>
                <td colspan="3" align="center"><input type="submit" value="Add"></td>
            </tr>
        </table>
    </form:form>
</div>
<div id="error" align="center" cssClass="error">
    <label style="color:red;text-align:center;">${exception.message}</label>
</div>
</body>
</html>