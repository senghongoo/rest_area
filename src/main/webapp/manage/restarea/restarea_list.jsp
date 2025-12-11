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

<title>휴게소 관리</title>

<!-- font-awesome CDN 시작 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">

<!-- bootstrap CDN 시작 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

<!-- 링크 수정 필요 -->
<link href="https://getbootstrap.com/docs/5.3/examples/dashboard/dashboard.css" rel="stylesheet">

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<jsp:include page="../template/admin_style_css.jsp" />


<style type="text/css">
#top {
	width: 100%;
	margin-bottom: 30px;
	display: flex;
	justify-content: space-between;
}

#top-right {
	display: flex;
}

#search {
	border: 1px solid rgb(222, 226, 230);
	padding-top: 5px;
	padding-left: 10px;
	border-radius: 5px;
	margin-right: 5px;
}

#search i {
	color: gray;
}

#search input {
	width: 250px;
	border: none;
}

#search input:focus {
	outline: none !important;
}

th, td {
	text-align: center;
	vertical-align: middle;
}

td {
	height: 55px;
}

.pagination {
	justify-content: center;
}

.page-item.active a {
	border-color: gray;
	background-color: gray;
	color: white;
	box-shadow: none;
}

.page-link, nav span {
	color: #333;
}

.page-item-hover a {
	color: rgb(51, 51, 51) !important;
}
</style>

<script type="text/javascript">
const totalItems = 50;
const itemsPerPage = 10;
const totalPages = Math.ceil(totalItems / itemsPerPage);
let currentPage = 1;

function generateData() {
	const data = [];
	const restAreaNames = ["덕평자연휴게소", "마장휴게소", "금강휴게소", "행담도휴게소", "내린천휴게소"];
	const addresses = ["경기 이천시 마장면", "경기 광주시 중부대로", "충북 옥천군 동이면", "충남 당진시 신평면", "강원 인제군 상남면"];
	const amenitiesList = ["주유소, 식당가, 편의점", "호텔, 쇼핑몰, 푸드코트", "선상카페, 쉼터", "아울렛, 놀이시설", "수소차 충전소, 휴게공간"];

	for (let i = 1; i <= totalItems; i++) {
		const day = String(i % 30 + 1).padStart(2, '0');
		const randomDateOffset = Math.floor(Math.random() * 5); // 0~4일 차이
		const randomDay = String((i % 30 + 1 + randomDateOffset) % 30 + 1).padStart(2, '0');
		const num = String(1000 + i).padStart(4, '0')

		data.push({
			id: i,
			restAreaName: restAreaNames[i % restAreaNames.length], // 예시 데이터
			address: addresses[i % addresses.length],
			phoneNumber: `031-123-${num}`,
			amenities: amenitiesList[i % amenitiesList.length],
			createdAt: `2025-11-${day}`,
			updatedAt: `2025-11-${randomDay}`
		});
	}

	return data.reverse(); 
}

const allData = generateData();

function renderTable(page) {
	const start = (page - 1) * itemsPerPage;
	const end = start + itemsPerPage;
	const itemsToShow = allData.slice(start, end);

	let content = '';
	itemsToShow.forEach(item => {
		content += `<tr>
						<th scope="row">${item.restAreaName}</th>
						<td>${item.address}</td>
						<td>${item.phoneNumber}</td>
						<td>${item.amenities}</td>
						<td>${item.createdAt}</td>
						<td>${item.updatedAt}</td>
					</tr>`;
	});
	$("tbody").html(content);
	currentPage = page;
}

function renderPagination() {
	let paginationHtml = '';
	
	const prevDisabled = currentPage === 1 ? 'disabled' : '';
	paginationHtml += `
		<li class="page-item ${prevDisabled}">
			<a class="page-link" href="#" onclick="changePage(${currentPage - 1}, event)" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
	`;

	for (let i = 1; i <= totalPages; i++) {
		const isActive = i === currentPage ? 'active' : '';
		paginationHtml += `
			<li class="page-item ${isActive}">
				<a class="page-link" href="#" onclick="changePage(${i}, event)">
					${i}
				</a>
			</li>
		`;
	}

	const nextDisabled = currentPage === totalPages ? 'disabled' : '';
	paginationHtml += `
		<li class="page-item ${nextDisabled}">
			<a class="page-link" href="#" onclick="changePage(${currentPage + 1}, event)" aria-label="Next">
				<span aria-hidden="true">&raquo;</span>
			</a>
		</li>
	`;

	$("#pagination-ul").html(paginationHtml);
}

function changePage(page, event) {
	if (event) event.preventDefault(); 
	if (page < 1 || page > totalPages || page === currentPage) return;

	renderTable(page);
	renderPagination();
	
	$('html, body').animate({
		scrollTop: $("#wrap").offset().top
	}, 300);
}

$(function () {
	renderTable(1);
	renderPagination();
	
	// '삭제하기' 버튼 관련 코드는 현재 칼럼 구조에서 제거되었으므로 주석 처리하거나 제거하는 것이 좋습니다.
	// 만약 삭제 기능을 다시 추가하려면 테이블에 해당 칼럼을 추가해야 합니다.
	/* $("tbody").on('click', '.delete-btn', function() {
		const row = $(this).closest('tr');
		const name = row.find('th:first').text(); 
		console.log('삭제 버튼 클릭됨 (휴게소명):', name);
	});
	*/

	$("#pagination-ul").on("mouseover", ".page-item", function() {
    	$(this).addClass("page-item-hover");
	}).on("mouseout", ".page-item", function() {
    	$(this).removeClass("page-item-hover");
	});
	
	$("#top button").attr("class", "btn btn-primary");
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
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">
						<!-- 선택한 사이드바 이름 -->
						<span>휴게소 관리</span>
					</h1>
				</div>
				<div id="wrap">
					<div id="top">
					<div id="top-left">
				<button>휴게소 추가</button>
			</div>
			<div id="top-right">
				<div id="search">
					<i class="fa-solid fa-magnifying-glass"></i> <input type="text"
						placeholder="Search">
				</div>
				<button>검색</button>
			</div>
					</div>
					<div id="middle">
						<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col" style="width: 15%">휴게소명</th>
					<th scope="col" style="width: 20%">주소</th>
					<th scope="col" style="width: 15%">전화번호</th>
					<th scope="col" style="width: 20%">편의시설</th>
					<th scope="col" style="width: 15%">생성일</th>
					<th scope="col" style="width: 15%">수정일</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
					</div>
					<div id="bottom">
						<nav aria-label="Page navigation example">
			<ul class="pagination" id="pagination-ul">
			</ul>
		</nav>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>