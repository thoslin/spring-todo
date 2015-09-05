<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Sign Up | Spring.Do</title>
</head>
<body>
    <h1>Sign up</h1>
    <spring:hasBindErrors name="user">
        <c:forEach var="error" items="${errors.allErrors}">
            <b><spring:message message="${error}" /></b>
            <br/>
        </c:forEach>
    </spring:hasBindErrors>
    <form:form method="post" modelAttribute="user">
        <form:input path="username" />
        <form:password path="password" />
        <p>
            <button type="submit">Submit</button>
        </p>
    </form:form>
    <p>
        Already have account? <a href="<c:url value="/login" />">Login</a>
    </p>
</body>
</html>
