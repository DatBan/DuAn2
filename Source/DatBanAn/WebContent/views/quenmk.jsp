<%@ page import="com.controller.Mail"%>
<%@ page import="javax.mail.MessagingException"%>
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
	<form name="quenmkform" id="registerform"
									action="QuenmkForm.html" method="post">
		<div class="container clearfix">

			<form class="container" id="needs-validation" novalidate>
				<div class="row">
					<div class="col-md-4 mb-3">
						<label for="tendangnhap">Tên đăng nhập</label> 
						</br>
						<input
							type="text" id="tdn"  class="form-control"
							aria-required="true" placeholder="Nhập tên đăng nhập" >
					</div>
					
				</div>
				</br>
				<div class="row">
					<div class="col-md-4 mb-3">
						<label for="email">Email</label> 
						</br>
						<input type="text"
							class="form-control required email" id="email"
							placeholder="Nhập Email" >
						<div class="invalid-feedback"></div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-4 mb-3">

						<label for="validationCustom03">Nhập mã captcaha</label>
						
						<div class="g-recaptcha" data-sitekey="6Ldp4zYUAAAAAFa2tk-wprMi9rtiE9Qm9Q5g12qA"></div>

					
				
						<div id="mail-status" style="margin-top: 10px;"></div>
						<input type="submit" class="form-control" value="Lấy lại mật khẩu"
							id="send-message" style="clear: both;">
					
					</div>

				</div>
			</form>
			<div class="invalid-feedback"></div>
		</div>




	</form>

<script src='https://www.google.com/recaptcha/api.js'></script>




</body>
</html>