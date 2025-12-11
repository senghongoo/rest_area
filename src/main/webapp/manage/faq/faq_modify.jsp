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

<title>자주 묻는 질문 관리 - 상세보기</title>

<!-- bootstrap CDN 시작 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

<!-- 링크 수정 필요 -->
<link href="https://getbootstrap.com/docs/5.3/examples/dashboard/dashboard.css"	rel="stylesheet">

<!-- jQuery -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- summernote5 -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>

<jsp:include page="../template/admin_style_css.jsp" />
<style type="text/css">
.note-resizebar {
    display: none;
}
.note-editor, .note-frame{
	margin-bottom:6px;
}
</style>
<script type="text/javascript">
$(function(){
	$('#summernote').summernote({
		placeholder: '질문의 답변을 작성해주세요',
		tabsize: 2,
		height: 577,
		toolbar: [
		    // [groupName, [list of button]]
		    ['style', ['bold', 'italic', 'underline']],
		    ['fontsize', ['fontsize']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['table', ['table']],
		    ['insert', ['link', 'picture']]
		  ]
	});
	$("#btnList").click(function(){
		location.href="faq_list.jsp";
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
				<div>
					<div id="top" class="d-flex justify-content-start">
						<input type="button" value="목록" class="btn btn-outline-secondary" id="btnList"/>
					</div><!-- top -->

					<div id="middle">
						<div>
							<input type="text" class="form-control form-control-lg"
								placeholder="질문을 작성해주세요" />
						</div>
						<div style="margin: 11px;">
							<label class="col-sm-2 col-form-label">작성자 : <span>관리자</span></label>
							<label class="col-sm-2 col-form-label">작성일 : <span>yyyy-MM-dd HH:mm</span></label>
						</div>
						<div>
							<!-- summernote의 값이 back-end로 전송하기 위해서는 method가 반드시 POST여야함. -->
							<form method="POST" action="" id="frm">
								<textarea id="summernote"></textarea>
							</form>
						</div>
					</div>
					<!-- middle -->

					<div id="bottom" class="d-flex justify-content-end">
						<div>
							<input type="button" value="삭제" class="btn btn-outline-secondary" />
							<input type="button" value="수정" class="btn btn-outline-secondary" />
						</div>
					</div><!-- bottom -->
				</div>
			</main>
		</div>
	</div>
</body>
</html>