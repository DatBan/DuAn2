<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Thông tin bàn ăn</title>
<jsp:include page="/include/headtag.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include> --%>
	<div class="container bodydexuat">

		<div class="row rodk">

			<div class="col-sm-12">
				<div class="login-page" style="margin-top: 50px">
					<div class="text-center">
						<div class="login-body">
						<c:choose>
							<c:when test="${loi == null}">
								<div class="col-md-12">

								<ul class="nav nav-tabs">
									<li class="active"><a data-toggle="tab" href="#home">Thông
											tin</a></li>
									<li><a data-toggle="tab" href="#menu1">Menu món ăn</a></li>
									<li><a data-toggle="tab" href="#menu2">Bàn ăn</a></li>

								</ul>

								<div class="tab-content">
									<div id="home" class="tab-pane fade in active">

										<div class="col-md-8">
											<div class="row rregister">
												<div class="form-group fullname-custom">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<label class="control-label  labeld" for="sdt">Mã
															hoá đơn:<span style="color: red;"></span>
														</label> <input type="text" name="idhoadon" value="${hoadon.id}"
															readonly="readonly" placeholder="Mã hoá đơn của bạn"
															class="form-control">
													</div>
												</div>
											</div>
											<div class="row rregister">
												<div class="form-group fullname-custom">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<label class="control-label  labeld" for="sdt">Họ
															tên:<span style="color: red;"></span>
														</label> <input type="text" name="hoten"
															value="${hoadon.ho} ${hoadon.ten}" readonly="readonly"
															class="form-control">
													</div>
												</div>
											</div>
											<div class="row rregister">
												<div class="form-group fullname-custom">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<label class="control-label  labeld" for="sdt">Email:<span
															style="color: red;"></span>
														</label> <input type="text" name="idhoadon"
															value="${hoadon.email}" readonly="readonly"
															class="form-control">
													</div>
												</div>
											</div>
											<div class="row rregister">
												<div class="form-group fullname-custom">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<label class="control-label  labeld" for="sdt">Số
															điện thoại:<span style="color: red;"></span>
														</label> <input type="text" name="idhoadon"
															value="${hoadon.dienthoai}" readonly="readonly"
															class="form-control">
													</div>
												</div>
											</div>
											<div class="row rregister">
												<div class="form-group fullname-custom">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<label class="control-label  labeld" for="sdt">Ngày
															tháng:<span style="color: red;"></span>
														</label> <input type="text" name="idhoadon"
															value="${hoadon.ngaythang}" readonly="readonly"
															class="form-control">
													</div>
												</div>
											</div>
											<div class="row rregister">
												<div class="form-group fullname-custom">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<label class="control-label  labeld" for="sdt">Thời
															gian:<span style="color: red;">*</span>
														</label> <input type="text" name="idhoadon"
															value="${hoadon.thoigian}" readonly="readonly"
															class="form-control">
													</div>
												</div>
											</div>
											<div class="row rregister">
												<div class="form-group fullname-custom">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<label class="control-label  labeld" for="sdt">Nhân
															dịp:<span style="color: red;"></span>
														</label> <input type="text" name="idhoadon"
															value="${hoadon.nhandip}" readonly="readonly"
															class="form-control">
													</div>
												</div>
											</div>

											<div class="row rregister">
												<div class="form-group fullname-custom">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<label class="control-label  labeld" for="sdt">Ghi
															chú:<span style="color: red;">*</span>
														</label>
														<textarea name="ghichu" id="ghichu" placeholder="Không có"
															class="form-control" readonly="readonly"
															style="min-height: 120px; max-height: 120px; min-width: 100%; max-width: 100%;">${hoadon.ghichu}</textarea>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-1"></div>
												<div class="col-md-5 " style="margin-top: 20px;">
													<a class="btn btn-success btn-block" type="submit">Gọi
														món</a>
												</div>
												<div class="col-md-5 " style="margin-top: 20px;">
													<a class="btn btn-danger btn-block" type="submit">Thanh
														toán</a>
												</div>
												<div class="col-md-1"></div>

											</div>

										</div>
										<div class="col-md-4" style="margin-top: 20px;">
											<div class="row dbttkm cdbthongtin">
												<div class="col-md-12">
													<p class="pdatbanttkm">
														<b>Món đã gọi</b><span>(1)</span>
													</p>
													<div class="row">
														<div class="col-md-1">
															<p>2</p>
														</div>
														<div class="col-md-6">
															<p>Trứng dé</p>
														</div>
														<div class="col-md-3">
															<p>6.000đ</p>
														</div>
														<div class="col-md-1">
															<a>Xoá</a>
														</div>
													</div>
													<div class="row">
														<div class="col-md-1">
															<p>2</p>
														</div>
														<div class="col-md-6">
															<p>Trứng dé</p>
														</div>
														<div class="col-md-3">
															<p>6.000đ</p>
														</div>
														<div class="col-md-1">
															<a>Xoá</a>
														</div>
													</div>
													<div class="row "
														style="margin-top: 10px; border-top: 1px solid #d4d4d4;">
														<div class="col-md-6" style="margin-top: 10px;">
															<p>Tổng tiền</p>
														</div>
														<div class="col-md-6" style="margin-top: 10px;">
															<p>500.000đ</p>
														</div>
													</div>
													<div class="row " style="margin-top: 10px;">
														<a class="btn btn-success btn-block" type="submit">Gọi
															món</a>
													</div>
												</div>
											</div>

										</div>

									</div>
									<div id="menu1" class="tab-pane fade">
										<div class="col-md-8">
											<c:forEach var="mon" items="${monan}">
												${mon.tenmonan}
											</c:forEach>
										</div>
										<div class="col-md-4" style="margin-top: 20px;">
											<div class="row dbttkm cdbthongtin">
												<div class="col-md-12">
													<p class="pdatbanttkm">
														<b>Món đã gọi</b><span>(1)</span>
													</p>
													<div class="row">
														<div class="col-md-1">
															<p>2</p>
														</div>
														<div class="col-md-6">
															<p>Trứng dé</p>
														</div>
														<div class="col-md-3">
															<p>6.000đ</p>
														</div>
														<div class="col-md-1">
															<a>Xoá</a>
														</div>
													</div>
													<div class="row">
														<div class="col-md-1">
															<p>2</p>
														</div>
														<div class="col-md-6">
															<p>Trứng dé</p>
														</div>
														<div class="col-md-3">
															<p>6.000đ</p>
														</div>
														<div class="col-md-1">
															<a>Xoá</a>
														</div>
													</div>
													<div class="row "
														style="margin-top: 10px; border-top: 1px solid #d4d4d4;">
														<div class="col-md-6" style="margin-top: 10px;">
															<p>Tổng tiền</p>
														</div>
														<div class="col-md-6" style="margin-top: 10px;">
															<p>500.000đ</p>
														</div>
													</div>
													<div class="row " style="margin-top: 10px;">
														<a class="btn btn-success btn-block" type="submit">Gọi
															món</a>
													</div>
												</div>
											</div>

										</div>
									</div>
									<div id="menu2" class="tab-pane fade">
										<c:if test="${hoadon.banan!=null}">
										<div class="col-md-8">
											<div class="col-md-5"></div>
											<div class="col-md-2 border text-center"
												style="border: 1px solid black; margin-bottom: 60px; margin-top: 30px;">
												<p
													style="border: 1px solid black; margin-top: -10px; background-color: #d3d6d2;">
													Bàn số <span>${hoadon.banan.soban}</span>
												</p>
												<div style="height: 50px; line-height: 50px;">${hoadon.thoigian}</div>
												<div
													style="border-top: 1px solid black; border-right: 1px solid black; border-left: 1px solid black;">${hoadon.banan.songuoi}
													Người</div>
											</div>
											<div class="col-md-1"></div>							

										</div>
										</c:if>
										<c:if test="${hoadon.banan==null}">
										<div class="col-md-8">
											<div class="col-md-3"></div>
											<div class="col-md-6 border text-center"
												style="border: 1px solid black; margin-bottom: 60px; margin-top: 30px;">
												
												<div style="height: 50px; line-height: 50px;">Vui lòng chờ nhà hàng xác nhận!</div>
												
											</div>
											<div class="col-md-1"></div>							

										</div>
										</c:if>
										<div class="col-md-4" style="margin-top: 20px;">
											<div class="row dbttkm cdbthongtin">
												<div class="col-md-12">
													<p class="pdatbanttkm">
														<b>Món đã gọi</b><span>(1)</span>
													</p>
													<div class="row">
														<div class="col-md-1">
															<p>2</p>
														</div>
														<div class="col-md-6">
															<p>Trứng dé</p>
														</div>
														<div class="col-md-3">
															<p>6.000đ</p>
														</div>
														<div class="col-md-1">
															<a>Xoá</a>
														</div>
													</div>
													<div class="row">
														<div class="col-md-1">
															<p>2</p>
														</div>
														<div class="col-md-6">
															<p>Trứng dé</p>
														</div>
														<div class="col-md-3">
															<p>6.000đ</p>
														</div>
														<div class="col-md-1">
															<a>Xoá</a>
														</div>
													</div>
													<div class="row "
														style="margin-top: 10px; border-top: 1px solid #d4d4d4;">
														<div class="col-md-6" style="margin-top: 10px;">
															<p>Tổng tiền</p>
														</div>
														<div class="col-md-6" style="margin-top: 10px;">
															<p>500.000đ</p>
														</div>
													</div>
													<div class="row " style="margin-top: 10px;">
														<a class="btn btn-success btn-block" type="submit">Gọi
															món</a>
													</div>
												</div>
											</div>

										</div>
									</div>

								</div>

							</div>
							</c:when>
							<c:otherwise>
									<span class="text-danger">Hoá đơn không tồn tại</span><br/>
									<a class="btn btn-info" href="#">Quay ve trang chu</a>
							</c:otherwise>	
						</c:choose>
							
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%-- <jsp:include page="/include/footer.jsp"></jsp:include>

</body>
</html> --%>