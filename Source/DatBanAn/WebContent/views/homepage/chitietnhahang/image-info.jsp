<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="row ">
	<div class="col-md-6">
		<img class="img-response" src="${ctnhahang.photopath}${ctnhahang.thumbnail}" width="100%"/>
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
				<span class="tenctnh"><b>${ctnhahang.tennhahang} - Món
						Nhật</b></span>
			</div>
		</div>
		<div class="row rdcctnh">
			<div class="col-md-12">
				<span class="dcctnh">${ctnhahang.diachifull}</span>
			</div>
		</div>
		<c:choose>
		<c:when test="${!empty km}">
			<c:forEach var="km" items="${km}" end="0">
				<div class="row rdatcho">
					<div class="col-md-12">
						<a href="datban/index/${km.nhahang.id}.html?idkm=${km.id}"
							type="button" class="btn btn-warning btndatchongay"> <b>Đặt
								Chỗ Ngay</b>
						</a>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="row rdatcho">
				<div class="col-md-12">
					<a href="datban/index1/${ctnhahang.id}.html" type="button"
						class="btn btn-warning btndatchongay"> <b>Đặt Chỗ Ngay</b>
					</a>
				</div>
			</div>
			
		</c:otherwise>
		</c:choose>
		
		<div class="row saodanhgia">
			<div class="col-md-3" title="${ctnhahang.sumRating} điểm">
				<select class="diemdg">
					<option value=""></option>
					<option value="1" data-html="good">1</option>
					<option value="2" data-html="better">2</option>
					<option value="3" data-html="best">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</div>
			<div class="col-md-3">
				<span class="">${ctnhahang.sumRating} /
					${ctnhahang.countRating} đánh giá</span>
			</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				<img src="images/dhctnh.png" />
			</div>
			<div class="col-md-11">
				<span class="dangmocua" style="float: left;"> 
					<b>Đang mở cửa: </b> &nbsp;
				</span> 
				<span style="float: left;"> <b>${ctnhahang.giomocua} AM
						- ${ctnhahang.giodongcua} PM</b>
				</span>
			</div>
		</div>
		<div class="row giatbctnh">
			<div class="col-md-1">
				<img src="images/giactnh.png" />
			</div>
			<div class="col-md-11">
				<p class="giatb" style="float: left;">
					<b>Giá trung bình: </b>
				</p>
				<span style="float: left;">&nbsp; <b>200.000</b></span><b>đ - </b><span><b>400.000</b></span><span><b>đ</b></span>
			</div>
		</div>
		<div class="row lhctnh">
			<div class="col-md-1">
				<img src="images/dtctnh.png" />
			</div>
			<div class="col-md-11">
				<p class="lh" style="float: left;">
					<b>Liên hệ: </b>
				</p>
				<span style="float: left;">&nbsp; <b> ${ctnhahang.sdt}</b></span>
			</div>
		</div>
	</div>
</div>