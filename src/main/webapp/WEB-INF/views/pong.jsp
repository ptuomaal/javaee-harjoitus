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
<p>Pong!</p>
<c:if test="${not empty pong}">
    <div class="pong">
        <span name="pong-id">${pong.id}</span>
        <span>${pong.name}</span>
    </div>
</c:if>
<c:if test="${empty pong}">
    <div class="empty-pong">
        <span>Pongeja ei löytynyt!</span>
    </div>
</c:if>
<div>
    <button onClick="deletePong()">Poista</button>
</div>
<a href="./">Takaisin alkuun</a>
</div>

<script type="application/javascript">
    function deletePong() {
        console.log("Poisto painettu")
        let id = document.querySelector('[name="pong-id"]').textContent
        console.log(id);

        fetch("/ping/resources/ping/id/" + id, {
            method: "DELETE",
        }).then(res => {
            console.log("Request complete! response:", res);
        });
    }
</script>
</body>
</html>
