<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.repository.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%
    // 로직 입력
    // request, response 사용 가능(JSP가 서블릿으로 변환, 따라서 문법적으로 지원)
    MemberRepository memberRepository = MemberRepository.getInstance();

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    String job = request.getParameter("job");

    Member member = new Member(username, age, job);
    memberRepository.save(member);

%>
<html>
<head>
    <title>JSP 회원저장</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
    <li>job=<%=member.getJob()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
