<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Dashboard</title>
		<jsp:include page="/include-dashboard/headtag.jsp"></jsp:include>
	</head>
	<body>
		<div class="wrapper">
					<!----------------------------- Sidebar ----------------------------------->
					<jsp:include page="/include-dashboard/sidebar.jsp"></jsp:include>
				    
				    <!-- Menu top, content -->
				    <div id="content">
				    	<!---------------------------- header-top------------------------------->
						<jsp:include page="/include-dashboard/header.jsp"></jsp:include>
						
						<!-- main content -->
						<div class="main-content">
							<!------------- Breadcrumb, nut bam cac thu -------------->
							<jsp:include page="/include-dashboard/nutbam-header.jsp"></jsp:include>
							
							<!--------------- Table, form cac thu ---------------->
							<div class="content-nhe">
	                			<jsp:include page="${param.view}"></jsp:include>
	                			<div class="line"></div>
                			</div>
						</div>
						<!------------------- Footer dashboard------------ -->
						<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
					</div>
		</div>
	</body>
</html>