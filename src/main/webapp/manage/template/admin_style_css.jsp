<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: #0000001a;
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em #0000001a, inset 0 .125em .5em #00000026
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh
}

.bi {
	vertical-align: -.125em;
	fill: currentColor
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch
}

.btn-bd-primary {
	--bd-violet-bg: #712cf9;
	--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
	--bs-btn-font-weight: 600;
	--bs-btn-color: var(--bs-white);
	--bs-btn-bg: var(--bd-violet-bg);
	--bs-btn-border-color: var(--bd-violet-bg);
	--bs-btn-hover-color: var(--bs-white);
	--bs-btn-hover-bg: #6528e0;
	--bs-btn-hover-border-color: #6528e0;
	--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
	--bs-btn-active-color: var(--bs-btn-hover-color);
	--bs-btn-active-bg: #5a23c8;
	--bs-btn-active-border-color: #5a23c8
}

.bd-mode-toggle {
	z-index: 1500
}

.bd-mode-toggle .bi {
	width: 1em;
	height: 1em
}

.bd-mode-toggle .dropdown-menu .active .bi {
	display: block !important
}

.input-group{
	width: 400px
}

.sidebar {
    /* 100vh(화면 전체 높이)에서 헤더 높이(약 56px)를 뺀 만큼을 최소 높이로 설정 */
    min-height: calc(100vh - 54px);
}

.list_title{
	width: 70%
}
.writer{
	width: 10%; 
	text-align: center;
}
.input-date{
	width: 15%; 
	text-align: center;
}

#middle{
	margin-top: 20px; 
}

#bottom{
	padding-top:5px; 
}

.pagination{
	margin-bottom:0px;
}

.nav-link:hover, .nav-link.active, .pagination .page-item .page-link:active {
	color : #000;
	font-weight: bold;
	text-decoration: underline;
}

/* 페이지 변경 버튼 디자인 */
.page-link {
	color: #333; 
	border-width: 0px; 
	background-color: #FFFFFF;
}
/* 클릭했을 때 파란색 테두리(box-shadow)와 배경색 제거 */
.page-link:focus, .page-link:active, .form-control:focus, .form-control:active {
	color: #333; 
	background-color: #FFFFFF; 
	box-shadow: none;
	border-color: #DDDDDD;
}
/* 현재 활성화된 페이지(active) 스타일 */
.pagination .page-item .page-link:active {
	background-color: #FFFFFF; 
	border-color: transparent;
}
.pagination .page-item .page-link:hover {
    color: #333;
}

</style>