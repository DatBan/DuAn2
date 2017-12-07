<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
							<c:when test="${hoadon != null}">
								<div class="col-md-12">

									<ul class="nav nav-tabs">
										<li id="lithongtin" class="active"><a data-toggle="tab"
											href="#home">Thông tin</a></li>
										<li id="limenumonan"><a data-toggle="tab" href="#menu1">Menu
												món ăn</a></li>
										<li id="libanan"><a data-toggle="tab" href="#menu2">Bàn
												ăn</a></li>

									</ul>
									<input id="koxoadc" hidden="hidden" value="${koxoadc}"/>
									<input id="ycthanhtoan" hidden="hidden" value="${ycthanhtoan}"/>
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
															<textarea name="ghichu" id="ghichu"
																placeholder="Không có" class="form-control"
																readonly="readonly"
																style="min-height: 120px; max-height: 120px; min-width: 100%; max-width: 100%;">${hoadon.ghichu}</textarea>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-1"></div>
													<div class="col-md-5 " style="margin-top: 20px;">
														<!-- ffs -->
														<a onclick="setactive();" data-toggle="tab" href="#menu1"
															class="btn btn-success btn-block" type="submit">Gọi
															món</a>
													</div>
													<div class="col-md-5 " style="margin-top: 20px;">
														<c:if test="${hoadon.trangthai==2 }">
														<a href="datban/yeucauthanhtoan/${hoadon.id}.html" class="btn btn-danger btn-block" type="submit">Thanh
															toán</a>
															</c:if>
													</div>
													<div class="col-md-1"></div>

												</div>

											</div>
											<div class="col-md-4" style="margin-top: 20px;">
												<div class="row dbttkm cdbthongtin">
													<div class="col-md-12">
														<p class="pdatbanttkm">
															<b>Món đã gọi </b><span> ( ${cthd.size()} )</span>
														</p>
														<c:forEach var="c" items="${cthd}" varStatus="status">
															<c:set var="dem" value="${status.index+1}"></c:set>
															<div class="row">
																<div class="col-md-1">
																	<p>${dem}</p>
																</div>
																<div class="col-md-6">
																	<p>${c.monan.tenmonan}</p>
																</div>
																<div class="col-md-3">
																	<fmt:formatNumber var="gia" type="number"
																		pattern="###,###,###,###" value="${c.monan.gia}"></fmt:formatNumber>
																	<p>${gia}đ</p>
																</div>
																<div class="col-md-1">
																	<c:if test="${c.trangthai==0}">
																		<a
																			href="datban/delete/${c.id}.html?idhoadon=${hoadon.id}"
																			onclick="return confirm ('Bạn có thực sự muốn xoá món này')">Xoá</a>
																	</c:if>
																	<c:if test="${c.trangthai==2}">
																			<p style="color:red">Hết</p>
																		</c:if>
																</div>
															</div>
														</c:forEach>
														<div class="row "
															style="margin-top: 10px; border-top: 1px solid #d4d4d4;">
															<div class="col-md-6" style="margin-top: 10px;">
																<p>Tổng tiền</p>
															</div>
															<div class="col-md-6" style="margin-top: 10px;">
																<fmt:formatNumber var="tien" type="number"
																	pattern="###,###,###,###" value="${tongtien}"></fmt:formatNumber>
																<p>${tien}đ</p>
															</div>
														</div>
														<div class="row " style="margin-top: 10px;">
															<a onclick="setactive();" data-toggle="tab" href="#menu1"
																class="btn btn-success btn-block">Gọi món</a>
														</div>
													</div>
												</div>

											</div>

										</div>
										<div id="menu1" class="tab-pane fade">
											<div class="col-md-8">

												<form action="#">
													<div class="input-group" style="margin-top: 20px;">
														<input name="timkiem" type="text" class="form-control"
															placeholder="Search" />
														<div class="input-group-btn">
															<button class="btn btn-default form-control"
																type="submit">
																<i class="glyphicon glyphicon-search"></i>
															</button>
														</div>
													</div>
												</form>

												<ul class="nav nav-tabs" style="margin-top: 15px;">
													<li class="active"><a data-toggle="tab" href="#doan">Đồ
															ăn</a></li>
													<li><a data-toggle="tab" href="#douong">Đồ uống</a></li>
												</ul>
												<div class="tab-content">
													<div id="doan" class="tab-pane fade in active">
														<c:forEach var="monan" items="${monan}">
															<c:if test="${monan.loai.id == 1}">
																<div class="row" style="margin-top: 15px;">
																	<div class="col-md-1">
																		<input style="display: none" name="idmonan"
																			type="text" value="${monan.id}" id="idmonan">
																	</div>
																	<div class="col-md-2 col-xs-4">
																		<img class="img-responsive"
																			src="upload/monan/${monan.hinhanh}"
																			style="width: 60px; height: 60px;" />
																	</div>
																	<div class="col-md-5 col-xs-8">
																		<div class="row">
																			<p style="float: left;" id="laytenmonan">${monan.tenmonan}</p>
																		</div>
																		<div class="row">
																			<p style="float: left">Đã được đặt</p>
																			<p
																				style="float: left; padding-left: 5px; padding-right: 5px;">${monan.solandat}</p>
																			<p style="float: left">lần</p>
																		</div>
																	</div>
																	<div class="col-md-4">

																		<fmt:formatNumber var="gia" type="number"
																			pattern="###,###,###,###" value="${monan.gia}"></fmt:formatNumber>

																		<p style="float: left; margin-top: 8px;">${gia}đ</p>

																		<c:if test="${hoadon.trangthai==2 }">
																				<a class="btn btn-success" data-toggle="modal"
																					data-target="#addmonan" style="float: right;"
																					onclick="getthongtinmonan(${monan.id},'${monan.tenmonan}');">Thêm</a>
																		</c:if>
																	</div>

																</div>
															</c:if>
														</c:forEach>
													</div>

													<div id="douong" class="tab-pane fade">
														<c:forEach var="monan" items="${monan}">
															<c:if test="${monan.loai.id == 2}">
																<div class="row" style="margin-top: 15px;">
																	<div class="col-md-1">
																		<input style="display: none" name="idmonan"
																			type="text" value="${monan.id}" id="idmonan">
																	</div>
																	<div class="col-md-2">
																		<img class="img-responsive"
																			src="upload/monan/${monan.hinhanh}"
																			style="width: 60px; height: 60px;" />
																	</div>
																	<div class="col-md-5">
																		<div class="row">
																			<p style="float: left;" id="laytenmonan">${monan.tenmonan}</p>
																		</div>
																		<div class="row">
																			<p style="float: left">Đã được đặt</p>
																			<p
																				style="float: left; padding-left: 5px; padding-right: 5px;">${monan.solandat}</p>
																			<p style="float: left">lần</p>
																		</div>
																	</div>
																	<div class="col-md-4">

																		<fmt:formatNumber var="gia" type="number"
																			pattern="###,###,###,###" value="${monan.gia}"></fmt:formatNumber>

																		<p style="float: left; margin-top: 8px;">${gia}đ</p>

																		<c:if test="${hoadon.trangthai==2 }">
																		<a class="btn btn-success" data-toggle="modal"
																			data-target="#addmonan" style="float: right;"
																			onclick="getthongtinmonan(${monan.id},'${monan.tenmonan}');">Thêm</a>
																		</c:if>

																	</div>

																</div>
															</c:if>
														</c:forEach>
													</div>
												</div>
											</div>
											<div class="col-md-4" style="margin-top: 20px;">
												<div class="row dbttkm cdbthongtin">
													<div class="col-md-12">
														<p class="pdatbanttkm">
															<b>Món đã gọi </b><span > ( ${cthd.size()} )</span>
														</p>
														<c:forEach var="c" items="${cthd}" varStatus="status">
															<c:set var="dem" value="${status.index+1}"></c:set>
															<div class="row">
																<div class="col-md-1">
																	<p>${dem}</p>
																</div>
																<div class="col-md-6">
																	<p>${c.monan.tenmonan}</p>
																</div>
																<div class="col-md-3">
																	<fmt:formatNumber var="gia" type="number"
																		pattern="###,###,###,###" value="${c.monan.gia}"></fmt:formatNumber>
																	<p>${gia}đ</p>
																</div>
																<div class="col-md-1">
																	<c:if test="${c.trangthai==0}">
																		<a
																			href="datban/delete/${c.id}.html?idhoadon=${hoadon.id}"
																			onclick="return confirm ('Bạn có thực sự muốn xoá món này')">Xoá</a>
																	</c:if>
																	<c:if test="${c.trangthai==2}">
																			<p style="color:red">Hết</p>
																		</c:if>
																</div>
															</div>
														</c:forEach>
														<div class="row "
															style="margin-top: 10px; border-top: 1px solid #d4d4d4;">
															<div class="col-md-6" style="margin-top: 10px;">
																<p>Tổng tiền</p>
															</div>
															<div class="col-md-6" style="margin-top: 10px;">
																<fmt:formatNumber var="tien" type="number"
																	pattern="###,###,###,###" value="${tongtien}"></fmt:formatNumber>
																<p>${tien}đ</p>
															</div>
														</div>
														<div class="row " style="margin-top: 10px;">
															<a onclick="setactive();" data-toggle="tab" href="#menu1"
																class="btn btn-success btn-block" type="submit">Gọi
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

														<div style="height: 50px; line-height: 50px;">Vui
															lòng chờ nhà hàng xác nhận!</div>

													</div>
													<div class="col-md-1"></div>

												</div>
											</c:if>
											<div class="col-md-4" style="margin-top: 20px;">
												<div class="row dbttkm cdbthongtin">
													<div class="col-md-12">
														<p class="pdatbanttkm">
															<b>Món đã gọi </b><span> ( ${cthd.size()} )</span>
															
														</p>
														<c:forEach var="c" items="${cthd}" varStatus="status">
															<c:set var="dem" value="${status.index+1}"></c:set>
															
																
																<div class="row">
																	<div class="col-md-1">
																		<p>${dem}</p>
																	</div>
																	<div class="col-md-6">
																		<p>${c.monan.tenmonan}</p>
																	</div>
																	<div class="col-md-3">
																		<fmt:formatNumber var="gia" type="number"
																			pattern="###,###,###,###" value="${c.monan.gia}"></fmt:formatNumber>
																		<p>${gia}đ</p>
																	</div>
																	<div class="col-md-1">
																		<c:if test="${c.trangthai==0}">
																			<a
																				href="datban/delete/${c.id}.html?idhoadon=${hoadon.id}"
																				onclick="return confirm ('Bạn có thực sự muốn xoá món này')">Xoá</a>
																		</c:if>
																		<c:if test="${c.trangthai==2}">
																			<p style="color:red">Hết</p>
																		</c:if>
																	</div>
																</div>
															
														</c:forEach>
														
														<div class="row "
															style="margin-top: 10px; border-top: 1px solid #d4d4d4;">
															<div class="col-md-6" style="margin-top: 10px;">
																<p>Tổng tiền</p>
															</div>
															<div class="col-md-6" style="margin-top: 10px;">
																<fmt:formatNumber var="tien" type="number"
																	pattern="###,###,###,###" value="${tongtien}"></fmt:formatNumber>
																<p>${tien}đ</p>
															</div>
														</div>
														<div class="row " style="margin-top: 10px;">
															<a onclick="setactive();" data-toggle="tab" href="#menu1"
																class="btn btn-success btn-block" type="submit">Gọi
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
								<span class="text-danger">Hoá đơn không tồn tại</span>
								<br />
								<a class="btn btn-info" href="#">Quay lại trang chủ</a>
							</c:otherwise>
						</c:choose>

					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<div class="modal fade" id="addmonan" role="dialog">
	<div class="modal-dialog" style="width: 300px;">

		<!-- Modal content-->
		<form action="datban/themmon.html" method="post">
			<div class="modal-content" style="margin-top: 185px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style="text-align: center;">Thêm món</h4>
				</div>
				<div class="modal-body">
					<div class="row text-center">

						<input name="idhoadonmodal" id="idhoadonmodal"
							style="display: none" value="${hoadon.id}" /> <input
							name="idmonanmodal" id="idmonanmodal" style="display: none" />
						<div class="col-md-12">
							<p>
								<span id="settenmon" style="color: black"></span>
							</p>
						</div>

						<input type="number" class="form-control" name="soluong" value="1"
							style="width: 80px; margin-left: 112px;" />
					</div>

				</div>
				<div class="modal-footer" style="text-align: center;">
					<input type="submit" class="btn btn-success" value="Thêm" />
					<button type="button" class="btn btn-default" data-dismiss="modal">Huỷ</button>
				</div>
			</div>
		</form>
	</div>
</div>
<script>$(document).ready(function(){
	var loi = $('#koxoadc').val();
	if(loi != ""){
		alert(loi)
	}
	var yctt = $('#ycthanhtoan').val();
	if(yctt != ""){
		alert(yctt)
	}
});</script>
<%-- <jsp:include page="/include/footer.jsp"></jsp:include>

</body>
</html> --%>