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
					
					<button class="btn btn-default dropdown-toggle icondt" type="button"
						id="menu1" data-toggle="dropdown">
						Đăk lăk <span><img class="img-response " src="images/muitenxuong.png"/></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Đăk Lăk</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Hà Nội</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Hồ Chí Minh</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Đà Nẵng</a></li>
					</ul>
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
			<div class="col-md-2">
				
			</div>
			
			<div class="col-md-10">			
				<span class="dbmp"><b>Đặt bàn miễn phí</b></span>
			</div>
			
			
			
		</div>
		<div class="row">
			<div class="col-md-4 ">
				<div>					
					<div class="otimk" style="background-color:#f8f8f8;">
						<img style="padding-left: 8px;margin-top: -7px;" src="images/icontkctnh.png"/>
						<span class="ndotim">Tên nhà hàng, món ăn, địa điểm</span>
					</div>
				</div>
			</div>
			<div class="col-md-2 ">
				
				<div class="col-md-8">
					<div class="ongaythang"style="background-color:#f8f8f8;">
						<span class="pngaythang">Ngày tháng</span>
					</div>					
				</div>
				<div class="col-md-4">
					<img src="images/ngaythang.png" style="width:60px;height:60px;margin-top: -5px;"/>
				</div>
				
			</div>
			<div class="col-md-2 ">
				
				<div class="col-md-8">
					<div class="ongaythang"style="background-color:#f8f8f8;">
						<span class="pngaythang">Thời gian</span>
					</div>					
				</div>
				<div class="col-md-4">
					<img src="images/thoigian.png" style="width:60px;height:60px;margin-top: -5px;"/>
				</div>
				
			</div>
			<div class="col-md-2 ">
				
				<div class="col-md-8">
					<div class="ongaythang"style="background-color:#f8f8f8;">
						<span class="pngaythang">Số người</span>
					</div>					
				</div>
				<div class="col-md-4">
					
					<img src="images/muitentim.png" style="width:50px;height:50px;margin-top: 0px;"/>
				</div>
				
			</div>
			<div class="col-md-2 ">
				<a href="timkiem.html"><button class="btn warning btntk"><b>Tìm kiếm</b></button></a>
			</div>
			
		</div>
	</div>
</div>