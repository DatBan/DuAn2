<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container danhgia">
	<div class="row ">
		<div class="col-md-12 rtddg">
			<span class="dgnh tieudegtctnh"><b>Đánh giá nhà hàng ${ctnhahang.id}</b></span>
		</div>
	</div>
	<div class="row mucdg">
		<div class="col-md-3 colsodg">
			<div class="barChart">
				<div class="barChart__row" data-value="${ctnhahang.countRating}" style="display: none;">
				    <span class="barChart__label">5 <i class="fa fa-star"></i></span>
				    <span class="barChart__value">${ctnhahang.countRating}</span>
				    <span class="barChart__bar"><span class="barChart__barFill"></span></span>
			  	</div>
			  <div class="barChart__row" data-value="${ctnhahang.count5}">
			    <span class="barChart__label">5 <i class="fa fa-star"></i></span>
			    <span class="barChart__value">${ctnhahang.count5}</span>
			    <span class="barChart__bar"><span class="barChart__barFill"></span></span>
			  </div>
			  <div class="barChart__row" data-value="${ctnhahang.count4}">
			    <span class="barChart__label">4 <i class="fa fa-star"></i></span>
			    <span class="barChart__value">${ctnhahang.count4}</span>
			    <span class="barChart__bar"><span class="barChart__barFill"></span></span>
			  </div>
			  
			  <div class="barChart__row" data-value="${ctnhahang.count3}">
			    <span class="barChart__label">3 <i class="fa fa-star"></i></span>
			    <span class="barChart__value">${ctnhahang.count3}</span>
			    <span class="barChart__bar"><span class="barChart__barFill"></span></span>
			  </div>
			  
			  <div class="barChart__row" data-value="${ctnhahang.count2}">
			    <span class="barChart__label">2 <i class="fa fa-star"></i></span>
			    <span class="barChart__value">${ctnhahang.count2}</span>
			    <span class="barChart__bar"><span class="barChart__barFill"></span></span>
			  </div>
			  
			  <div class="barChart__row" data-value="${ctnhahang.count1}">
			    <span class="barChart__label">1 <i class="fa fa-star"></i></span>
			    <span class="barChart__value">${ctnhahang.count1}</span>
			    <span class="barChart__bar"><span class="barChart__barFill"></span></span>
			  </div>
			</div>
		</div>
		<div class="col-md-7">
			<div class="row">
				<div class="col-md-2">
					<span style="font-size: 43px;">${ctnhahang.sumRating}</span>
				</div>
				<div class="col-md-3">
					<div class="row">
						<div class="col-md-12">
							<span class="tddiemdg">${ctnhahang.countRating} đánh giá</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3" title='${ctnhahang.sumRating} điểm'>
							<select class="diemdg">
								<option value=""></option>
								<option value="1" data-html="good">1</option>
								<option value="2" data-html="better">2</option>
								<option value="3" data-html="best">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
						</div>
				</div>
				<div class="col-md-3" style="padding: 5px;">
					<div class="row">
						<div class="col-md-12">
							<c:set var="vbreak" value="#Modaldanhgia"></c:set>
							<c:if test="${sessionScope.nd == null}">
								<c:set var="vbreak" value="#myModal"></c:set>
							</c:if>
							<button type="button" data-toggle="modal" class="btn btn-warning btnthemdg" data-target="${vbreak}">
								<b>Viết Đánh Giá</b>
							</button>
						</div>
					</div>
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
	<hr style="border-color: #ddd;"/>
	<div class="row">
		<div class="col-md-2 dropdown timdg">
			<select class="form-control sap-xep">
				<option value="newest">Mới nhất</option>
				<option value="oldest">Cũ nhất</option>
				<option value="popular">Phổ biến nhất</option>
			</select>
		</div>
	</div>
	<div class="row" id="btn-filter-danhgia">
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
	$('.barChart').barChart();
	var diemddg = 'asdsad';
	$('.diemdg').barrating('show',{
	theme: 'fontawesome-stars-o',
	initialRating: ${ctnhahang.sumRating}
	}).barrating('readonly', true);
});
</script>