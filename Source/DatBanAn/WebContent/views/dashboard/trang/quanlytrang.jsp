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
				<jsp:include page="/include-dashboard/header-trang.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe"> --%>
					<div class="row tieudethemtrang">
						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>
					<table id="example" class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>STT</th>
								<th>Tiêu đề</th>
								<th>Title</th>
								<th>Người đăng</th>
								<th>Ngày tạo</th>
								<th>Ngày sửa</th>
								<th>Thao tác</th>

							</tr>
						</thead>

						<tbody>
							<c:forEach var="t" items="${trang}" varStatus="status">
								<c:set var="dem" value="${status.index+1}"></c:set>
								<fmt:formatDate var="nt" value="${t.ngaytao}"
									pattern="dd-MM-yyyy" />
								<fmt:formatDate var="ns" value="${t.ngaysua}"
									pattern="dd-MM-yyyy" />
								<tr>
									<td>${dem}</td>
									<td>${t.tieude}</td>
									<td>${t.title}</td>
									<td>${t.nguoiviet.ho }${t.nguoiviet.ten }</td>
									<td>${nt}</td>
									<td>${ns}</td>

									<td style="text-align: center"><a
										href="dashboard/trang/edit/${t.id}.html" style="color: green;">Sửa</a> <a
										href="dashboard/trang/delete/${t.id}.html"
										onclick="return confirm ('Bạn có thực sự muốn xoá trang này')"
										style="color: red; padding-left: 30px;">Xoá</a></td>
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