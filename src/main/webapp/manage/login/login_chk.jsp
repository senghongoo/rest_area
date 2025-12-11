<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//유효성 검증(DB 확인)


//유효성 검증 성공 후 
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
session.setAttribute("date", sdf.format(date));
response.sendRedirect("../dashboard/dashboard.jsp");
%>