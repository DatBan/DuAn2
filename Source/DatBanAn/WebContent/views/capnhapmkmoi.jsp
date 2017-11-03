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
	<div class="container clearfix">
		
			<h3 style="margin-left: 490px;margin-bottom: 20px;">CẬP NHẬP LẠI MẬT KHÂU</h3>

		<form>
			<div class="row">
				<div class="col-md-3 mb-3"></div>
				<div class="col-md-6 mb-3">
					<label for="validationDefault03">Nhập mật khẩu mới</label> <input
						type="password" class="form-control" id="validationDefault03"
						placeholder="Nhập mật khẩu mới" required>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 mb-3"></div>
				<div class="col-md-6 mb-3">
					<label for="validationDefault03">Nhập lại mật khẩu mới</label> <input
						type="password" class="form-control" id="validationDefault03"
						placeholder="Nhập lại mật khẩu mới" required>
				</div>
			</div>
	</div>

	</br>
	<center>
		<button style="height: 40px;" class="btn btn-primary" type="submit">Cập nhập mật khẩu</button>
	</center>
	</form>
	</div>







</body>
</html>