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

<title>대시보드</title>

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
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
/* 모던한 카페 스타일 배경 및 레이아웃 */
#myCafeChart, #myCurveChart, #ReviewChart {
	background-color: #ffffff;
	font-family: 'Noto Sans KR', sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}
/* 모던한 카페 스타일 */
.chart-container {
	background: white;
	padding: 10px;
	border-radius: 10px;
	border: 1px solid #DDDDDD;
	width: 500px;
}

h5 {
	text-align: center;
	color: #333;
	margin-bottom: 20px;
}
</style>

</head>
<body>
	<div id="wrap">
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
							대시보드
						</h1>
					</div>

					<div id="middle" class="d-flex justify-content-center"
						style="padding-top: 200px">
						<div class="chart-container">
							<h5>지난 0개월 간 가입자 수</h5>
							<canvas id="myCurveChart"></canvas>
						</div>
						<script>
							const ctx = document.getElementById('myCurveChart')
									.getContext('2d');

							new Chart(ctx, {
								type : 'line', // 1. 여기를 'line'으로 변경!
								data : {
									labels : [ '0월', '0월', '0월', '0월', '0월',
											'0월' ],
									datasets : [ {
										label : '가입자 수',
										data : [ 25, 40, 85, 90, 55, 40 ],

										// 2. 핵심: 곡선 만들기 (0 ~ 1 사이 값)
										lineTension : 0,

										// 3. 디자인 옵션 (선 색상 및 채우기)
										borderColor : '#333',
										borderWidth : 1,
										pointBackgroundColor : '#ffffff', // 포인트 배경색 (흰색)
										pointBorderColor : '#000', // 포인트 테두리
										pointRadius : 1, // 포인트 크기
										fill : false
									// 선 아래 영역 채우기 (true/false)
									} ]
								},
								options : {
									responsive : true,
									scales : {
										y : {
											beginAtZero : true
										}
									// 0부터 시작
									},
									plugins : {
										legend : {
											display : false
										}
									// 범례 표시
									}
								}
							});
						</script>

						<div class="chart-container">
							<h5>지난 주 사이트 방문자 수</h5>
							<canvas id="myCafeChart"></canvas>
						</div>
						<script>
							const ctx2 = document.getElementById('myCafeChart')
									.getContext('2d');

							// 차트 생성
							new Chart(ctx2, {
								type : 'bar', // 막대 그래프 (line, pie, doughnut 등 변경 가능)
								data : {
									labels : [ '월', '화', '수', '목', '금', '토',
											'일' ],
									datasets : [ {
										label : '판매 잔 수',
										data : [ 120, 190, 300, 500, 200, 300,
												450 ], // 실제 데이터가 들어갈 곳
										borderColor : "#BBBBBB",
										borderWidth : 1,
										borderRadius : 3, // 막대 끝을 둥글게 (모던한 느낌)
									} ]
								},
								options : {
									responsive : true,
									scales : {
										y : {
											beginAtZero : true
										}
									},
									plugins : {
										legend : {
											display : false
										}
									// 범례 숨김 (심플하게)
									}
								}
							});
						</script>

						<div class="chart-container">
							<h5>노선 별 휴게소 별점 평균</h5>
							<canvas id="ReviewChart"></canvas>
						</div>
						<script>
							const ctx3 = document.getElementById('ReviewChart')
									.getContext('2d');

							new Chart(ctx3, {
								type : 'line', // 1. 여기를 'line'으로 변경!
								data : {
									labels : [ '노선A', '노선B', '노선C', '노선D',
											'노선E', '노선F', '노선G' ],
									datasets : [ {
										label : '평균 별점',
										data : [ 10, 25, 40, 85, 90, 55, 40 ],

										// 2. 핵심: 곡선 만들기 (0 ~ 1 사이 값)
										lineTension : 0.3,

										// 3. 디자인 옵션 (선 색상 및 채우기)
										borderColor : '#333',
										borderWidth : 1,
										pointBackgroundColor : '#ffffff', // 포인트 배경색 (흰색)
										pointBorderColor : '#000', // 포인트 테두리
										pointRadius : 1, // 포인트 크기
										fill : false
									// 선 아래 영역 채우기 (true/false)
									} ]
								},
								options : {
									responsive : true,
									scales : {
										y : {
											beginAtZero : true
										}
									// 0부터 시작
									},
									plugins : {
										legend : {
											display : false
										}
									// 범례 표시
									}
								}
							});
						</script>
					</div>
				</main>
			</div>
		</div>
	</div>
	<!-- wrap -->

</body>
</html>