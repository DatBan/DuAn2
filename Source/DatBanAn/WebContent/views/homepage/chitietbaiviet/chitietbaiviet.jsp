<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="/include/headtag.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include> --%>

<div class="container conbv">
	<div class="row">
		<div class="col-md-8">
			<div class="row rbv">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-12">
							<span style="font-size: 28px;"><b>${ctbv.tieude}</b></span>
						</div>
					</div>
					<div class="row">
						<div class="panel">
							<div class="panel-heading">
							<span class="ngaytao-bv">
								<fmt:formatDate value="${ctbv.ngaytao}" pattern="HH:mm dd/MM/yyyy" />
							</span>
							</div>
						</div>
					</div>
					<%-- <div class="row" style="margin-top: 20px; margin-bottom: 20px">
						<div class="col-md-12 ">
							<img class="img-responsive" alt=""
								src="upload/baiviet/${ctbv.hinh}">
						</div>
					</div> --%>
					<div class="row">

						<div class="col-md-12">
							<div class="noi-dung-bv">
								<span>${ctbv.noidung}</span>
							</div>
							<p style="color: #CCCCCC;margin-top: 10px;">
								Ngày viết:
								<fmt:formatDate value="${ctbv.ngaytao}" pattern="dd/MM/yyyy" />
							</p>
						</div>

					</div>
				</div>
			</div>

	<!-- Comment-section -->
	<jsp:include page="comment-section.jsp"></jsp:include>
	</div>
	<script src="js/comments-ctbv.js"></script>
		<!-- Baiviet-Noibat Section -->
		<jsp:include page="bv-noibat.jsp"></jsp:include>

	</div>
</div>
<input type="hidden" id="idbv" value="${ctbv.id}" />
<div class="container bodydexuat">
	<div class="row">
		<div class="col-md-4">

			<span class="giamgia tieudegtctnh">Bài viết liên quan</span>
		</div>
	</div>
	<div class="row">
		<div class=col-md-3>

			<div class="row">
				<a class="linknhgiamgia" href="#"><img class="hinhgiamgia"
					src="images/baochau.png" /></a>
			</div>
			<div class="row text-center giantoptennh">
				<a href="#"><span style="font-size: 16px;"><b>Tiêu đề
							của bài viết liên quan</b></span></a>
			</div>



		</div>
		<div class=col-md-3>
			<div class="row">
				<a href="#"><img class="hinhgiamgia" src="images/thienbao.png" /></a>
			</div>
			<div class="row text-center giantoptennh">
				<a href="#"><span style="font-size: 16px;"><b>Tiêu đề
							của bài viết liên quan</b></span></a>
			</div>


		</div>
		<div class=col-md-3>
			<div class="row">
				<a href="#"><img class="hinhgiamgia" src="images/tinhyeu.png" /></a>
			</div>
			<div class="row text-center giantoptennh">
				<a href="#"><span style="font-size: 16px;"><b>Tiêu đề
							của bài viết liên quan</b></span></a>
			</div>

		</div>
		<div class=col-md-3>
			<div class="row">
				<a href="#"><img class="hinhgiamgia" src="images/phuquoc.png" /></a>
			</div>
			<div class="row text-center giantoptennh">
				<a href="#"><span style="font-size: 16px;"><b>Tiêu đề
							của bài viết liên quan</b></span></a>
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