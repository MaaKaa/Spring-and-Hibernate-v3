<%--
  Created by IntelliJ IDEA.
  User: maakaa
  Date: 13.04.19
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Person Form</title>
</head>
<body>
Log in:
    <form:form method="post" modelAttribute="person">
        Login:<form:input path="login"/><br>
        Password: <form:input path="password"/><br>
        E-mail:<form:input path="email"/><br>
        <input type="submit" value="save"><br>
    </form:form>
</body>
</html>
