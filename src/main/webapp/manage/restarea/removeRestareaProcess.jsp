<%@ page import="kr.co.sist.restarea.RangeDTO"%>
<%@ page import="kr.co.sist.restarea.RestareaManageService"%>
<%@ page import="kr.co.sist.restarea.RestareaUpdateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("UTF-8");
%>

<%
RestareaManageService rms = RestareaManageService.getInstance();
RestareaUpdateService rus = RestareaUpdateService.getInstance();

RangeDTO rDTO = new RangeDTO();

String keyword = request.getParameter("keyword");
rDTO.setKeyword(keyword);

int totalCnt = rms.searchTotalCnt(rDTO);

int code = Integer.parseInt(request.getParameter("code"));
int currentPage = Integer.parseInt(request.getParameter("currentPage"));

boolean flag = rus.removeRestarea(code);

int afterDeleteCnt = totalCnt - 1;

int pageScale = 10;
int totalPageAfterDelete = (int) Math.ceil((double) afterDeleteCnt / pageScale);

int targetPage = (currentPage > totalPageAfterDelete) ? totalPageAfterDelete : currentPage;

if (targetPage < 1) {
	targetPage = 1;
} // end if

pageContext.setAttribute("flag", flag);
pageContext.setAttribute("keyword", keyword);
pageContext.setAttribute("targetPage", targetPage);
%>

<script type="text/javascript">
	<c:choose>
	<c:when test="${ flag }">
		alert("휴게소를 삭제했습니다.");
		location.href = "restarea_list.jsp?currentPage=${ targetPage }&keyword=${ keyword }";
	</c:when>
	<c:otherwise>
		alert("휴게소 삭제 중 문제가 발생했습니다.");
		history.back();
	</c:otherwise>
	</c:choose>
</script>






