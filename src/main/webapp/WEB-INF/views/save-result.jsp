<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <!-- 프로퍼티 접근법, 조회할 때는 자동으로 get, 값을 넣으면 set 으로 호출 -->
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
    <li>job=${member.job}</li>

    <%--
    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
    <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>
    <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>
    <li>job=<%=((Member)request.getAttribute("member")).getJob()%></li>
    --%>

</ul>
<a href="/index.html">메인</a>
</body>
</html>
