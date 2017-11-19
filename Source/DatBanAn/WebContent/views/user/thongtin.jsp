<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Thông tin bàn ăn</title>
<jsp:include page="/include/headtag.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="container bodydexuat">

		<div class="row rodk">

			<div class="col-sm-12">
				<div class="login-page" style="margin-top: 50px">
					<div class="text-center">
						<div class="login-body">
							<div class="col-md-12">
							<form name="thongtinbanan" id="thongtinbanan"
									action="datban/thongtinbanan.html" method="post">

								<div class="row rregister">
									<div class="form-group fullname-custom">
										<div class=" col-md-3"></div>

										<div class="col-md-6">
											<label class="control-label  labeld" for="email">Email:<span
												style="color: red;">*</span></label> <input type="email"
												name="email" placeholder="Địa chỉ Email của bạn"
												class="form-control">
										</div>
									</div>
								</div>
								<div class="row rregister">
									<div class="form-group fullname-custom">
										<div class=" col-md-3"></div>

										<div class="col-md-6">
											<label class="control-label  labeld" for="sdt">Mã hoá
												đơn:<span style="color: red;">*</span>
											</label> <input type="text" name="idhoadon"
												placeholder="Mã hoá đơn của bạn" class="form-control">
										</div>
									</div>
								</div>



								<div class="row rregisters">
									<div class="col-md-3"></div>
									<div class="col-md-3">
										<input class="btn btn-success btn-block" type="submit"
											value="Xem thông tin">
									</div>
									<div class="col-md-3">
										<a href="trang-chu.html" class="btn btn-warning btn-block"
											type="button">Huỷ</a>
									</div>
									<div class="col-md-3"></div>

								</div>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
<jsp:include page="/include/footer.jsp"></jsp:include>

</body>
</html>