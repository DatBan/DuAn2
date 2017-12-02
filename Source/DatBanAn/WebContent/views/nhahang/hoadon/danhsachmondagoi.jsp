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
				<jsp:include page="/include-dashboard/header-hoadon-xacnhan.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe"> --%>

<table id="example" class="table table-striped table-bordered">

	<thead>
		<tr>
			<th>STT</th>
			<th>Tên món</th>
			<th>Hình</th>
			<th>Loại đồ ăn</th>
			<th>Thao tác</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="t" items="${cthd}" varStatus="status">
			<c:set var="dem" value="${status.index+1}"></c:set>

			<tr>
				<td>${dem}</td>
				<td>${t.monan.tenmonan}</td>
				<td><img class="img-responsive"
					src="upload/monan/${t.monan.hinhanh}"
					style="width: 60px; height: 60px;" /></td>
				<td>${t.monan.loai.tenloaidoan}</td>
				<td><a
					href="nhahang/hoadon/deletemon/${t.id}.html?idhoadon=${t.hoadon.id}"
					onclick="return confirm ('Bạn có thực sự muốn xoá món này')" style="color: red; padding-left: 90px;">Xoá</a>
				</td>
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