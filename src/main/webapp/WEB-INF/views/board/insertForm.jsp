<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>같이 가치</title>
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
	<script src="https://uicdn.toast.com/editor/latest/i18n/ko-kr.js"></script>
	<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
</head>
<body>
	<div class="container flex-column" style="overflow: hidden">
		<!-- header -->
		<c:if test="${ not empty sessionScope.member }">
		 	<jsp:include page="/WEB_INF/views/common/header_loggedIn.jsp" />
		</c:if>
		
		<!-- body -->
		
	</div>
</body>
</html>