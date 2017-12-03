<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
					<div class="row tieudethemtrang">
						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>
					<table id="example" class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>STT</th>
								<th>Tên nhà hàng</th>
								<th>Loại ẩm thực</th>
								<th>Tên</th>
								<th>Địa chỉ 1</th>
								<th>Địa chỉ 2</th>
								<th>Tỉnh thành</th>
								<th>Thành phố</th>
								<th>Quận</th>
								<th>Huyện</th>
								<th>Phường xã</th>
								<th>Khu vực</th>
								<th>Số điện thoại</th>
								<th>Giới thiệu</th>
								<th>Về chúng tôi</th>
								<th>Mô tả</th>
								<th>giờ mở cửa</th>
								<th>giờ đóng cửa</th>
								<th>Ngày tạo</th>
								<th>Thao tác</th>

							</tr>
						</thead>

						<tbody>
							<c:forEach var="t" items="${nhahang}" varStatus="status">
								<c:set var="dem" value="${status.index+1}"></c:set>
								<fmt:formatDate var="nt" value="${t.ngaytao}"
									pattern="dd-MM-yyyy" />
							 <fmt:Date var="gmc" value="${t.giomocua}" pattern="" />
							<fmt:Date var="gdc" value="${t.giodongcua}" pattern="" /> 

								<tr>
									<td>${dem}</td>
									<td>${t.tennhahang}</td>
									<td>${t.name}</td>
									<td>${t.diachi }</td>
									<td>${t.address}</td>
									<td>${t.tinhthanh}</td>
									<td>${t.city}</td>
									<td>${t.quanhuyen}</td>
									<td>${t.district}</td>
									<td>${t.phuongxa}</td>
									<td>${t.ward}</td>
									<td>${t.sdt}</td>
									<td>${t.thumbnail}</td>
									<td>${t.gioithieu}</td>
									<td>${t.aboutus}</td>
									<td>${t.mota}</td>
								
									<td>${nt}</td>
									 <td>${gmc}</td>
									<td>${gdc}</td>

									<td style="text-align: center"><a
										href="trang/edit/${t.id}.html" style="color: green;">Sửa</a> <a
										href="trang/delete/${t.id}.html"
										onclick="return confirm ('Bạn có thực sự muốn xoá trang này')"
										style="color: red; padding-left: 30px;">Xoá</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="line"></div>
				</div>
			</div>
			<!------------------- Footer dashboard------------ -->
		</div>
	</div>
</body>
</html>