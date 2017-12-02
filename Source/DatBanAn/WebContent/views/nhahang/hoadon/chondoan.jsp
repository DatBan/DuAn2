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
		<c:forEach var="t" items="${monan}" varStatus="status">
			<c:set var="dem" value="${status.index+1}"></c:set>

			<tr>
				<td>${dem}</td>
				<td>${t.tenmonan}</td>
				<td><img class="img-responsive" src="upload/monan/${t.hinhanh}"
					style="width: 60px; height: 60px;" /></td>
				<td>${t.loai.tenloaidoan}</td>
				<td><a class="btn btn-success" data-toggle="modal"
					data-target="#addmonan" style="text-align:center;"
					onclick="getthongtinmonan(${t.id},'${t.tenmonan}');">Chọn món</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="line"></div>
<div class="modal fade" id="addmonan" role="dialog">
	<div class="modal-dialog" style="width: 300px;">

		<!-- Modal content-->
		<form action="nhahang/hoadon/themmon.html" method="post">
			<div class="modal-content" style="margin-top: 185px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style="text-align: center;">Thêm món</h4>
				</div>
				<div class="modal-body">
					<div class="row text-center">

						<input name="idhoadonmodal" id="idhoadonmodal"
							style="display: none" value="${hoadon.id}" /> <input
							name="idmonanmodal" id="idmonanmodal" style="display: none" />
						<div class="col-md-12">
							<p><span id="settenmon" style="color:black"></span></p>
						</div>

						<input type="number" class="form-control" name="soluong" value="1"
							style="width: 80px; margin-left: 112px;" />
					</div>

				</div>
				<div class="modal-footer" style="text-align: center;">
					<input type="submit" class="btn btn-success" value="Thêm" />
					<button type="button" class="btn btn-default" data-dismiss="modal">Huỷ</button>
				</div>
			</div>
		</form>
	</div>
</div>
<%-- </div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html> --%>