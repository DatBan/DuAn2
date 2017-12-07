<%@ page import="com.controller.Mail"%>
<%@ page import="javax.mail.MessagingException"%>
<%@ page pageEncoding="UTF-8"%>
	<div class="container clearfix "
		style="background-color: white; ">
		<div class="row " style="margin-top: 30px; margin-bottom: 30px;">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="row">
					<p
						style="font-size: 24px; color: #4a90e2; text-align: center; margin-top: 20px;">Quên
						mật khẩu</p>
				</div>
				<form name=quenmk id="quenmk" action="user/mailer/laylaimk.html"
					method="post">
					<div class="row">
						<div>
							<label class="control-label  labeld" for="tendangnhap">
								Tên đăng nhập: <span style="color: red;">*</span>
							</label> <input type="text" name="tendangnhap" id="tendangnhap1"
								placeholder="VD : taikhoan123" class="form-control">
							<div class="invalid-feedback"></div>
						</div>

					</div>
					<div class="row">
						<div>
							<label class="control-label  labeld" for="tennhahang">
								Email: <span style="color: red;">*</span>
							</label> <input type="text" name="email" id="email"
								placeholder="VD : taikhoan123@gmail.com" class="form-control">
							<div class="invalid-feedback"></div>
						</div>

					</div>

					<div class="row">
						<div>

							<label for="validationCustom03">Xác nhận captcha</label>

							<div class="g-recaptcha" data-callback="recaptchaCallback"
								data-sitekey="6Ldp4zYUAAAAAFa2tk-wprMi9rtiE9Qm9Q5g12qA"></div>



							<div id="mail-status" style="margin-top: 10px;"></div>
							<p class="form-submit">
								<input type="submit" class="form-control" disabled="disabled"
									value="Lấy lại mật khẩu" id="send-message" style="clear: both;">
							</p>

						</div>

					</div>
				</form>
			</div>

			<div class="invalid-feedback"></div>
		</div>
	</div>
	<script src="https://www.google.com/recaptcha/api.js"></script>




	<script>
		function recaptchaCallback() {
			$('#send-message').removeAttr('disabled');

		};
	</script>

<script src="js/Scriptdoimk.js"></script>