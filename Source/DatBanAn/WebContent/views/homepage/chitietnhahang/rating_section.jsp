<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container danhgia">
	<div class="row ">
		<div class="col-md-12 rtddg">
			<span class="dgnh tieudegtctnh"><b>Đánh giá nhà hàng</b></span>
		</div>
	</div>
	<div class="row mucdg">
		<div class="col-md-5 colsodg">
			<div class="row rmucdg">
				<div class="col-md-1">
					<span class="sodg"><b>5</b></span>
				</div>
				<div class="col-md-10">
					<div class="mucdodg1"></div>
				</div>
			</div>
			<div class="row rmucdg">
				<div class="col-md-1">
					<span class="sodg"><b>4</b></span>
				</div>
				<div class="col-md-10">
					<div class="mucdodg1"></div>
				</div>
			</div>
			<div class="row rmucdg">
				<div class="col-md-1">
					<span class="sodg"><b>3</b></span>
				</div>
				<div class="col-md-10">
					<div class="mucdodg"></div>
				</div>
			</div>
			<div class="row rmucdg">
				<div class="col-md-1">
					<span class="sodg"><b>2</b></span>
				</div>
				<div class="col-md-10">
					<div class="mucdodg"></div>
				</div>
			</div>
			<div class="row rmucdg">
				<div class="col-md-1">
					<span class="sodg"><b>1</b></span>
				</div>
				<div class="col-md-10">
					<div class="mucdodg"></div>
				</div>
			</div>
		</div>
		<div class="col-md-7">
			<div class="row">
				<div class="col-md-6">
					<span class="tddiemdg">${ctnhahang.sumRating} điểm đánh giá</span>
				</div>
			</div>
			<div class="row rsaodg">
				<div class="col-md-3" title='${ctnhahang.sumRating} điểm'>
					<select class="diemdg">
						<option value="1" data-html="good">1</option>
						<option value="2" data-html="better">2</option>
						<option value="3" data-html="best">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</div>
				<div class="col-md-7">
					<c:set var="vbreak" value="#Modaldanhgia"></c:set>
					<c:if test="${sessionScope.tdn == null}">
						<c:set var="vbreak" value="#myModal"></c:set>
					</c:if>
					<button type="button" data-toggle="modal" class="btn btn-warning btnthemdg" data-target="${vbreak}">
						<b>Thêm Đánh Giá</b>
					</button>
				</div>
				<jsp:include page="modal-rating.jsp"></jsp:include>
			</div>
			<div class="row rcldg">
				<div class="col-md-3">
					<span class="ttdg">Đồ ăn</span>
					<br/><span class="sottdg1">${ctnhahang.sumDoAn}</span>
				</div>
				<div class="col-md-3">
					<span class="ttdg">Phục vụ</span>
					<br/><span class="sottdg2">${ctnhahang.sumPhucVu}</span>
				</div>
				<div class="col-md-3">
					<span class="ttdg">Không gian</span>
					<br/><span class="sottdg3">${ctnhahang.sumKhongGian}</span>
				</div>
				<div class="col-md-3">
					<span class="ttdg">Giá cả</span>
					<br/><span class="sottdg4">${ctnhahang.sumGiaCa}</span>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<img src="images/linekm.png"
				style="width: 1137px; height: 1px; opacity: 0.18;" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 dropdown timdg">

			<button class="btn btn-default dropdown-toggle icondt" type="button"
				id="menu1" data-toggle="dropdown">
				Mới nhất <span><img class="img-response "
					src="images/muiten.png" /></span>
			</button>
			<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">Cao nhất</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">Thấp nhất</a></li>

			</ul>
		</div>
	</div>
	<div class="row" id="btn-filter-danhgia">
		<div class="col-md-12">
			<img src="images/linekm.png"
				style="width: 1137px; height: 1px; opacity: 0.18;" />
		</div>
	</div>
	<!-- Danh sach danh gia -->
	<div id="danhsach-dg"></div>
	<div class="row rxtdg">
		<div class="col-md-12 text-center">
			<a style="cursor: pointer;" id="xem-them-dg"><span class="xemthemdg"><i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải</span></a>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	var diemddg = 'asdsad';
	$('.diemdg').barrating('show',{
	theme: 'fontawesome-stars-o',
	initialRating: ${ctnhahang.sumRating}
	}).barrating('readonly', true);
});
</script>