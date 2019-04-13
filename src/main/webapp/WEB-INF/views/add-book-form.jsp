<%--
  Created by IntelliJ IDEA.
  User: maakaa
  Date: 13.04.19
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book form</title>
</head>
<body>
Add new book:<br>
    <form:form method="post" modelAttribute="book">
        Title:
        <form:input path="title"/><br>
        Authors:
        <form:input path="authors"/><br>
        Publisher:
        <form:select path="publisher">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${publishers}"/>
        </form:select><br>
        Description:
        <form:input path="description"/><br>
        Rating:
        <form:input path="rating"/><br>
        <input type="submit" value="save"><br>
    </form:form>
</body>
</html>