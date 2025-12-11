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

<title>회원 관리 - 상세보기</title>

<!-- bootstrap CDN 시작 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

<!-- 링크 수정 필요 -->
<link href="https://getbootstrap.com/docs/5.3/examples/dashboard/dashboard.css" rel="stylesheet">

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<jsp:include page="../template/admin_style_css.jsp" />
<!-- <link rel="stylesheet" href="css/basic.css" type="text/css"	media="all" /> -->
<link rel="stylesheet" href="css/board.css" type="text/css" media="all" />
<!-- <link rel="stylesheet" href="css/layout.css" type="text/css" media="all" /> -->
<!-- <link rel="stylesheet" href="css/notosanskr.css" type="text/css" media="all" /> -->

<style type="text/css">

</style>
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
					<h1 class="h2">
						<!-- 선택한 사이드바 이름 -->
						<span>회원 관리 - 상세보기</span>
					</h1>
				</div>
				<div>
					<div>
						<div id="top">
							<div id="btnBox">
								<button class="btn btn-primary">목록으로</button>
							</div>
						</div>
						<div id="middle" class="writeForm">
							<table style="border-top: 1px solid rgb(225, 227, 228);">
								<colgroup>
									<col class="writeForm_col01" />
									<col width="*" />
								</colgroup>
								<tr>
									<th><label for="id">아이디</label></th>
									<td><input data-value="아이디를 입력해주세요." name="id" id="id"
										class="inputTxt inputIdtype" type="text" maxlength="20" /></td>
								</tr>
								<tr>
									<th><label for="name">이름</label></th>
									<td><input data-value="이름을 입력해주세요." id="name" name="name"
										class="inputTxt inputName" type="text" /></td>
								</tr>
								<tr>
									<th scope="row"><label for="">생일</label></th>
									<td><input type="text" name="birthday" id="birthday"
										data-value="생년월일을 입력해 주세요." /></td>
								</tr>
								<tr>
									<th>연락처</th>
									<td><input type="text" name="tel" id="tel" value=""
										onkeyup="isNumberOrHyphen(this);"
										onblur="cvtUserPhoneNumber(this)" data-value="" /></td>
								</tr>
								<tr>
									<th>휴대폰</th>
									<td><input type="text" name="cell" id="cell" value=""
										onkeyup="isNumberOrHyphen(this);"
										onblur="cvtUserPhoneNumber(this)" data-value="휴대폰 번호를 입력해주세요." />
								</tr>

								<tr>
									<th><label for="email">이메일</label></th>
									<td class="mail_type"><input data-value="이메일을 입력해주세요."
										name="email1" id="email1" class="inputEmail" type="text"
										maxlength="100" /><span class="email_txt">@</span> 
										<input data-value="도메인을 입력해주세요."
										name="email2" id="email2" class="inputEmail" type="text"
										maxlength="100" />
								</tr>
								<tr>
									<th><label for="gender">성별</label></th>
									<td><label>남자</label> | <label>여자</label></td>
								</tr>
								<tr>
									<th><label for="zipcode">우편번호</label></th>
									<td><input data-value="우편번호를 입력해주세요." type="text"
										class="zipcode" id="zipcode" name="zipcode" value=""
										readonly="readonly" onclick="zipcodeapi();" />
								</tr>
								<tr>
									<th><label for="addr0">주소</label></th>
									<td class="addr_td"><input data-value="주소를 입력해주세요."
										type="text" id="addr0" class="addr" name="addr0" value=""
										readonly="readonly" /><br /> <input
										data-value="상세주소를 입력해주세요." type="text" id="addr1" class="addr"
										name="addr1" value="" style="margin-top: 7px;" /></td>
								</tr>
							</table>
						</div>
						<div id="bottom"></div>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>