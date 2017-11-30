<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="/include/headtag.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include>

	<div class="wrap">
		<div class="about">
			<div class="services-sidebar">
				<h4>Nổi bật</h4>
				<ul>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">Quán ăn hà nội</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Món ăn đặc sắc</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Hương vị đặc biệt</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Luôn giữ vị trí dẫn đầu</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Giam giá mỗi ngày</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Phục vụ luôn chu đáo</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Gía cả hợp lý</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Quán ăn giá rẻ HCM</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Địa chỉ luôn được quan tâm</a></li>
				</ul>
				<br>
				<h4>Archives</h4>
				<ul>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">Jan, 2012</a></li>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">Feb, 2012</a></li>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">March, 2012</a></li>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">April, 2012</a></li>
				</ul>
			</div>
			<div class="container">
				<div class="col-md-1"></div>
				<div class="row col-md-10 ">

					<form:form modelAttribute="baiviet">
						<div class="tin">
							<a href="#"><img class="img-responsive"
								style="width: 948px; height: 277px; margin-left: -14px; margin-bottom: 20px;"
								class="col-md-4" alt="" src="files/${baiviet.hinh}"></a> <a
								href="#">

								<h2 style="color: #475b6f">${baiviet.tenbaiviet}</h2>
							</a> <a href="#"><p>${baiviet.noidung}</p></a><br />

							<p style="color: #CCCCCC">
								Ngày viết:
								<fmt:formatDate value="${baiviet.ngayviet}" pattern="dd/MM/yyyy" />
							</p>




						</div>
					</form:form>
					<div class="container col-md-12">
						<style type="text/css">
*[id$=errors] {
	color: red;
	font-style: italic;
}
</style>
						<form:form action="comments.htm" method="post"
							modelAttribute="loi">

							<input type="hidden" name="iduser"
								value="${sessionScope.user.iduser}" />
							<input type="hidden" name="idbaiviet"
								value="${baiviet.idbaiviet}" />
							<form:errors path="noidung" />
							<textarea name="noidung" class="comment"
								placeholder="Write comments..."
								style="-moz-box-sizing: border-box; width: 100%; height: 80px;"></textarea>

							<button type="submit" class="btn btn-info">Bình luận</button>

						</form:form>
						<br>

						<!-- Left-aligned media object -->
						<c:forEach var="bl" items="${baiviet.binhluan}" varStatus="status">

							<c:if test="${bl.binhluancha == null}">
								<input type="hidden" name="iduser"
									value="${sessionScope.user.iduser}" />
								<div class="media">
									<div class="media-left">
										<img src="files/${bl.nguoidung.hinh}" class="media-object"
											style="width: 45px">
									</div>
									<div class="media-body">
										<h4 class="media-heading">
											${bl.nguoidung.hoten} <small><i></i></small>
										</h4>
										<p>${bl.noidung}</p>


										<c:forEach var="blc" items="${ListBLC}">
											<c:if test="${blc.binhluancha.idbinhluan == bl.idbinhluan}">
												<input type="hidden" name="iduser"
													value="${sessionScope.user.iduser}" />
												<!-- con -->
												<div class="media">
													<div class="media-left">
														<img src="files/${blc.user.hinh}" class="media-object"
															style="width: 45px">
													</div>
													<div class="media-body">
														<h4 class="media-heading">
															${blc.nguoidung.hoten} <small><i></i></small>
														</h4>
														<p>${blc.noidung}</p>

													</div>
												</div>
											</c:if>
										</c:forEach>
										<form action="traloi.htm" method="post">
											<input type="hidden" name="iduser"
												value="${sessionScope.nguoidung.id}" /> <input
												type="hidden" name="idbaiviet" value="${baiviet.idbaiviet}" />
											<input type="hidden" name="idbinhluan"
												value="${bl.idbinhluan}" /> <input type="text"
												name="traloi">
											<button class="btn">Trả lời</button>
											<form:errors path="noidung" />
										</form>
									</div>
							</c:if>
						</c:forEach>
						<hr>
					</div>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>