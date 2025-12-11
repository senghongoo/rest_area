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

<title>리뷰 관리 - 상세보기</title>

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

</style>
<script type="text/javascript">
	$(function() {
		$('#btnList').click(function() {
			location.href = "review_list.jsp"
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
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2"></div>
				<div id="top">
					<div>
						<input type="button" value="목록" class="btn btn-outline-secondary"	id="btnList"/>
					</div>
				</div>
				<!-- top -->

				<div id="middle">
					<div style="margin-bottom: 10px">
						<div>
							<label>작성자 : <span>cocooco</span></label>
						</div>
						<div style="display: flex; justify-content: space-between;">
							<div>
								<label style="width: 100px"><span>★★★★☆</span></label> <label>휴게소명</label>
							</div>
							<div>
								<label>작성일 : <span>yyyy-MM-dd HH:mm</span></label>
							</div>
						</div>
					</div>
					<div class="d-flex justify-content-between">
						<div class="col-md-3 order-md-1 text-center p-2 pt-0">
							<img src="http://localhost/jsp_prj/common/images/james.png"
								class="rounded img-fluid" alt="">
						</div>
						<div class="col-md-9 order-md-3"
							style="border: 1px solid #DDD; border-radius: 10px; height: 674px; padding: 10px; margin-bottom:6px">
							글을 막 적으면 크기가 변하지 않음 여기에 사용자가 작성한 글이 작성됨</div>
					</div>
				</div>
				<!-- middle -->

				<div id="bottom" class="d-flex justify-content-end">
					<div>
						<input type="button" value="숨기기" class="btn btn-outline-secondary" />
					</div>
				</div>
				<!-- bottom -->
			</main>
		</div>
		<!-- row -->
	</div>
</body>
</html>