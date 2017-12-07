<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Nhà Hàng</title>

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
	
	<div class="container ctnh">
		<!-- Phan anh va thong tin nha hang -->
		<jsp:include page="../chitietnhahang/image-info.jsp"></jsp:include>

	</div>
	
	<c:if test="${!empty km}">
	<div class="container conctkm">
		<div class="row">
			<div class="col-md-12">
				<span class="ctkm tieudegtctnh"><b>Chương trình khuyễn mãi</b></span>
			</div>
		</div>
		<c:forEach var="km" items="${km}">	
		<div class="row text-center">
			<div class="col-md-12">
				<img src="images/linekm.png" style="width: 1136px;" />
			</div>
		</div>
			
		<div class="row rkmctnh">
			<div class="col-md-10">
				<span class="ndkmctnh"><b>${km.thongtin}</b></span>
			</div>
			<div class="col-md-2">
				<a href="datban/index/${km.nhahang.id}.html?idkm=${km.id}" type="button" class="btn btn-success btndatngay">
					<b>Đặt Ngay</b>
				</a>
			</div>
		</div>
		</c:forEach>	
	</div>
	</c:if>
	<div class="container gioithieuctnh">
		<div class="row rgtctnh">
			<div class="col-md-2">
				<span class="gtctnh tieudegtctnh"><b>Giới thiệu</b></span>
			</div>
			<%-- <div class="col-md-10">
				<span class="tieudegtctnh"><b>${ctnhahang.tennhahang}</b></span>
			</div> --%>

		</div>
		<div class="row rndgtctnh">
			<div class="col-md-12">
				<span class="ndgtctnh">${ctnhahang.gioithieu}</span>
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
	<jsp:include page="../chitietnhahang/rating_section.jsp"></jsp:include>
	
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
	<jsp:include page="bansethich.jsp"></jsp:include>

	<%-- <jsp:include page="/include/footer.jsp"></jsp:include>
</body>
<script>
var day = moment('2017-11-09 17:06:56.0');
console.log(day.fromNow());
</script>
</html> --%>