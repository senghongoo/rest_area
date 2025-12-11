<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션의 값을 삭제
/* session.removeAttribute(); */
response.sendRedirect("login_main.jsp");
%>