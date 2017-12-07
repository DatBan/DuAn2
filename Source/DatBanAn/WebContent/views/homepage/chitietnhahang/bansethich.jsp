<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container bodydexuat">
		<div class="row">
			<div class="col-md-4">

				<span class="giamgia tieudegtctnh">Có thể bạn sẽ thích</span>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${nhlienquan}" var="lq" end="3">
				<c:set var="sluglq" value="${lq.tinhthanh.slug}/${lq.slug}-r${lq.id}.html"/>
				<div class=col-md-3>
	
					<div class="row">
						<a class="linknhgiamgia" href="${sluglq}">
							<img class="hinhgiamgia img-response" src="${lq.photopath}${lq.thumbnail}" />
						</a>
					</div>
					<div class="row text-center giantoptennh">
						<a href="${sluglq}"><span class="tennhgiamgia">${lq.tennhahang}</span></a>
					</div>
					<div class="row text-center">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<a href="${sluglq}"><span class="diachinhgiamgia">${lq.diachifull}</span></a>
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

			</div> -->
		</div>
		<c:if test="${nhlienquan.size() > 4}">
			<div class="row">
				
					<div class="col-md-12 text-center linkxemthemgiamgia">
						<a href="#"><span class="xemthemgiamgia">Xem Thêm</span></a>
					</div>
			</div>
		</c:if>
	</div>