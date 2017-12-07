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
				<jsp:include page="/include-dashboard/header-hoadon.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe"> --%>

<table id="example" class="table table-striped table-bordered">

	<thead>
		<tr>
			<th>STT</th>
			<th>Họ tên</th>
			<th>Bàn số</th>

			<th>Thời gian</th>
			<th>Thêm món ăn</th>
			<th>Món đã gọi</th>
			<th>Thanh toán</th>
			<th>Thao tác</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="t" items="${hoadon}" varStatus="status">
			<c:set var="dem" value="${status.index+1}"></c:set>

			<fmt:formatDate var="tg" value="${t.ngaythang}" pattern="dd-MM-yyyy" />
			<tr>
				<td>${dem}</td>
				<td>${t.ho}${t.ten}</td>
				<c:if test="${t.banan.soban!=null}">

					<td>${t.banan.soban}</td>
				</c:if>
				<c:if test="${t.banan.soban==null}">
					<td><a href="nhahang/hoadon/chonban.html?idhd=${t.id}"
						style="color: green;">Chọn bàn</a></td>
				</c:if>
				<td>${t.thoigian}</td>
				<c:choose>
						<c:when test="${t.banan.soban!=null}">
				<c:if test="${t.trangthai != 5}">
				<td><a href="nhahang/hoadon/chondoan.html?idhd=${t.id}"
					style="color: green;">Thêm</a></td>
				<td><a href="nhahang/hoadon/xemdanhsach.html?idhd=${t.id}"
					style="color: green;">Xem</a></td>
				</c:if>
				</c:when>
						<c:otherwise>
						<td></td>
						<td></td>
						</c:otherwise>
					</c:choose>
				<c:set var="tongtien" value="0"></c:set>
				<c:forEach var="cthd" items="${t.listcthd}">
					<c:if test="${cthd.trangthai==1}">
							<c:set var="tongtien" value="${tongtien + cthd.monan.gia}"></c:set>
						</c:if>
				</c:forEach>
				<c:set var="km" value="${t.khuyenmai.thongtin}"></c:set>
				<fmt:formatNumber var="tien" type="number" pattern="###,###,###,###"
					value="${tongtien}"></fmt:formatNumber>
				<c:if test="${t.trangthai==2}">

					<c:choose>
						<c:when test="${tongtien != 0 }">
							<td style="text-align: center;"><a data-toggle="modal"
								data-target="#mothanhtoan" class="btn btn-success" type="button"
								onclick="getthongtinhoadon(${t.id},'${t.banan.soban}','${tien} đ','${km}');">Thanh
									toán</a></td>
						</c:when>
						<c:otherwise>
						<td></td>
						</c:otherwise>
					</c:choose>
				</c:if>


				<td style="text-align: center"><a
					href="nhahang/hoadon/edit/${t.id}.html" style="color: green;">Sửa</a>
					<a href="nhahang/hoadon/delete/${t.id}.html"
					onclick="return confirm ('Bạn có thực sự muốn xoá đơn này')"
					style="color: red; padding-left: 30px;">Xoá</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="line"></div>
<div class="modal fade" id="mothanhtoan" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<form action="datban/hoadonthanhtoan.html" method="post">
			<div class="modal-content" style="margin-top: 77px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style="text-align: center;">Thanh toán</h4>
				</div>
				<div class="modal-body">
					<div class="row ">

						<div class="col-md-12" style="margin-bottom: 15px;">
							<label class="control-label  labeld" for="td">Mã hoá đơn:<span
								style="color: red;"></span>
							</label> <input type="text" name="mahd" id="mahd" value=""
								readonly="readonly" class="form-control">
						</div>
						<div class="col-md-12" style="margin-bottom: 15px;">
							<label class="control-label  labeld" for="td">Số bàn:<span
								style="color: red;"></span>
							</label> <input type="text" name="soban" id="soban" value=""
								readonly="readonly" class="form-control">
						</div>
						<div class="col-md-12" style="margin-bottom: 15px;">
							<label class="control-label  labeld" for="td">Tổng tiền:<span
								style="color: red;"></span>
							</label> <input type="text" name="tongtien" id="tongtien" value=""
								readonly="readonly" class="form-control">
						</div>
						<div class="col-md-12" style="margin-bottom: 15px;">
							<label class="control-label  labeld" for="td">Khuyến mãi:<span
								style="color: red;"></span>
							</label> <input type="text" name="khuyenmai" id="khuyenmai" value=""
								readonly="readonly" placeholder="Không có khuyến mãi"
								class="form-control">
						</div>

					</div>

				</div>
				<div class="modal-footer" style="text-align: center;">
					<input type="submit" class="btn btn-success" value="Thanh toán" />
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