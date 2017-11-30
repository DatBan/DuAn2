<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<jsp:include page="/include/headtag.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include> --%>
	<!-- form tim kiem -->
	<div class="container-full conff">
		<div class="container timkiemm">
			<jsp:include page="/include/form-timkiem.jsp"></jsp:include>
		</div>
	</div>

	<div class="container bodydexuat">
		<div class="row">
			<div class="col-md-4">
				<span class="giamgia">${listsize} kết quả tìm kiếm "${tukhoa}"</span>
			</div>
			<div class="col-md-2 dropdown pull-right">
				<select class="form-control sap-xep-tk">
					<option value="newest">Mới nhất</option>
					<option value="oldest">Cũ nhất</option>
					<option value="popular">Phổ biến nhất</option>
				</select>
			</div>
		</div>
		<div class="row list-timkiem" style="min-height: 106px;" id="list-timkiem">
			<c:forEach var="listf" items="${listnh}">
				<div class="col-md-3">
					<div class="row">
						<a class="linknhgiamgia" href="${listf.id}">
							<img class="hinhgiamgia" src="images/baochau.png" />
						</a>
					</div>
					<div class="row text-center giantoptennh">
						<a href="${listf.id}"><span class="tennhgiamgia">${listf.tennhahang}</span></a>
					</div>
					<div class="row text-center">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<a href="${listf.id}">
								<span class="diachinhgiamgia">
									${listf.diachifull}
								</span>
							</a>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>
			</c:forEach>
		</div>
		<c:if test="${listsize > 8}">
			<hr/>
			<div class="row">
				<div class="col-md-12 text-center linkxemthemgiamgia">
					<a style="cursor: pointer;" id="xem-them-tk"><span class="xemthemgiamgia">Xem Thêm</span></a>
				</div>
			</div>
		</c:if>

	</div>
	<!-- <div class="container bodydexuat">
		<div class="row">
			<div class="col-md-4">

				<span class="giamgia">Nhà hàng liên quan</span>
			</div>
		</div>
		<div class="row">
			<div class=col-md-3>

				<div class="row">
					<a class="linknhgiamgia" href="#"><img class="hinhgiamgia"
						src="images/baochau.png" /></a>
				</div>
				<div class="row text-center giantoptennh">
					<a href="#"><span class="tennhgiamgia">Nhà Hàng Cửu Châu</span></a>
				</div>
				<div class="row text-center">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<a href="#"><span class="diachinhgiamgia">27 Phan Bội
								Châu Buôn Ma Thuột Đăk Lăk</span></a>
					</div>
					<div class="col-md-1"></div>
				</div>


			</div>
			<div class=col-md-3>
				<div class="row">
					<a href="#"><img class="hinhgiamgia" src="images/thienbao.png" /></a>
				</div>
				<div class="row text-center giantoptennh">
					<a href="#"><span class="tennhgiamgia">Nhà Hàng Thiên
							Bảo</span></a>
				</div>
				<div class="row text-center">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<a href="#"><span class="diachinhgiamgia">27 Phan Bội
								Châu Buôn Ma Thuột Đăk Lăk</span></a>
					</div>
					<div class="col-md-1"></div>
				</div>

			</div>
			<div class=col-md-3>
				<div class="row">
					<a href="#"><img class="hinhgiamgia" src="images/tinhyeu.png" /></a>
				</div>
				<div class="row text-center giantoptennh">
					<a href="#"><span class="tennhgiamgia">Nhà Hàng Tình Yêu</span></a>
				</div>
				<div class="row text-center">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<a href="#"><span class="diachinhgiamgia">27 Phan Bội
								Châu Buôn Ma Thuột Đăk Lăk</span></a>
					</div>
					<div class="col-md-1"></div>
				</div>

			</div>
			<div class=col-md-3>
				<div class="row">
					<a href="#"><img class="hinhgiamgia" src="images/phuquoc.png" /></a>
				</div>
				<div class="row text-center giantoptennh">
					<a href="#"><span class="tennhgiamgia">Nhà Hàng Phú Quốc</span></a>
				</div>
				<div class="row text-center">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<a href="#"><span class="diachinhgiamgia">27 Phan Bội
								Châu Buôn Ma Thuột Đăk Lăk</span></a>
					</div>
					<div class="col-md-1"></div>
				</div>

			</div>
		</div>
		<div class="row">

			<div class="col-md-12 text-center linkxemthemgiamgia">
				<a href="#"><span class="xemthemgiamgia">Xem Thêm</span></a>
			</div>

		</div>
	</div> -->

	<%-- <jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html> --%>