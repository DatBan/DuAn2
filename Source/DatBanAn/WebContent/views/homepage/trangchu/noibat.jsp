<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="row">
	<c:forEach items="${best_book}" var="noibat" end="3">
		<div class=col-md-3>
	
			<div class="row">
				<a class="linknhgiamgia" href="#"><img class="hinhgiamgia" src="images/baochau.png" /></a>
			</div>
			<div class="row text-center giantoptennh">
				<a href="#"><span class="tennhgiamgia">${noibat.tennhahang}</span></a>
			</div>
			<div class="row text-center">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<a href="#"><span class="diachinhgiamgia">${noibat.diachifull}</span></a>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</c:forEach>
	<!-- <div class=col-md-3>
		<div class="row">
			<a href="#"><img class="hinhgiamgia" src="images/thienbao.png" /></a>
		</div>
		<div class="row text-center giantoptennh">
			<a href="#"><span class="tennhgiamgia">Nhà Hàng Thiên Bảo</span></a>
		</div>
		<div class="row text-center">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<a href="#"><span class="diachinhgiamgia">27 Phan Bội Châu Buôn Ma Thuột Đăk Lăk</span></a>
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
				<a href="#"><span class="diachinhgiamgia">27 Phan Bội Châu Buôn Ma Thuột Đăk Lăk</span></a>
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
				<a href="#"><span class="diachinhgiamgia">27 Phan Bội Châu Buôn Ma Thuột Đăk Lăk</span></a>
			</div>
			<div class="col-md-1"></div>
		</div>

	</div> -->
</div>
<div class="row">

	<div class="col-md-12 text-center linkxemthemgiamgia">
		<a href="#"><span class="xemthemgiamgia">Xem Thêm</span></a>
	</div>

</div>