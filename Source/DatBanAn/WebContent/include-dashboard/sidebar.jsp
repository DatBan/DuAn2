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
				<a href="dashboard/index.html"> 
					<i class="glyphicon glyphicon-briefcase"></i>
					Dashboard
				</a>
			</li>
			<li class="child-menu">
				<a href="#ss" data-toggle="collapse" aria-expanded="false"> 
					<i class="glyphicon glyphicon-home"></i>
					Quản lý người dùng
				</a>
				<ul class="collapse list-unstyled" id="ss">
					<li><a href="dashboard/user-management.html"><i class="fa fa-circle-o"></i> Danh sách</a></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> D2</a></li>
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