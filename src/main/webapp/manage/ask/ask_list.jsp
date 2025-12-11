<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <c:if test="${empty date}">
  <c:redirect url="http://192.168.10.89/team_second_prj/admin/login/login_main.jsp"/>
</c:if> --%>
<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>문의사항 관리</title>

<!-- bootstrap CDN 시작 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

<!-- 링크 수정 필요 -->
<link href="https://getbootstrap.com/docs/5.3/examples/dashboard/dashboard.css" rel="stylesheet">

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<jsp:include page="../template/admin_style_css.jsp" />
<style type="text/css">

</style>
<script type="text/javascript">

</script>
</head>
<body>
	<header class="navbar sticky-top bg-dark flex-md-nowrap p-0"
		data-bs-theme="dark">
		<jsp:include page="../template/admin_header.jsp" />
	</header>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../template/admin_sidebar.jsp" />
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2"><!-- 선택한 사이드바 이름 -->문의사항 관리</h1>
				</div>
				<div>
					<div id="top" class="d-flex justify-content-start">
						<form>
							<!-- 해당 버튼을 클릭하면 그에 관한 목록만 나옴 -->
							<input type="radio" class="btn-check" name="options-base" id="option5" autocomplete="off"> 
							<label class="btn btn-outline-secondary" for="option5">답변 완료</label> 
							<input type="radio" class="btn-check" name="options-base" id="option6" autocomplete="off"> 
							<label class="btn btn-outline-secondary" for="option6">답변 예정</label>
						</form>
					</div>
					<!-- top -->
					<div id="middle">
					<table class="table table-hover"><!-- 16줄까지 가능. 그 이후는 새로운 화면? 새로운 리스트로 보여주기 -->
					<!-- service에서 가져온 문의사항 뿌려주기 -->
<!--  				<thead>
					<tr>
						<td>문의사항이 없습니다.</td>
					</tr>
					</thead> -->
					<%
					for(int i = 0; i<16;i++){
					%>
 					<tr>
						<td class="list_title" style="width: 60%"><a class="nav-link text-black" href="ask_modify.jsp"><span>문의사항 제목</span></a></td>
						<td class="writer" style="width: 10%; text-align: center;"><span>작성자</span></td>
						<td class="input-date" style="width: 20%; text-align: center;"><span>yyyy-mm-dd hh:mm</span></td>
						<td class="writer" style="width: 10%; text-align: center;"><span>답변예정</span></td>
					</tr>
 					<%} %>
					</table>
				</div>
				<div id="bottom">
				<nav>
					<!-- pagination을 통해서 생성됨. -->
  					<ul class="pagination justify-content-center">
    					<li class="page-item">
      					<a class="page-link" href="#" aria-label="Previous">
        				<span aria-hidden="true">&laquo;</span>
      					</a>
    					</li>
    					<li class="page-item"><a class="page-link" href="#">1</a></li>
    					<li class="page-item"><a class="page-link" href="#">2</a></li>
    					<li class="page-item">
      					<a class="page-link" href="#" aria-label="Next">
        				<span aria-hidden="true">&raquo;</span>
      					</a>
    					</li>
  					</ul>
					</nav>
				</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>