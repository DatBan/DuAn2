<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<div class="container con">
	<!-- Menu top top top -->
	<div class="row menu-top">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#"><b>Thông tin bàn ăn</b></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><p class="navbar-text">
							<i class="fa fa-phone" style="color: #e54d3f;"></i><b
								style="color: #e54d3f;"> 1900 1008</b>
						</p></li>
					<li>
						<p class="navbar-text">
							<i class="fa fa-clock-o" style="color: #1178e2;"></i><b> 7:00
								AM - 8:00 PM</b>
						</p>
					</li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"> <i
							class="fa fa-globe"></i> VI <span
							class="glyphicon glyphicon-menu-down"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="glyphicon glyphicon-user"></i>
									EN</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</div>
	<!-- menu chinh, logo -->
	<div class="row menu-chinh">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="trang-chu.html"><img
						src="images/logo.png" /></a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<form class="navbar-form navbar-left">
						<div class="form-group">
							<select class="form-control">
								<option>Dak lak</option>
								<option>Ha noi</option>
							</select>
						</div>
					</form>
					<ul class="nav navbar-nav">
						<li><a href="#"><b>Khuyến mãi</b></a></li>
						<li><a href="#"><b>Bài viết</b></a></li>
						<li><a href="#"><b>Trợ giúp</b></a></li>
						<c:forEach var="t" items="${trang}">
						<li><a href="#">${t.tieude}</a></li>
						</c:forEach>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${sessionScope.nd == null}">
								<li>
									<a href="javascript:;" class="linkdangnhap" data-toggle="modal" data-target="#myModal"> 
										<b>Đăng nhập</b>
									</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="dropdown"><a href="#" data-toggle="dropdown">Welcome,
										${sessionScope.nd.hoten} <span class="glyphicon glyphicon-menu-down"></span>
								</a>
									<ul class="dropdown-menu">
										<li>
											<a href="dashboard/index.html"><i class="glyphicon glyphicon-user"></i>
												Trang quản trị</a>
										</li>
										<li>
											<a href="#"><i class="glyphicon glyphicon-user"></i>
												Thông tin tài khoản</a>
										</li>
										<li class="divider"></li>
										<li><a href="logout.html" onclick="signOut();"><i class="fa fa-sign-out"></i>Thoát</a></li>
									</ul></li>
							</c:otherwise>
						</c:choose>
						<li><a href="#" class="btn btn-warning  "
							style="padding-top: 6px; padding-left: 10px; padding-bottom: 6px; padding-right: 10px; margin-top: 9px; color: white; font-size: 15px; background-color: #f0ad4e; border: none;"><b>Đặt
									bàn</b></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>
<jsp:include page="${request.contextPath}/modal-login.html"></jsp:include>