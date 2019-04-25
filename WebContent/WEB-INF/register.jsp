<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HYML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>
        Register user
    </title>
</head>
<body>
    <div style="margin: auto; width: 500px; padding-top: 50px">
        <form:form method="post" modelAttribute="user">

            <div class="form-group">
                <label>Username</label>
                <form:input path="username" placeholder="Username" type="text" class="form-control" />
                <form:errors path="username" style="color:red" class="form-text text-muted" />
            </div>

            <div class="form-group">
                <label>Password</label>
                <form:input path="password" placeholder="Password" type="password" class="form-control" />
                <form:errors path="password" style="color:red" class="form-text text-muted" />
                <label>Confirm password</label>
                <form:input path="confirmPassword" placeholder="Confirm password" type="password" class="form-control" />
                <form:errors path="confirmPassword" style="color:red" class="form-text text-muted" />
            </div>

            <div class="form-group">
                <label>Email</label>
                <form:input path="email" placeholder="Email" type="text" class="form-control" />
                <form:errors path="email" style="color:red" class="form-text text-muted" />
            </div>

            <form:button type="submit" class="btn btn-success">Register</form:button>

        </form:form>
    </div>
</body>
</html>