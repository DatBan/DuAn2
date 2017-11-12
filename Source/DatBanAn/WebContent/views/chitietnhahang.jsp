<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Nhà Hàng</title>

<jsp:include page="/include/headtag.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include>
	<!-- form tim kiem -->
	<div class="container-full conff">
		<div class="container timkiemm">
			<jsp:include page="/include/form-timkiem.jsp"></jsp:include>
		</div>
	</div>
	
	<div class="container ctnh">
<<<<<<< HEAD
		<div class="row ">
			<div class="col-md-6">
				<img class="imgctnh" src="images/ctnh.png" />
			</div>
			<div class="col-md-6">
				<div class="row dckhuvuc">
					<div class="col-md-12">
						<span class="dckv"><b>Hồ Chí Minh</b></span> <img
							src="images/muitendc.png" /> <span class="dckv"><b>Quận
								1</b></span>
					</div>
				</div>
				<div class="row rtenctnh">
					<div class="col-md-12">
						<span class="tenctnh"><b>Sushi Dining AOI - Món Nhật</b></span>
					</div>
				</div>
				<div class="row rdcctnh">
					<div class="col-md-12">
						<span class="dcctnh">53 - 55 Bà Huyện Thanh Quan, P.6, Quận
							1, TP.HCM</span>
					</div>
				</div>
				
				<div class="row rdatcho">
					<div class="col-md-12">
					
						<a href="datban/index/1.html" type="button" class="btn btn-warning btndatchongay">
							<b>Đặt Chỗ Ngay</b>
						</a>
					</div>
				</div>
				<div class="row saodanhgia">
					<div class="col-md-6">
						<img src="images/saoday.png" /> <img src="images/saoday.png" />
						<img src="images/saoday.png" /> <img src="images/saoday.png" />
						<img src="images/saorong.png" />
					</div>
					<div class="col-md-2">
						<span class="diemdg"><b>8.2</b></span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-1">
						<img src="images/dhctnh.png" />
					</div>
					<div class="col-md-11">
						<p class="dangmocua" style="float: left;">
							<b>Đang mở cửa : </b>
						</p>
						<span style="float: left;"><b>10:00 AM - 22:00 PM</b></span>
					</div>
				</div>
				<div class="row giatbctnh">
					<div class="col-md-1">
						<img src="images/giactnh.png" />
					</div>
					<div class="col-md-11">
						<p class="giatb" style="float: left;">
							<b>Giá trung bình : </b>
						</p>
						<span style="float: left;"><b>200.000</b></span><b>đ - </b><span><b>400.000</b></span><span><b>đ</b></span>
					</div>
				</div>
				<div class="row lhctnh">
					<div class="col-md-1">
						<img src="images/dtctnh.png" />
					</div>
					<div class="col-md-11">
						<p class="lh" style="float: left;">
							<b>Liên hệ : </b>
						</p>
						<span style="float: left;"><b>0978654545</b></span>
					</div>
				</div>
			</div>
		</div>
=======
		<!-- Phan anh va thong tin nha hang -->
		<jsp:include page="homepage/chitietnhahang/image-info.jsp"></jsp:include>
