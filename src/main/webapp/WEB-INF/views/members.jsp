<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    <th>job</th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${members}">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.age}</td>
            <td>${item.job}</td>
        </tr>
    </c:forEach>
    <%-- 이 for문을 위처럼 깔끔하게 설정할 수 있음
    <%
        for (Member member : members) {
            out.write("     <tr>\n");
            out.write("         <td>" + member.getId() + "</td>\n");
            out.write("         <td>" + member.getUsername() + "</td>\n");
            out.write("         <td>" + member.getAge() + "</td>\n");
            out.write("         <td>" + member.getJob() + "</td>\n");
        }
    %>
    --%>
    </tbody>
</table>
</body>
</html>
