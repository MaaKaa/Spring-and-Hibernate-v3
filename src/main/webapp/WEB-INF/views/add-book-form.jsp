<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book form</title>
</head>
<body>
Add new book:<br>
    <form:form method="post" modelAttribute="book">
        <form:errors path="title"/><br>
        Title:
        <form:input path="title"/><br>
        <%--<form:errors path="authors"/><br>
        Authors:
        <form:input path="authors"/><br>--%>
       <form:errors path="publisher"/><br>
        Publisher:
        <form:select path="publisher">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${publishers}"/>
        </form:select><br>
        <form:errors path="description"/><br>
        Description:
        <form:input path="description"/><br>
        <form:errors path="rating" /><br>
        Rating:
        <form:input path="rating"/><br>
        <input type="submit" value="save"><br>
    </form:form>
</body>
</html>
