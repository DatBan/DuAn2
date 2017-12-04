<%@ page pageEncoding="utf-8"%>
<nav id="sidebar">
	<div class="left-sidebar">
		<!-- Sidebar header -->
		<div class="sidebar-header text-center">
			<a href="#">
				<h3>Hallo e</h3>
				<strong>BS</strong>
			</a>
		</div>

		<!-- Profile -->
		<div class="clearfix profile">
			<div class="col-md-5 p-img">
				<img src="images/jim-carrey.jpg" class="img-responsive img-circle" />
			</div>
			<div class="col-md-6">
				<span>Welcome,</span>
				<h5>Admin</h5>
			</div>
		</div>
		<!-- Sidebar links -->
		<ul class="list-unstyled components">
			<li>
				<a href="dashboard/index.html"><i class="glyphicon glyphicon-briefcase"></i>Dashboard</a> 
			</li>
			<li class="child-menu">
				<a href="#ss2" data-toggle="collapse" aria-expanded="false">
						<i class="glyphicon glyphicon-home"></i> Trang
				</a>
				<ul class="collapse list-unstyled" id="ss2">
					<li><a href="dashboard/trang/index.html"><i class="fa fa-circle-o"></i> Quản lý trang</a></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> D2</a></li>
				</ul>
			</li>	
			<li class="child-menu">
				<a href="#ss3" data-toggle="collapse" aria-expanded="false">
						<i class="glyphicon glyphicon-home"></i> Bài Viết
				</a>
				<ul class="collapse list-unstyled" id="ss3">
					<li><a href="dashboard/baiviet/index.html"><i class="fa fa-circle-o"></i> Quản lý bài viết</a></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> D2</a></li>
				</ul>
			</li>
			<li class="child-menu">
				<a href="#ss4" data-toggle="collapse" aria-expanded="false">
						<i class="glyphicon glyphicon-home"></i> Nhà hàng của tôi
				</a>
				<ul class="collapse list-unstyled" id="ss4">
					<li><a href="nhahang/baiviet/index.html"><i class="fa fa-circle-o"></i> Quản lý bài viết</a></li>
					<li><a href="nhahang/monan/index.html"><i class="fa fa-circle-o"></i> Quản lý món ăn</a></li>
					<li><a href="nhahang/tienich/index.html"><i class="fa fa-circle-o"></i> Quản lý tiện ích</a></li>
					<li><a href="nhahang/khuyenmai/index.html"><i class="fa fa-circle-o"></i> Quản lý khuyến mãi</a></li>
					<li><a href="nhahang/ban/index.html"><i class="fa fa-circle-o"></i> Quản lý bàn ăn</a></li>
				</ul>
			</li>
			<li class="child-menu">
				<a href="#ss6" data-toggle="collapse" aria-expanded="false">
						<i class="glyphicon glyphicon-home"></i> Quản lý đặt bàn
				</a>
				<ul class="collapse list-unstyled" id="ss6">					
					<li><a href="nhahang/quanlydatban/index.html"><i class="fa fa-circle-o"></i> Đơn đặt bàn mới</a></li>
					<li><a href="nhahang/quanlydatban/index1.html"><i class="fa fa-circle-o"></i> Đơn đã xác nhận</a></li>
					<li><a href="nhahang/hoadon/index.html"><i class="fa fa-circle-o"></i> Quản lý hoá đơn</a></li>
					<li><a href="datban/yeucau.html"><i class="fa fa-circle-o"></i> Yêu cầu gọi món</a></li>
					<li><a href="datban/yeucauthanhtoan.html"><i class="fa fa-circle-o"></i> Yêu cầu thanh toán</a></li>
				</ul>
			</li>
			<li class="child-menu">
				<a href="#ss5" data-toggle="collapse" aria-expanded="false">
						<i class="glyphicon glyphicon-home"></i> USer
				</a>
				<ul class="collapse list-unstyled" id="ss5">
					<li><a href="nguoidung/baiviet/index.html"><i class="fa fa-circle-o"></i> Quản lý bài viết</a></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> D2</a></li>
				</ul>
			</li>
			
			<li class="child-menu">
				<a href="#ss7" data-toggle="collapse" aria-expanded="false">
						<i class="glyphicon glyphicon-home"></i> Ẩm thực
				</a>
				<ul class="collapse list-unstyled" id="ss7">
					<li><a href="dashboard/amthuc/index.html"><i class="fa fa-circle-o"></i> Quản lý loại ẩm thực</a></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> D2</a></li>
				</ul>
			</li>
			
			<li class="child-menu">
				<a href="#ss8" data-toggle="collapse" aria-expanded="false">
					<i class="glyphicon glyphicon-home"></i> Quản lý nhà hàng
				</a>
				<ul class="collapse list-unstyled" id="ss8">
					<li><a href="dashboard/restaurants-mng/them.html"><i class="fa fa-circle-o"></i> Thêm nhà hàng</a></li>
					<li><a href="dashboard/restaurants-mng.html"><i class="fa fa-circle-o"></i> Danh sách đang hoạt động</a></li>
					<li><a href="dashboard/restaurants-mng.html?trangthai=0"><i class="fa fa-circle-o"></i> Danh sách đã khóa</a></li>
				</ul>
			</li>
			<li class="child-menu">
				<a href="#ss" data-toggle="collapse" aria-expanded="false"> 
					<i class="glyphicon glyphicon-home"></i>
					Quản lý người dùng
				</a>
				<ul class="collapse list-unstyled" id="ss">
					<li><a href="dashboard/user-management/them.html"><i class="fa fa-circle-o"></i> Thêm người dùng</a></li>
					<li><a href="dashboard/user-management.html?trangthai=1"><i class="fa fa-circle-o"></i> Danh sách đang sử dụng</a></li>
					<li><a href="dashboard/user-management.html?trangthai=0"><i class="fa fa-circle-o"></i> Danh sách đã khóa</a></li>
				</ul>
			</li>
			<li>
				<a href="#"> 
				<i class="glyphicon glyphicon-briefcase"></i>
					Dashboard 3
				</a>
			</li>
		</ul>
	</div>
</nav>