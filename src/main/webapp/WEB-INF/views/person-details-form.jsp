<%--
  Created by IntelliJ IDEA.
  User: maakaa
  Date: 13.04.19
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Person details form</title>
</head>
<body>
Add person details:
    <form:form method="post" modelAttribute="personDetails">

        <%--<form:input path="login"/><br>
        Password:
        <form:password path="password"/><br>
        E-mail:
        <form:input path="email"/><br>--%>
        First Name:
        <form:input path="firstName"/><br>
        Last Name:
        <form:input path="lastName"/><br>
        <%--Gender:
        <form:radiobutton path="gender" value="Male"/>
        <form:radiobutton path="gender" value="Female"/>
        <form:radiobutton path="gender" value="Other"/><br>
        Country:
        <form:select path="country">
                <form:option value="-" label="--Please Select--"/>
                <form:options items="${countries}"/>
        </form:select>
        Notes:
        <form:textarea path="notes" rows="3" cols="20"/><br>
        Mailing List
        <form:checkbox path="mailingList"/><br>
        Programming Skills:
        <form:select path="programmingSkills" multiple="true">
                <form:option value="-" label="--Please Select--"/>
                <form:options items="${programmingSkills}"/>
        </form:select>
        Hobbies:
        <form:checkbox path="hobbies" items="${hobbies}" itemLabel="name" itemValue="id"/><br>
        <input type="submit" value="save"><br>--%>
    </form:form>
</body>
</html>
