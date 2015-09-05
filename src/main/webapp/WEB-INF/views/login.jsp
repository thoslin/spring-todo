<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Login | Spring.Do</title>
</head>
<body>
    <h1>Login</h1>
    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION }" />
    <form action="<c:url value='/login_processing' />" method="post">
        <input type="text" name="username" />
        <input type="password" name="password" />
        <input type="checkbox" name="_spring_security_remember_me" /> Remember me
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
