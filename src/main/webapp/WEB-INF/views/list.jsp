<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.css" />" rel="stylesheet">
    <title>Spring.Do</title>
</head>
<body style="width: 400px; margin: 0 auto">
    <h1 style="text-align: center; margin-bottom: 90px; margin-top: 90px">Spring.Do</h1>
    <div class="list-group">
        <c:forEach items="${todo_list}" var="todo">
            <a href="#" class="list-group-item">${todo.description}</a>
        </c:forEach>
    </div>
    <form:form method="post" action="/spring-todo/todo" modelAttribute="todo" cssStyle="margin-top: 15px;">
        <spring:hasBindErrors name="todo">
            <c:if test="${errors.hasFieldErrors('description')}">
                <c:set var="errorClass" value="has-error" />
            </c:if>
        </spring:hasBindErrors>
        <div class="form-group<c:out value=' ${errorClass}' />">
            <form:input path="description" cssClass="form-control" placeholder="What's on your mind?" />
        </div>
        <button type="submit" class="btn btn-primary btn-lg btn-block">Add</button>
    </form:form>
</body>
</html>