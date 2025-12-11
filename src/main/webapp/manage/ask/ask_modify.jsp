<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>문의사항 관리 - 상세보기</title>

<!-- bootstrap CDN 시작 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

<!-- 링크 수정 필요 -->
<link href="https://getbootstrap.com/docs/5.3/examples/dashboard/dashboard.css"	rel="stylesheet">

<!-- jQuery -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<jsp:include page="../template/admin_style_css.jsp" />
<style type="text/css">

</style>
<script type="text/javascript">
$(function(){
	$("#btnAskList").click(function(){
		location.href="ask_list.jsp";
	});
});
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
				<div>
					<div id="top" class="d-flex justify-content-start">
						<input type="button" value="목록" class="btn btn-outline-secondary" id="btnAskList"/>
					</div><!-- top -->
					
					<div id="middle">
						<div class="d-flex justify-content-between">
							<div style="margin-bottom: 10px">
								<label class="fs-3 fw-bold">휴게소 화장실 문의</label>
							</div>
							<div class="d-flex align-items-center">
								<label class="col-form-label text-center me-3">작성자 : <span>cocooco</span></label>
								<label class="col-form-label text-center">작성일 : <span>yyyy-MM-dd HH:mm</span></label>
							</div>
						</div><!-- 상단 제목 -->
						<div>
							<!-- 사용자가 입력한 내용이 나옴 -->
							<div style="border: 1px solid #DDD; border-radius: 10px; width: 100%; height: 330px; padding: 10px">
							문의사항 내용
							</div>
							<form>
							<textarea style="width: 100%; height: 340px; border: 1px solid #DDD; border-radius: 10px; padding: 10px; margin-top: 10px" placeholder="문의사항의 답변을 입력해주세요."></textarea>
							</form>
						</div>
					</div><!-- middle -->

					<div id="bottom" class="d-flex justify-content-end">
						<div>
							<input type="button" value="취소" class="btn btn-outline-secondary" />
							<input type="button" value="수정" class="btn btn-outline-secondary" />
						</div>
					</div><!-- bottom -->
				</div>
			</main>
		</div>
	</div>
</body>
</html>