>>>>>>> 3928a159232d22fc6d8e6cc3962341b88d567f96

	</div>
	<div class="container conctkm">
		<div class="row">
			<div class="col-md-12">
				<span class="ctkm tieudegtctnh"><b>Chương trình khuyễn mãi</b></span>
			</div>
		</div>
		<div class="row text-center">
			<div class="col-md-12">
				<img src="images/linekm.png" style="width: 1136px;" />
			</div>
		</div>
		<div class="row rkmctnh">
			<div class="col-md-10">
				<span class="ndkmctnh"><b>Cả ngày - Giảm 20% cho các hoá
						đơn có tổng tiền trên 800 nghìn đồng </b></span>
			</div>
			<div class="col-md-2">
				<button class="btn btn-success btndatngay">
					<b>Đặt Ngay</b>
				</button>
			</div>
		</div>
	</div>
	<div class="container gioithieuctnh">
		<div class="row rgtctnh">
			<div class="col-md-2">
				<span class="gtctnh tieudegtctnh"><b>Giới thiệu :</b></span>
			</div>
			<div class="col-md-10">
				<span class="tieudegtctnh"><b> GIỚI THIỆU SUSHI DINING
						AOI - MÓN NHẬT</b></span>
			</div>

		</div>
		<div class="row rndgtctnh">
			<div class="col-md-12">
				<span class="ndgtctnh">Theo Feng Jianghua, kỹ sư trưởng chế
					tạo tàu, hệ thống đường ray ảo có chi phí xây dựng rẻ hơn so với
					đường ray tàu hỏa hoặc hệ thống tàu điện ngầm. Feng cho biết chi
					phí xây một kilomet đường ray tàu hỏa ở Trung Quốc là 22 – 30 triệu
					USD, nhưng với đường ray ảo công nghệ cao, chi phí giảm xuống 7,5 –
					15 triệu USD cho cùng quãng đường. Đoàn tàu có thể nhận biết lề
					đường và trang bị nhiều cảm biến khác nhau để thu thập thông tin
					giao thông. Ba đoàn tàu thông minh đang được thử nghiệm trên đường
					phố Chu Châu. Đường tàu sẽ chính thức đi vào hoạt động trong mùa
					xuân năm sau. Theo dự kiến, tàu sẽ chuyển sang vận hành tự động
					trong tương lai gần.</span>
			</div>
		</div>
	</div>
	<div class="container cmonan">
		<div class="row">
			<div class="col-md-12">
				<span class="monan tieudegtctnh"><b>Món Ăn</b></span>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="row">
					<img src="images/linekm.png"
						style="width: 572px; height: 1px; padding-left: 15px;" />
				</div>
				<div class="row ndmonan">
					<div class="col-md-3">
						<img src="images/monan.png" />
					</div>
					<div class="col-md-5 tenmonan">
						<span class="giamonan">Bánh Mì</span>
					</div>
					<div class="col-md-4 gmonan">
						<p class="giamonan">
							200.000<span class="giamonan">đ</span>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row">
					<img src="images/linekm.png"
						style="width: 572px; height: 1px; padding-left: 15px;" />
				</div>
				<div class="row ndmonan">
					<div class="col-md-3">
						<img src="images/monan.png" />
					</div>
					<div class="col-md-5 tenmonan">
						<span class="giamonan">Bánh Mì</span>
					</div>
					<div class="col-md-4 gmonan">
						<p class="giamonan">
							200.000<span class="giamonan">đ</span>
						</p>
					</div>
				</div>
			</div>


		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="row">
					<img src="images/linekm.png"
						style="width: 572px; height: 1px; padding-left: 15px;" />
				</div>
				<div class="row ndmonan">
					<div class="col-md-3">
						<img src="images/monan.png" />
					</div>
					<div class="col-md-5 tenmonan">
						<span class="giamonan">Bánh Mì</span>
					</div>
					<div class="col-md-4 gmonan">
						<p class="giamonan">
							200.000<span class="giamonan">đ</span>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row">
					<img src="images/linekm.png"
						style="width: 572px; height: 1px; padding-left: 15px;" />
				</div>
				<div class="row ndmonan">
					<div class="col-md-3">
						<img src="images/monan.png" />
					</div>
					<div class="col-md-5 tenmonan">
						<span class="giamonan">Bánh Mì</span>
					</div>
					<div class="col-md-4 gmonan">
						<p class="giamonan">
							200.000<span class="giamonan">đ</span>
						</p>
					</div>
				</div>
			</div>


		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="row">
					<img src="images/linekm.png"
						style="width: 572px; height: 1px; padding-left: 15px;" />
				</div>
				<div class="row ndmonan">
					<div class="col-md-3">
						<img src="images/monan.png" />
					</div>
					<div class="col-md-5 tenmonan">
						<span class="giamonan">Bánh Mì</span>
					</div>
					<div class="col-md-4 gmonan">
						<p class="giamonan">
							200.000<span class="giamonan">đ</span>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row">
					<img src="images/linekm.png"
						style="width: 572px; height: 1px; padding-left: 15px;" />
				</div>
				<div class="row ndmonan">
					<div class="col-md-3">
						<img src="images/monan.png" />
					</div>
					<div class="col-md-5 tenmonan">
						<span class="giamonan">Bánh Mì</span>
					</div>
					<div class="col-md-4 gmonan">
						<p class="giamonan">
							200.000<span class="giamonan">đ</span>
						</p>
					</div>
				</div>
			</div>


		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="row">
					<img src="images/linekm.png"
						style="width: 572px; height: 1px; padding-left: 15px;" />
				</div>
				<div class="row ndmonan">
					<div class="col-md-3">
						<img src="images/monan.png" />
					</div>
					<div class="col-md-5 tenmonan">
						<span class="giamonan">Bánh Mì</span>
					</div>
					<div class="col-md-4 gmonan">
						<p class="giamonan">
							200.000<span class="giamonan">đ</span>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row">
					<img src="images/linekm.png"
						style="width: 572px; height: 1px; padding-left: 15px;" />
				</div>
				<div class="row ndmonan">
					<div class="col-md-3">
						<img src="images/monan.png" />
					</div>
					<div class="col-md-5 tenmonan">
						<span class="giamonan">Bánh Mì</span>
					</div>
					<div class="col-md-4 gmonan">
						<p class="giamonan">
							200.000<span class="giamonan">đ</span>
						</p>
					</div>
				</div>
			</div>


		</div>

		<div class="row">
			<div class="col-md-12 text-center coxtmonan">
				<a href="#"><span class="xemthemdg">Xem Thêm</span></a>
			</div>
		</div>
	</div>
	<div class="container bodyhinhanh">
		<div class="row">
			<div class="col-md-4">

				<span class="giamgia tieudegtctnh"><b>Hinh Ảnh</b></span>
			</div>
		</div>
		<div class="row">
			<div class=col-md-3>

				<div class="row">
					<img class="hinhgiamgia" src="images/baochau.png" />
				</div>
			</div>
			<div class=col-md-3>
				<div class="row">
					<img class="hinhgiamgia" src="images/thienbao.png" />
				</div>
			</div>
			<div class=col-md-3>
				<div class="row">
					<img class="hinhgiamgia" src="images/tinhyeu.png" />
				</div>
			</div>
			<div class=col-md-3>
				<div class="row">
					<img class="hinhgiamgia" src="images/phuquoc.png" />
				</div>

			</div>
		</div>
		<div class="row rhinh">
			<div class=col-md-3>

				<div class="row">
					<img class="hinhgiamgia" src="images/baochau.png" />
				</div>
			</div>
			<div class=col-md-3>
				<div class="row">
					<img class="hinhgiamgia" src="images/thienbao.png" />
				</div>
			</div>
			<div class=col-md-3>
				<div class="row">
					<img class="hinhgiamgia" src="images/tinhyeu.png" />
				</div>
			</div>
			<div class=col-md-3>
				<div class="row">
					<img class="hinhgiamgia" src="images/phuquoc.png" />
				</div>

			</div>
		</div>
		<div class="row">

			<div class="col-md-12 text-center linkxemthemgiamgia">
				<a href="#"><span class="xemthemdg">Xem Thêm</span></a>
			</div>

		</div>

	</div>
	<!-- Phan danh gia nha hang -->
	<jsp:include page="homepage/chitietnhahang/rating_section.jsp"></jsp:include>
	
	<div class="container bando">
		<div class="row">
			<div class="col-md-12">
				<span class="bandoctnh tieudegtctnh"><b>Bản đồ</b></span>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 cobd">
				<img src="images/bando.png" style="width: 100%;" />
			</div>

		</div>
	</div>
	<div class="container uudiem">

		<div class="row">
			<div class="col-md-4">
				<span class="giamgia tieudegtctnh">Ưu điểm</span>
			</div>
		</div>
		<div class="container nduudiem">
			<div class="row">
				<div class="col-md-12">
					<img src="images/linekm.png"
						style="width: 1108px; height: 1px; opacity: 0.18;" />
				</div>
			</div>
			<div class="row ud">
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<img src="images/oto.png" />
				</div>
				<div class="col-md-9">
					<span class="tenuudiem">Bãi đậu xe ô tô</span>
				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<img src="images/linekm.png"
						style="width: 1108px; height: 1px; opacity: 0.18;" />
				</div>
			</div>
			<div class="row ud">
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<img src="images/xemay.png" />
				</div>
				<div class="col-md-9">
					<span class="tenuudiem">Bãi đậu xe máy</span>
				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<img src="images/linekm.png"
						style="width: 1108px; height: 1px; opacity: 0.18;" />
				</div>
			</div>
			<div class="row ud">
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<img src="images/wifi.png" />
				</div>
				<div class="col-md-9">
					<span class="tenuudiem">WiFi</span>
				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<img src="images/linekm.png"
						style="width: 1108px; height: 1px; opacity: 0.18;" />
				</div>
			</div>
			<div class="row ud">
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<img src="images/nhatang.png" />
				</div>
				<div class="col-md-9">
					<span class="tenuudiem">4 Tầng</span>
				</div>

			</div>
		</div>
	</div>
	<div class="container bodydexuat">
		<div class="row">
			<div class="col-md-4">

				<span class="giamgia tieudegtctnh">Có thể bạn sẽ thích</span>
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

	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
<script>
var day = moment('2017-11-09 17:06:56.0');
console.log(day.fromNow());
</script>
</html>