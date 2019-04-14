<%--
  Created by IntelliJ IDEA.
  User: maakaa
  Date: 14.04.19
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Errors</title>
</head>
<body>
Walidacja niepoprawna:<br>
<br>
<p>Book:</p>
<c:forEach items="${errorsBook}" var="error">
    ${error}<br>
</c:forEach><br>
<br>
<p>Author:</p>
<c:forEach items="${errorsAuthor}" var="error">
    ${error}<br>
</c:forEach><br>
<br>
<p>Publisher</p>
<c:forEach items="${errorsPublisher}" var="error">
    ${error}<br>
</c:forEach><br>
</body>
</html>
