<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
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

<title>리뷰 관리</title>

<!-- bootstrap CDN 시작 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
	crossorigin="anonymous"></script>

<!-- 링크 수정 필요 -->
<link
	href="https://getbootstrap.com/docs/5.3/examples/dashboard/dashboard.css"
	rel="stylesheet">

<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<jsp:include page="../template/admin_style_css.jsp" />
<style type="text/css">
.list_title {
	width: 45%
}

.writer {
	width: 15%;
	text-align: center;
}

.rest-area {
	width: 10%;
	text-align: center;
}

.review-rate, .hidden_btn {
	text-align: center;
}
</style>
<script type="text/javascript">
	$(function() {
		$('#btnWrite').click(function() {
			location.href = "notice_write.jsp"
		});

	});//ready
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

					<!-- 선택한 사이드바 이름 -->
					<h1 class="h2">리뷰 관리</h1>
				</div>
				<div>
					<div id="top" class="d-flex justify-content-start">
						<div class="input-group">
							<button class="btn btn-outline-secondary dropdown-toggle"
								type="button" data-bs-toggle="dropdown">휴게소 선택</button>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">선택하면</a></li>
								<li><a class="dropdown-item" href="#">해당 휴게소 리뷰만</a></li>
								<li><a class="dropdown-item" href="#">나오게 함</a></li>
								<li><a class="dropdown-item" href="#">검색 누를 필요 없음</a></li>
							</ul>
							<input type="text" class="form-control">
							<button class="btn btn-outline-secondary" type="button">검색</button>

						</div>
					</div>
					<!-- top -->

					<div id="middle">
						<table class="table table-hover">
							<!-- 15줄까지 가능. 그 이후는 새로운 화면? 새로운 리스트로 보여주기 -->
							<!-- service에서 가져온 리뷰 뿌려주기 -->
							<!--  					<thead>
						<tr>
							<td>작성된 리뷰가 없습니다.</td>
						</tr>
						</thead> -->
							<%
							for (int i = 0; i < 12; i++) {
							%>
							<tr style="vertical-align: middle;">
								<td class="rest-area"><span>00 휴게소</span></td>
								<td class="list_title"><a class="nav-link text-black"
									href="review_detail.jsp"><span>리뷰 내용</span> <svg class="bi"
											aria-hidden="true">
											<use xlink:href="#file_image"></use></svg></a></td>
								<td class="review-rate"><span>별점</span></td>
								<td class="writer"><span>작성자(asdf1234)</span></td>
								<td class="input-date"><span>yyyy-mm-dd hh:mm</span></td>
								<td class="hidden_btn"><input type="button"
									class="btn btn-outline-secondary" value="숨기기" /></td>
							</tr>
							<%
							}
							%>
						</table>
					</div>
					<!-- middle -->

					<div id="bottom">
						<nav>
							<!-- pagination을 통해서 생성됨. -->
							<ul class="pagination justify-content-center">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
					<!-- bottom -->
				</div>
			</main>
		</div>
		<!-- row -->
	</div>
</body>
</html>