<%@ page pageEncoding="utf-8"%>
<nav id="sidebar">
	<div class="left-sidebar">
		<!-- Sidebar header -->
		<div class="sidebar-header text-center">
			<h3>Hallo e</h3>
			<strong>BS</strong>
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
			<li class="active">
				<a href="#ss" data-toggle="collapse" aria-expanded="true"> 
					<i class="glyphicon glyphicon-home"></i>
					Dashboard
				</a>
				<ul class="collapse list-unstyled in" id="ss">
					<li class="current-page"><a href="#"><i class="fa fa-circle-o"></i> D1</a></li>
					<li><a href="#"><i class="fa fa-circle-o"></i> D2</a></li>
				</ul>
			</li>
			<li>
				<a href="#"> 
					<i class="glyphicon glyphicon-briefcase"></i>
					Dashboard 2
				</a>
			</li>
			<li>
				<a href="#ss2" data-toggle="collapse" aria-expanded="false">
						<i class="glyphicon glyphicon-home"></i> Dashboard
				</a>
				<ul class="collapse list-unstyled" id="ss2">
					<li><a href="#"><i class="fa fa-circle-o"></i> D1</a></li>
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