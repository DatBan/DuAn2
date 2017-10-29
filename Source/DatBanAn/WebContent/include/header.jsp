<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<div class="container con">
	<!-- Menu top top top -->
	<div class="row menu-top">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Thông tin bàn ăn</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="tel:00000"><i class="fa fa-phone"></i> 1900 1008</a>
					</li>
					<li>
						<p class="navbar-text">
							<i class="fa fa-clock-o"></i> 7:00 AM - 8:00 PM
						</p>
					</li>
					<li class="dropdown">
						<a href="#" data-toggle="dropdown">
							<i class="fa fa-globe"></i> VI <span class="glyphicon glyphicon-menu-down"></span></a>
						<ul class="dropdown-menu">
							<li>
								<a href="#"><i class="glyphicon glyphicon-user"></i> EN</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
	</div>
	<!-- menu chinh, logo -->
	<div class="row menu-chinh">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="trang-chu.html"><img src="images/logo.png" /></a>
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
						<li><a href="#">Khuyến mãi</a></li>
						<li><a href="#">Bài viết</a></li>
						<li><a href="#">Trợ giúp</a></li>
						<li><a href="#">${cookie.hitCounter.value}</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${sessionScope.tdn == null}">
								<li><a href="javascript:;" class="linkdangnhap"
									style="text-decoration: none;" data-toggle="modal"
									data-target="#myModal"> <b>Đăng nhập</b>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="dropdown">
									<a href="#" data-toggle="dropdown">Welcome, ${sessionScope.tdn} <span class="glyphicon glyphicon-menu-down"></span>
									</a>
									<ul class="dropdown-menu">
										<li>
											<a href="#"><i class="glyphicon glyphicon-user"></i> Thông tin tài khoản</a>
										</li>
										<li class="divider"></li>
										<li><a href="logout.html"><i class="fa fa-sign-out"></i>Thoát</a></li>
									</ul>
								</li>
							</c:otherwise>
						</c:choose>
						<li><a href="#" class="btn btn-info ">Đặt bàn</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>
<jsp:include page="${request.contextPath}/modal-login.html"></jsp:include>