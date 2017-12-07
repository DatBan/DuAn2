<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="/include/headtag.jsp"></jsp:include>

</head>
<body>

	<form name="quenmkform" id="quenmkform" action="user/mailer/doimaikhau.html"
		method="post">
		<div class="container clearfix" style="background-color: white">
			<div class="row" style="margin-top: 20px; margin-bottom: 20px;">
				<p
					style="font-size: 24px; color: #4a90e2; text-align: center; margin-top: 20px;">Đổi mật khẩu</p>
				<p style="color: green; text-align: center; margin-top: 20px;">${message}</p>

				<form>
					<div class="row" style="margin-top: 20px; margin-bottom: 20px;">
						<div class="col-md-3 mb-3"></div>
						<div class="col-md-6 mb-3">
							<label for="validationDefault01">Tài khoản: <span style="color: red;">*</span></label> <input
								type="text" class="form-control" name="taikhoan" id="taikhoan"
								id="validationDefault01" placeholder="Tên đăng nhập của bạn" required>
						</div>
					</div>
					<div class="row" style="margin-top: 20px; margin-bottom: 20px;">
						<div class="col-md-3 mb-3"></div>
						<div class="col-md-6 mb-3">
							<label for="validationDefault01">Nhập mật khẩu cũ: <span style="color: red;">*</span></label> <input
								type="password" class="form-control" name="matkhaucu" id="matkhaucu"
								id="validationDefault01" placeholder="Nhập mật khẩu cũ" required>
						</div>
					</div>
					<div class="row" style="margin-top: 20px; margin-bottom: 20px;">
						<div class="col-md-3 mb-3"></div>
						<div class="col-md-6 mb-3">
							<label for="validationDefault03">Nhập mật khẩu mới: <span style="color: red;">*</span></label> <input
								type="password" class="form-control" name="matkhaumoi" id="matkhaumoi"
								id="pass1" placeholder="Nhập mật khẩu mới" required>
						</div>
					</div>
					<div class="row" style="margin-top: 20px; margin-bottom: 20px;">
						<div class="col-md-3 mb-3"></div>
						<div class="col-md-6 mb-3">
							<label for="validationDefault03">Nhập lại mật khẩu mới: <span style="color: red;">*</span></label> <input
								type="password" class="form-control" name="nhaplaimkmoi" id="nhaplaimkmoi"
								id="pass2" placeholder="Nhập lại mật khẩu mới" required>
						</div>
					</div>


					</br>
					<center>
						<button style="height: 40px;" class="btn btn-primary"
							type="submit">Đổi mật khẩu</button>
					</center>
			</div>
		</div>
	</form>
	</div>
<script src="js/Scriptmkmoi.js"></script>







</body>
</html>