<%@page import="kr.co.sist.member.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
request.setCharacterEncoding("UTF-8");
%>

<%
MemberService ms=MemberService.getInstance();

String id = request.getParameter("id");
boolean flag = ms.removeMember(id);
System.out.println("+++++++++++++"+id);

pageContext.setAttribute("flag", flag);
%>
<script type="text/javascript">
<c:choose>
<c:when test="${ flag }">
	var msg="회원 삭제 성공";
	alert(msg);
	location.href="member_list.jsp?currentPage=${ param.currentPage }";
</c:when>
<c:otherwise>
	var msg="회원 삭제 중 문제가 발생했습니다.";
	alert(msg);
	history.back();
</c:otherwise>
</c:choose>
</script>






