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
				<jsp:include page="/include-dashboard/header-doan.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe"> --%>
					<div class="row tieudethemtrang">
						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>
					<table id="example" class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>STT</th>
								<th>Tên món ăn</th>
								<th>Name</th>
								<th>Hình ảnh</th>
								<th>Giá</th>
								<th>Số lần đặt</th>
								<th>Loại đồ ăn</th>								
								<th>Thao tác</th>

							</tr>
						</thead>

						<tbody>
							<c:forEach var="monan" items="${monan}" varStatus="status">
								<c:set var="dem" value="${status.index+1}"></c:set>								
								<tr>
									<td>${dem}</td>
									<td>${monan.tenmonan}</td>
									<td>${monan.name}</td>									
									<td><img class="img-responsive"
										src="upload/monan/${monan.hinhanh}" style="width:60px;height:60px;" /></td>
									<fmt:formatNumber var="gia"	type="number" pattern="###,###,###,###" value="${monan.gia}"></fmt:formatNumber>
									
									<td>${gia} VNĐ</td>
									<td>${monan.solandat}</td>
									<td>${monan.loai.tenloaidoan}</td>			
									<td style="text-align: center"> <a href="nhahang/monan/edit/${monan.id}.html"
										style="color: green; padding-left: 30px;">Sửa</a> <a
										href="nhahang/monan/delete/${monan.id}.html"
										onclick="return confirm ('Bạn có thực sự muốn xoá đồ ăn này')"
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