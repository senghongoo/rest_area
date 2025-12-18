<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../fragments/siteProperty.jsp"%>
<nav>
	<div class="logoWrap">
		<h1 class="logo">
			<a href="${CommonURL}/index.jsp" title="메인페이지로 이동"></a>
		</h1>
		<ul class="favMenu" id="favMenu">
			<!-- 즐겨찾기 -->
		</ul>
	</div>
	<div class="menu" id="topMenu">
		<ul>
			<li><a href="${CommonURL}/customerservice/notice.jsp" title="고객센터 페이지로 이동">고객센터</a></li>
			<li><a href="${CommonURL}/restarea/restAreaList.jsp" title="휴게소 목록 안내 페이지로 이동">휴게소 목록</a></li>
			<li><a href="${CommonURL}/fragments/logoutProcess.jsp" title="로그아웃 페이지로 이동">로그아웃</a></li>
			<li><a href="${CommonURL}/mypage/myPage.jsp" title="마이페이지로 이동">마이페이지</a></li>
			<!-- top 메뉴 -->
		</ul>
	</div>
</nav>