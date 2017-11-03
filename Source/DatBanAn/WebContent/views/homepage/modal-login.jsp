<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Đăng nhập</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-6">
						<form:form action="login.html" method="post"
							modelAttribute="nguoidung">
							<div class="form-group clearfix">
								<label for="tendangnhap">Tên đăng nhập:</label>
								<form:input path="tendangnhap" class="form-control" />
							</div>
							<div class="form-group clearfix">
								<label for="matkhau">Mật khẩu:</label>
								<form:password path="matkhau" class="form-control" />
							</div>
							<div class="checkbox">
								<label><input type="checkbox" name="remember"
									value="true"> Ghi nhớ mật khẩu</label> <label
									class="pull-right"><a href="#">Quên mật khẩu?</a></label>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">Đăng
									nhập</button>
							</div>
						</form:form>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							
								<div class="fb-login-button" data-width="100" data-max-rows="1"
									data-size="large" data-button-type="continue_with"
									data-show-faces="false" data-auto-logout-link="false"
									data-use-continue-as="false"></div>
							
						</div>
						<div class="form-group">
							<a href="#" class="btn btn-default btn-block"> <i
								class="fa fa-google-plus-square"
								style="font-size: large; color: #c23321;"></i> Đăng nhập với
								Google
							</a>
						</div>
						<div class="form-group">
							<a href="RegisterForm.html" class="btn btn-default btn-block">
								Đăng ký </a>
						</div>
						<div class="form-group">
							<button type="button" class="btn btn-default btn-block"
								data-dismiss="modal">Đóng</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<div id="fb-root"></div>
<script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.10&appId=152449932157405';
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>
<script>
	window.fbAsyncInit = function() {
		FB.init({
			appId : '152449932157405',
			xfbml : true,
			version : 'v2.10'
		});
		FB.AppEvents.logPageView();
	};

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement(s);
		js.id = id;
		js.src = "https://connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>