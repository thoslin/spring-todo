<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Spring Todo</title>
</head>
<body>
    <h1>Hello World! ${version}</h1>
    <ul>
        <li>${todo.description}</li>
    </ul>
    <form method="post" action="/spring-todo/todo">
        <label>
            <input type="text" name="description">
        </label>
        <input type="submit" value="Add">
    </form>
</body>
</html>
