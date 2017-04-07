<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 07-Apr-17
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<c:forEach items="${param}" var="currentParam">--%>
    <%--<li><c:out value="${currentParam.key}" />--%>
        <%--= <c:out value="${currentParam.value}" /></li>--%>
<%--</c:forEach>--%>
<%--<c:out value="${param.picked_id}" />--%>
<div>Name: </div><c:out value="${list[param.picked_id-1].name}" /><br><br>
<div>Content: </div><c:out value="${list[param.picked_id-1].text}" /><br>
<a href="resources.jsp">Bo gack</a><br>
<a href="/logout">Logout</a>
</body>
</html>
