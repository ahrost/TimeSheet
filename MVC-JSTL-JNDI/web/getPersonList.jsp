
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>NAME</td>
            </tr>
        <jstl:forEach items="${requestScope.list}" var="personTO">
        <tr>

            <td><jstl:out value="${personTO.id}"/></td>
            <td><jstl:out value="${personTO.name}"/></td>

        </tr>

         </jstl:forEach>
        </table>
</body>
</html>