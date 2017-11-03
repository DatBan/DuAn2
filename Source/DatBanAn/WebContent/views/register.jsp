<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
								<div class="row ">
									<div class="col-md-3"></div>
									<div class="form-group col-md-3">
										<a href="#" class="btn btn-default btn-block"> <i
											class="fa fa-facebook-official"
											style="font-size: large; color: #3b5998;"></i> Đăng nhập với
											facebook
										</a>
									</div>
									<div class="form-group col-md-3">
										<a href="#" class="btn btn-default btn-block"> <i
											class="fa fa-google-plus-square"
											style="font-size: large; color: #c23321;"></i> Đăng nhập với
											Google
										</a>
									</div>
									<div class="col-md-3"></div>
								</div>
								<span style="margin-top: 30px; color: red; ">${message}</span>
								<form name="registerform" id="registerform"
									action="RegisterForm.html" method="post">
									<div class="row rregister">
										<div class="form-group fullname-custom">
											<div class=" col-md-3"></div>
											<div class="col-md-6">
												<label class="control-label  labeld" for="hoten">Họ
													Và Tên:<span style="color: red;">*</span>
												</label> <input type="text" name="hoten" id="hoten"
													placeholder="VD : Nguyễn Văn A" class="form-control"
													>
											</div>
										</div>
									</div>
									<div class="row rregister">
										<div class="form-group fullname-custom">
											<div class=" col-md-3"></div>
											<div class="col-md-6">
												<label class="control-label  labeld" for="tendangnhap">Tên
													Đăng Nhập:<span style="color: red;">*</span>
												</label> <input type="text" name="tendangnhap"
													placeholder="Tên Đăng Nhập" class="form-control" >
											</div>
										</div>
									</div>
									<div class="row rregister">
										<div class="form-group fullname-custom">
											<div class=" col-md-3"></div>

											<div class="col-md-6">
												<label class="control-label  labeld" for="matkhau">Mật
													Khẩu:<span style="color: red;">*</span>
												</label> <input type="password" name="matkhau" id="matkhau"
													placeholder="Nhập Mật Khẩu" class="form-control" >
											</div>
										</div>
									</div>
									<div class="row rregister">
										<div class="form-group fullname-custom">
											<div class=" col-md-3"></div>

											<div class="col-md-6">
												<label class="control-label  labeld" for="nhaplaimatkhau">Nhập
													Lại Mật Khẩu:<span style="color: red;">*</span>
												</label> <input type="password" name="nhaplaimatkhau" id="nhaplaimatkhau"
													placeholder="Nhập Lại Mật Khẩu" class="form-control"
													>
											</div>
										</div>
									</div>
									<div class="row rregister">
										<div class="form-group fullname-custom">
											<div class=" col-md-3"></div>

											<div class="col-md-6">
												<label class="control-label  labeld" for="email">Email:<span
													style="color: red;">*</span></label> <input type="email"
													name="email" placeholder="Địa chỉ Email"
													class="form-control" >
											</div>
										</div>
									</div>
									<div class="row rregister">
										<div class="form-group fullname-custom">
											<div class=" col-md-3"></div>

											<div class="col-md-6">
												<label class="control-label  labeld" for="sdt">Số
													điện thoại:<span style="color: red;">*</span>
												</label> <input type="text" name="sdt" placeholder="Số điện thoại"
													class="form-control" >
											</div>
										</div>
									</div>
									<div class="row rregister">
										<div class="form-group fullname-custom">
											<div class=" col-md-3"></div>

											<div class="col-md-6">
												<label class="control-label  labeld" for="diachi">Địa
													chỉ:</label> <input type="text" name="diachi" placeholder="Địa chỉ"
													class="form-control">
											</div>
										</div>
									</div>

									
									<div class="row rregisters">
										<div class="col-md-3"></div>
										<div class="col-md-3">
											<input class="btn btn-success btn-block" type="submit"
												value="Đăng ký">
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


</body>
</html>