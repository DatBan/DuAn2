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
	<form action="changepass.htm" method="post">
		<div class="container clearfix">

			<h3 style="margin-left: 490px; margin-bottom: 20px;">ĐỔI MẬT
				KHẨU</h3>

			<form>
				<div class="row">
					<div class="col-md-3 mb-3"></div>
					<div class="col-md-6 mb-3">
						<label for="validationDefault01">Nhập mật khẩu cũ</label> <input
							type="password" class="form-control" name="matkhaucu" id="validationDefault01"
							placeholder="Nhập mật khẩu cũ" required>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 mb-3"></div>
					<div class="col-md-6 mb-3">
						<label for="validationDefault03">Nhập mật khẩu mới</label> <input
							type="password" class="form-control" name="matkhaumoi" id="pass1"
							placeholder="Nhập mật khẩu mới" required>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 mb-3"></div>
					<div class="col-md-6 mb-3">
						<label for="validationDefault03">Nhập lại mật khẩu mới</label> <input
							type="password" class="form-control" name="nhaplaimkmoi" id="pass2"
							placeholder="Nhập lại mật khẩu mới" required>
					</div>
				</div>
		</div>

		</br>
		<center>
			<button style="height: 40px;" class="btn btn-primary" type="submit">Đổi
				mật khẩu</button>
		</center>
		
	</form>
	</div>
		
<script type="text/javascript">
	var password = document.getElementById("pass1"), confirm_password = document
			.getElementById("pass2");

	function validatePassword() {
		if (pass1.value != pass2.value) {
			pass2.setCustomValidity("mật khẩu không giống mật khẩu mới");
		} else {
			pass2.setCustomValidity('');
		}
	}

	pass1.onchange = validatePassword;
	pass2.onkeyup = validatePassword;
</script>






</body>
</html>