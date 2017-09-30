
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
       THX!YOUR ID IS : <jstl:out value="${sessionScope.id}"/>

    <%
    request.getSession().removeAttribute("id");

    %>

</body>
</html>