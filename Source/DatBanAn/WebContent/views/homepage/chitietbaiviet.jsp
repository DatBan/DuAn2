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
							<span style="font-size: 16px;"><b>${ctbv.tieude}</b></span>
						</div>
					</div>
					<div class="row" style="margin-top: 20px; margin-bottom: 20px">
						<div class="col-md-12 ">
							<img class="img-responsive" alt=""
								src="upload/baiviet/${ctbv.hinh}">
						</div>
					</div>
					<div class="row">

						<div class="col-md-12">
							<span>${ctbv.noidung}</span>
							<p style="color: #CCCCCC;margin-top: 10px;">
								Ngày viết:
								<fmt:formatDate value="${ctbv.ngaytao}" pattern="dd/MM/yyyy" />
							</p>
						</div>

					</div>
				</div>
			</div>

	<div class="container col-md-12">
				<style type="text/css">
					*[id$=errors] {
						color: red;
						font-style: italic;
					}
					</style>
				<form:form action="comments.htm" method="post" modelAttribute="loi">
				
				<input type="hidden" name="iduser" value="${sessionScope.nd.id}"/>
					<input type="hidden" name="idbaiviet" value="${ctbv.id}" />
					<form:errors path="noidung" />
					<textarea name="noidung" class="comment"
						placeholder="Write comments..."
						style="-moz-box-sizing: border-box; min-width: 100%; min-height: 80px;max-width:100%"></textarea>
						
					<button type="submit" class="btn btn-info">Bình luận</button>
					
				</form:form>
				<br>

				<!-- Left-aligned media object -->
				<c:forEach var="bl" items="${baiviet.binhluan}" varStatus="status">
				
					<c:if test="${bl.binhluancha == null}">
					<input type="hidden" name="iduser" value="${sessionScope.user.iduser}"/>
						<div class="media">
							<div class="media-left">
								<img src="files/${bl.user.hinh}" class="media-object"
									style="width: 45px">
							</div>
							<div class="media-body">
								<h4 class="media-heading">
									${bl.user.hoten} <small><i></i></small>
								</h4>
								<p>${bl.noidung}</p>
								

								<c:forEach var="blc" items="${ListBLC}">
									<c:if test="${blc.binhluancha.idbinhluan == bl.idbinhluan}">
									<input type="hidden" name="iduser" value="${sessionScope.user.iduser}"/>
										<!-- con -->
										<div class="media">
											<div class="media-left">
												<img src="files/${blc.user.hinh}" class="media-object"
													style="width: 45px">
											</div>
											<div class="media-body">
												<h4 class="media-heading">
													${blc.user.hoten} <small><i></i></small>
												</h4>
												<p>${blc.noidung}</p>

											</div>
										</div>
									</c:if>
								</c:forEach>
								<form action="traloi.htm" method="post">
								<input type="hidden" name="iduser" value="${sessionScope.user.iduser}"/>
									<input type="hidden" name="idbaiviet" value="${baiviet.idbaiviet}" />
									<input type="hidden" name="idbinhluan" value="${bl.idbinhluan}" />
									<input type="text" name="traloi">
									<button class="btn">Trả lời</button>
									<form:errors path="noidung" />
								</form>
								<!-- Nested media object -->
								<!-- <div class="media">
						      <div class="media-left">
						        <img src="img_avatar5.png" class="media-object" style="width:45px">
						      </div>
						      <div class="media-body">
						        <h4 class="media-heading">Jane Doe <small><i>Posted on February 19, 2016</i></small></h4>
						        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						      </div>
						    </div> -->
							</div>
						</div>
					</c:if>
				</c:forEach>
				<hr>

				<!-- Right-aligned media object -->
			</div>


		</div>

		<div class="col-md-4">

			<div class="row text-center rbv">
				<p style="font-size: 20px;">
					<b>Bài viết nổi bật</b>
				</p>
			</div>

			<c:forEach var="bv" items="${bv}">
				<div class="row rbv">
					<div class="col-md-5">
						<a href="chitietbaiviet.html?idbv=${bv.id}"><img
							class="img-responsive" alt="" src="upload/baiviet/${bv.hinh}"></a>
					</div>

					<div class="col-md-7">
						<div class="row" style="margin-bottom: 10px;">
							<a href="chitietbaiviet.html?idbv=${bv.id}"><span>${fn:substring(bv.tieude,0,80)}...</span></a>

						</div>


					</div>

				</div>
				<div class="row">
					<img src="images/linekm.png"
						style="width: 99%; padding-left: 15px; opacity: 0.1;" />
				</div>

			</c:forEach>

		</div>

	</div>
</div>
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