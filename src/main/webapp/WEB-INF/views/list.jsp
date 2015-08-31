<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring Todo</title>
</head>
<body>
    <h1>Todo list</h1>
    <ul>
        <c:forEach items="${todo_list}" var="todo">
            <li>${todo.description}</li>
        </c:forEach>
    </ul>
    <form:form method="post" action="/spring-todo/todo" modelAttribute="todo">
        <label>
            <form:input path="description" />
            <form:errors path="description" cssclass="error" />
        </label>
        <p>
            <input type="submit" value="Add">
        </p>
    </form:form>
</body>
</html>
