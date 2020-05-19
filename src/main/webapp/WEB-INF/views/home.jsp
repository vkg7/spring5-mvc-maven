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
<h3>${message}</h3>
<h1>User List</h1>
<div style="overflow-x:auto;">
    <table id="users" border="2" width="70%" cellpadding="2">
        <tr>
<%--            <th><label>Id</label></th>--%>
            <th><label>User Id</label></th>
            <th><label>User Name</label></th>
            <th><label>User Role</label></th>
            <th><label>User Status</label></th>
            <th><label>Date</label></th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${listOfUsers}">
            <tr>
<%--                <td>${user.id}</td>--%>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>${user.userRole}</td>
                <td>${user.userStatus}</td>
                <td>${user.date}</td>
                <td><a href="update/${user.id}">Edit</a></td>
                <td><a href="delete/${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
</div>
<div align="center">
    <a href="/register"><label>Register New User</label></a>
    <br/>
    <a href="/"><label>Logout</label></a>
</div>
</body>
</html>