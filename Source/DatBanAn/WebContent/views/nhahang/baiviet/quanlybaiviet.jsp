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
				<jsp:include page="/include-dashboard/header-bv-nhahang.jsp"></jsp:include>

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
								<th>Name</th>
								<th>Loại ẩm thực</th>
								<th>Hình</th>
								<th>Trạng thái</th>
								<th>Ngày tạo</th>
								<th>Ngày sửa</th>
								<th>Thao tác</th>

							</tr>
						</thead>

						<tbody>
							<c:forEach var="bv" items="${baiviet}" varStatus="status">
								<c:set var="dem" value="${status.index+1}"></c:set>
								<fmt:formatDate var="nt" value="${bv.ngaytao}"
									pattern="dd-MM-yyyy" />
								<fmt:formatDate var="ns" value="${bv.ngaysua}"
									pattern="dd-MM-yyyy" />
								<tr>
									<td>${dem}</td>
									<td>${bv.tieude}</td>
									<td>${bv.name}</td>
									<td>${bv.loaibv.tenloai}</td>
									<td><img class="img-responsive"
										src="upload/baiviet/${bv.hinh}" style="width:60px;height:60px;" /></td>
									<c:if test="${bv.trangthai==1}">
										<td>Đã duyệt</td>
									</c:if>
									<c:if test="${bv.trangthai==0}">
										<td>Đang chờ duyệt</td>
									</c:if>
									<c:if test="${bv.trangthai==3}">
										<td>Bạn đã xoá</td>
									</c:if>
									<c:if test="${bv.trangthai==4}">
										<td>Admin dã xoá</td>
									</c:if>
									<td>${nt}</td>
									<td>${ns}</td>


									<td style="text-align: center"> <a href="nhahang/baiviet/edit/${bv.id}.html"
										style="color: green; padding-left: 30px;">Sửa</a> <a
										href="nhahang/baiviet/delete/${bv.id}.html"
										onclick="return confirm ('Bạn có thực sự muốn xoá bài viết này')"
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