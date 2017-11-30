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
				<jsp:include page="/include-dashboard/header-khuyenmai.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe"> --%>
					<div class="row tieudethemtrang">
						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>
					<table id="example" class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>STT</th>
								<th>Chủ đề</th>
								<th>Name</th>
								<th>Thông tin</th>
								<th>Ngày bắt đầu</th>
								<th>Ngày kết thúc</th>
								<th>Trạng thái</th>
								<th>Thao tác</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="t" items="${khuyenmai}" varStatus="status">
								<c:set var="dem" value="${status.index+1}"></c:set>
								<fmt:formatDate var="bd" value="${t.ngaybatdau}"
									pattern="dd-MM-yyyy" />
								<fmt:formatDate var="kt" value="${t.ngayketthuc}"
									pattern="dd-MM-yyyy" />
								<tr>
									<td>${dem}</td>
									<td>${t.chude}</td>
									<td>${t.name}</td>
									<td>${t.thongtin}</td>

									<td>${bd}</td>
									<td>${kt}</td>
									<c:if test="${t.trangthai==true}">
										<td>Đang diễn ra</td>
									</c:if>
									<c:if test="${t.trangthai==false}">
										<td>Đã kết thúc</td>
									</c:if>
									<td style="text-align: center"><a
										href="nhahang/khuyenmai/edit/${t.id}.html"
										style="color: green; ">Sửa</a> </td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="line"></div>
				<%-- </div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html> --%>