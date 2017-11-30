<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Home layout</title>
		<jsp:include page="/include/headtag.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="/include/header.jsp"></jsp:include>
		<!-- form tim kiem -->
		<jsp:include page="${param.view}"></jsp:include>
		
		<jsp:include page="/include/footer.jsp"></jsp:include>
	</body>
</html>