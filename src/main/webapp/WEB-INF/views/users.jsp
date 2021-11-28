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
<p>Users</p>
<table>
  <tr>
    <th>ID</th>
    <th>First Name</th> 
    <th>Last Name</th>
  </tr>
  <c:forEach var="user" begin="0" items="${users}">
    <tr>
      <td>${user.id}</td>
      <td>${user.firstName}</td>
      <td>${user.lastName}</td>
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>
