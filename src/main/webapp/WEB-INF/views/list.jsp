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
<body>
    <div style="position: absolute; top: 15px; left: 15px;">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout" />" > logout</a>
        </c:if>
    </div>
    <div style="width: 400px; margin: 0 auto">
        <h1 style="text-align: center; margin-bottom: 90px; margin-top: 110px">Spring.Do</h1>
        <div class="list-group">
            <c:forEach items="${todo_list}" var="todo">
                <a href="javascript:;" class="list-group-item todo-item" data-id="${todo.id}">${todo.description}</a>
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
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".todo-item").click(function(){
                var item = $(this);
                item.css("text-decoration", "line-through");
                var id = item.data("id");
                $.ajax({
                    url: "/spring-todo/todo/"+id,
                    type: "delete",
                    success: function(){
                        item.fadeOut();
                    }
                })
            });
        });
    </script>
</body>
</html>