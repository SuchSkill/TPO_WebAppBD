<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Resources</title>
</head>

<h1>Avaliable resources:</h1>

<c:forEach items="${list}" var="quiz" varStatus="status" >

    <%--<c:url value="/resource.jsp" var="text">--%>
        <%--<c:param name="text" value="${quiz.name}"/>--%>
    <%--</c:url>--%>
    <%--<a href="/<c:out value="${text}"/>">Click to get item details</a>--%>


    <%--${status.count} <strong>${quiz}</strong> <br>--%>
<c:url value="/resource" var="resURL">
    <c:param name="picked_id" value="${quiz.id}"/>
    <c:param name="list" value="${list}"/>
</c:url>

    <a href="${resURL}">
        ${quiz.name}
    </a><br>

<%--<c:url value="/index.jsp" var="myURL">--%>
   <%--<c:param name="trackingId" value="1234"/>--%>
   <%--<c:param name="reportType" value="summary"/>--%>
<%--</c:url>--%>
<%--<c:import url="${myURL}"/>--%>



</c:forEach>


<!--<% //System.out.println("abc"); %> !!!!!!! NIE ROBIC!!!!!!!!!-->

<%--<jsp:useBean id="user" class="pl.knpj.servlet.model.User"/>--%>

<%--${userBean.username}--%>

<%--<c:if test="${user != null}" >--%>
    <%--<h1>SUPER :D</h1>--%>
<%--</c:if>--%>

<%--<c:forEach begin="0" end="1" step="1" var="abc">--%>
    <%--<h4>${abc}</h4>--%>
<%--</c:forEach>--%>


<%--${quizList.get(0)}--%>
<%--<div class="${quizList}">--%>
    <%--<c:choose>--%>
        <%--<c:when test='${quizList.get(0) == "quiz1"}'>--%>
            <%--<h1>Jeden</h1>--%>
        <%--</c:when>--%>
        <%--<c:otherwise><h1>Otherwise</h1></c:otherwise>--%>
    <%--</c:choose>--%>
<%--</div>--%>
<a href="/logout">
    Logout
</a>
</body>
</html>