<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 로그인 버튼 클릭하면 login_chk.jsp로 이동함 -->
<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>고속도로 휴게소 관리자 로그인</title>
<!-- bootstrap CDN 시작 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<jsp:include page="login_style_css.jsp" />

<script type="text/javascript">
$(function(){
	$('#btnLogin').click(function(){
		location.href = "login_chk.jsp"
	});
	
});//ready
</script>

</head>
<body class="d-flex align-items-center py-4 bg-body-tertiary">
	<main class="form-signin w-100 m-auto">
		<form id="signinFrm" action="../admin.dashboard/dashboard.jsp" method="post">
			<!-- 로고 -->
			<img class="mb-4" src=""
				alt="" width="72" height="57">
<!-- 			<h1 class="h3 mb-3 fw-normal">로그인</h1>
 -->			<div class="form-floating">
				<input type="text" class="form-control" id="floatingInput"
					placeholder="ID"> <label for="floatingInput">ID</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword"
					placeholder="Password"> <label for="floatingPassword">Password</label>
			</div>
			<input type="button" class="btn btn-primary w-100 py-2" id="btnLogin" value="로그인">
		</form>
	</main>
</body>
</html>