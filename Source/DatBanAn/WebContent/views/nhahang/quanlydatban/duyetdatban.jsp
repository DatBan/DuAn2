<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <!DOCTYPE html>
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
				<jsp:include page="/include-dashboard/header-content.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe"> --%>
					<div class="row tieudethemtrang">
						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>

					<div class="row ds-banan">
						<div class="col-md-1">
						
						</div>
						<div class="col-md-11">
						
						<c:forEach var="b" items="${ban}">
						
							<div class="col-md-2 border text-center">
								<a href="nhahang/quanlydatban/chonban.html?idhd=${idhd}&idb=${b.id}"><div class="soban">${b.soban}</div></a>
								<div class="trangthai">Trống</div>
								<div class="songuoi">${b.songuoi}</div>
							</div>
							<div class="col-md-1">						
							</div>
						</c:forEach>
						</div>
						
						
						<div class="col-md-3"></div>
						<div class="col-md-3"></div>
						<div class="col-md-3"></div>
					</div>

					<div class="line"></div>
				<%-- </div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html> --%>