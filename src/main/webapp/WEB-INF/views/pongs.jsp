<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Pong!</title>
    <style>
        <%@ include file="../styles.css" %>
    </style>
</head>
<body>
<p>Pongs!</p>
<c:if test="${not empty pongs}">
    <ul id="pong" class="list-group">
        <c:forEach var="pong" begin="0" items="${pongs}">
            <li class="list-group-item">
                <h4>
                    <a href="./${pong.id}">${pong.name}</a>
                </h4>
            </li>
        </c:forEach>
    </ul>
    <a href="./new">Lisää uusi</a>
</c:if>
</div>
</body>
</html>
