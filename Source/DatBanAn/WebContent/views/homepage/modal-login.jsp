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
					<form:form action="login.html" method="post" modelAttribute="nguoidung">
					  <div class="form-group">
					    <label for="tendangnhap">Tên đăng nhập:</label>
					    <form:input path="tendangnhap" class="form-control"/>
					  </div>
					  <div class="form-group">
					    <label for="matkhau">Mật khẩu:</label>
					    <form:password path="matkhau" class="form-control"/>
					  </div>
					  <div class="checkbox">
					    <label><input type="checkbox" name="remember" value="true"> Ghi nhớ mật khẩu</label>
					    <label class="pull-right"><a href="#">Quên mật khẩu?</a></label>
					  </div>
					  <div class="form-group">
					  	<button type="submit"  class="btn btn-primary btn-block">Đăng nhập</button>
					  </div>
					</form:form>
        		</div>
        		<div class="col-md-6">
        			<div class="form-group">
					  	<a href="#" class="btn btn-default btn-block">
					  	<i class="fa fa-facebook-official" style="font-size: large; color:#3b5998;"></i> Đăng nhập với facebook
					  	</a>
					</div>
					<div class="form-group">
					  	<a href="#" class="btn btn-default btn-block">
					  		<i class="fa fa-google-plus-square" style="font-size: large; color:#c23321;"></i> Đăng nhập với Google
					  	</a>
					</div>
					<div class="form-group">
					  	<a href="RegisterForm.html" class="btn btn-default btn-block">
					  		Đăng ký
					  	</a>
					</div>
					<div class="form-group">
						<button type="button" class="btn btn-default btn-block" data-dismiss="modal">Đóng</button>
					</div>
        		</div>
        	</div>
      </div>
    </div>

  </div>
</div>