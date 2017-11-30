<%@ page pageEncoding="utf-8"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Trang chu</title>
<jsp:include page="/include/headtag.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include> --%>
	<!-- form tim kiem -->
	<div class="container-full conf">
		<div class="container timkiem">
			<div class="row">
				<div class="col-md-12 text-center">			
					<span class="dbmp"><b>ĐẶT BÀN MIỄN PHÍ</b></span>
				</div>		
			</div>
			<jsp:include page="/include/form-timkiem.jsp"></jsp:include>
		</div>
	</div>
	<div class="container bodygiamgia">
		<div class="row">
			<div class="col-md-3">
				<img src="images/icongiamgia.png" style="margin-top: -22px;" /> <span
					class="giamgia">Giảm giá</span>
			</div>
		</div>
		<div class="row">
			<div class=col-md-3>

				<div class="row">
					<a class="linknhgiamgia" href="chitietnhahang.html"><img
						class="hinhgiamgia" src="images/baochau.png" /></a>
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
				<div class="row text-center">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<a href="#"><span class="ndgiamgia">Giảm 10 % cho đơn
								300k trở lên</span></a>
					</div>
					<div class="col-md-1"></div>

				</div>

			</div>
			<div class=col-md-3>
				<div class="row">
					<a href="chitietnhahang.html"><img class="hinhgiamgia"
						src="images/thienbao.png" /></a>
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
				<div class="row text-center">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<a href="#"><span class="ndgiamgia">Giảm 10 % cho đơn
								300k trở lên</span></a>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
			<div class=col-md-3>
				<div class="row">
					<a href="chitietnhahang.html"><img class="hinhgiamgia"
						src="images/tinhyeu.png" /></a>
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
				<div class="row text-center">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<a href="#"><span class="ndgiamgia">Giảm 10 % cho đơn
								300k trở lên</span></a>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
			<div class=col-md-3>
				<div class="row">
					<a href="chitietnhahang.html"><img class="hinhgiamgia"
						src="images/phuquoc.png" /></a>
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
				<div class="row text-center">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<a href="#"><span class="ndgiamgia">Giảm 10 % cho đơn
								300k trở lên</span></a>
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

	</div>
	<div class="container slide">
		<div class="row text-center monanth">
			<span class="math">Món Ăn Thịnh Hành</span>
		</div>
		<div class="row rslide">
			<div class="container">

				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="images/slide.png" alt="Rau củ" style="width: 100%;">
						</div>

						<div class="item">
							<img src="images/slide.png" alt="Rau củ" style="width: 100%;">
						</div>

						<div class="item">
							<img src="images/slide.png" alt="Rau củ" style="width: 100%;">
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span><img
							src="images/traislide.png" style="padding-top: 180px;" /></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span><img
							src="images/phaislide.png" style="padding-top: 180px;" /></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container bodydexuat">
		<div class="row">
			<div class="col-md-4">
				<img src="images/dexuat.png" style="margin-top: -22px;" /> <span
					class="giamgia">Đề xuất cho bạn</span>
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

	</div>
	<div class="container bodydexuat">
		<div class="row">
			<div class="col-md-4">
				<img src="images/diadiem.png" style="margin-top: -22px;" /> <span
					class="giamgia">Địa điểm nổi bật</span>
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

	</div>
	<%-- <jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html> --%>