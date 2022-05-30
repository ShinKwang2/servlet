<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 회원가입 Form</title>
</head>
<body>
<!--webapp 디렉토리는 기본적으로 호출된다.-->
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age:      <input type="text" name="age" />
    job:      <input type="text" name="job" />
    <button type="submit">전송</button>
</form>
</body>
</html>
