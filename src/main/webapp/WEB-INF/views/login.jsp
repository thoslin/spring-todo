<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Login | Spring.Do</title>
</head>
<body>
    <h1>Login</h1>
    <form action="<c:url value='/login_processing' />" method="post">
        <input type="text" name="username" />
        <input type="password" name="password" />
        <p>
            <button type="submit">Submit</button>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    <p>
        No account? <a href="<c:url value="/signup" />">Sign Up</a>
    </p>
</body>
</html>
