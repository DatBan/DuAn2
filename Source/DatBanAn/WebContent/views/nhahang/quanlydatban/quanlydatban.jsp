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
				<jsp:include page="/include-dashboard/header-hoadon-new.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe"> --%>
					
					<table id="example" class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>STT</th>
								
								<th>Họ tên</th>
								<th>Nhân dịp</th>
								<th>Số người</th>
								<th>Thời gian</th>
								<th>Điện thoại</th>
								<th>Trạng thái</th>
								<th>Thao tác</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="t" items="${hoadon}" varStatus="status">
								<c:set var="dem" value="${status.index+1}"></c:set>
								
								<fmt:formatDate var="tg" value="${t.ngaythang}"
									pattern="dd-MM-yyyy" />
								<tr>
									<td>${dem}</td>
									
									<td>${t.ho} ${t.ten}</td>
									<td>${t.nhandip}</td>
									<td>${t.songuoi}</td>
									
									<td> ${tg} ${t.thoigian}</td>
									<td>${t.dienthoai}</td>
									<c:if test="${t.trangthai==0}">
										<td style="text-align: center"><a href="nhahang/quanlydatban/duyet.html?idhd=${t.id}" style="color: green; ">Duyệt</a></td>
									</c:if>
									
									<td style="text-align: center"><a
										href="nhahang/quanlydatban/edit/${t.id}.html"
										style="color: green; ">Sửa</a> <a
										href="nhahang/quanlydatban/delete/${t.id}.html"
										onclick="return confirm ('Bạn có thực sự muốn xoá đơn này')"
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