<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container con">
	<div class="row">
		<div class="row tren">
			<div class="trai col-md-6">
				<div class="col-md-2"></div>
				<div class="col-md-5">
					<p class="thongtinbanan"><b> Thông tin bàn ăn</b></p>
				</div>
				
			</div>
			<div class="phai col-md-6">
				<div class="col-md-1">
					<a ><img class="img-response icondt" src="images/dienthoai.png"/></a>
					
				</div>
				<div class="col-md-3 dienthoai">
					<p class="sdt"><b>1900 1008</b></p>
				</div>				
				<div class="col-md-1">
					<img class="img-response icondt" src="images/dongho.png"/>
					
				</div>
				<div class="col-md-4 dongho">
					<p class="thoigian"><b>7:00 AM -8:00 PM </b></p>
				</div>
				
				<div class="col-md-1">
					<img class="img-response icondt" src="images/diacau.png"/>
					
				</div>	
					
				<div class="col-md-2 dropdown">
					
					<button class="btn btn-default dropdown-toggle icondt btnn" type="button"
						id="menu1" data-toggle="dropdown">
						VI <span><img class="img-response " src="images/muiten.png"/></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">English</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Việt Nam</a></li>
						
					</ul>
				</div>
			</div>
			
		</div>
		<div class="row duoi">
			<div class="col-md-3 can">
				<a href="trang-chu.html"><img src="images/logo.png"/></a>
			</div>
			<div class="col-md-2 dropdown can">
					<select class="btn btn-default dropdown-toggle icondt" 
						id="menu1" data-toggle="dropdown">
						<option>Đăk lăk</option>
						<option>Ha Noi</option>
						<option>Sai gon</option>
					</select>
			</div>
			<div class="col-md-4 linkh">
				<a href="#" class="linkheader" style="text-decoration: none;"><b>Khuyến mãi</b></a>
				<a href="#" class="linkheader" style="text-decoration: none;"><b>Bài viết</b></a>
				<a href="#" class="linkheader" style="text-decoration: none;"><b>Trợ giúp</b></a>
			</div>
			<div class="col-md-3 linkh">
				<a href="#" class="linkdangnhap" style="text-decoration: none;" data-toggle="modal" data-target="#myModal"><b>Đăng nhập</b></a>
				<button class="btn info btndatban"><b>Đặt bàn</b></button>
			</div>
			
		</div>
	</div>
</div>
<jsp:include page="/views/homepage/modal-login.jsp"></jsp:include>
<div class="container-full conff">
	<div class="container timkiemm">
		<div class="row">
			
			
			
			
			
			
		</div>
		<div class="row">
			<div class="row timkiemnhc timkiemctnh">
			<form class="form-inline">
				<div class="input-group">
					 <span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
					<input type="text" class="form-control" placeholder="Tên nhà hàng, món ăn, địa điểm">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="ngaythang" placeholder="Chọn ngày tháng">
				</div>
				<div class="form-group">
					<select class="form-control">
						<option>-Thời gian-</option>
					</select>
				</div>
				<div class="form-group">
					<select class="form-control">
						<option>1 người</option>
						<option>2 người</option>
					</select>
				</div>
				<button class="btn warning btntk"><b>Tìm kiếm</b></button>
			</form>
			<div class="col-md-2 ">
				
			</div>
			
		</div>
		</div>
	</div>
</div>
<script>
  $(function() {
    $( "#ngaythang" ).datepicker({
    	dateFormat: "dd/mm/yy",
    	minDate: 0,
    	defaultDate: 0
    });
  });
  </script>