<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dashboard</title>
<jsp:include page="/include-dashboard/headtag.jsp"></jsp:include>
</head>
<body>
	<div class="wrapper">
		<!----------------------------- Sidebar ----------------------------------->
		<jsp:include page="/include-dashboard/sidebar.jsp"></jsp:include>

		<!-- Menu top, content -->
		<div id="content">
			<!---------------------------- header-top------------------------------->
			<jsp:include page="/include-dashboard/header.jsp"></jsp:include>

			<!-- main content -->
			<div class="main-content">
				<!------------- Breadcrumb, nut bam cac thu -------------->
				<jsp:include page="/include-dashboard/header-content.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->

				<div class="content-nhe">
					<div class="row tieudethemtrang">
						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#home">Thông
								tin</a></li>
						<!-- <li><a data-toggle="tab" href="#menu1">Bàn</a></li> -->
						<!-- <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
						<li><a data-toggle="tab" href="#menu3">Menu 3</a></li> -->
					</ul>
					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">

							<form name="datban" id="datban"
								action="nhahang/quanlydatban/suadondatban1.html" method="post"
								enctype="multipart/form-data">

								<div class="row rthemtrangmoi">

									<div class="form-group fullname-custom">
										<div class=" col-md-3"></div>
										<div class="col-md-6">
											<label class="control-label  labeld" for="td">Thời
												gian :<span style="color: red;">*</span>
											</label> <input value="" class="form-control" type="time"
												class="timepicker chontg" id="thoigian">
										</div>
										

									</div>
								</div>
								<div class="row rthemtrangmoi">

									<div class="form-group fullname-custom">
										<div class=" col-md-3"></div>
										
										<div class="col-md-6">
											<label class="control-label  labeld" for="td">Số
												người :<span style="color: red;">*</span>
											</label> <select name="songuoi"
												class="optionheight so-nguoi form-control">

											</select>
										</div>

									</div>
								</div>
								<div class="row rthemtrangmoi">

									<div class="form-group fullname-custom">
										<div class=" col-md-3"></div>
										
										<div class="col-md-6">
											<a href="" type="button" class="btn btn-default" style="width:100%">Chọn bàn</a>
										</div>

									</div>
								</div>

							
								
								




								
								<div class="row rthemtrangmoi">
									<div class="col-md-3"></div>
									<div class="col-md-3">
										<input class="btn btn-success btn-block" type="submit"
											value="Thêm hoá đơn">
									</div>
									<div class="col-md-3">
										<a href="nhahang/khuyenmai/index.html"
											class="btn btn-warning btn-block" type="button">Huỷ</a>
									</div>
									<div class="col-md-3"></div>

								</div>

							</form>
						</div>
						<!-- <div id="menu1" class="tab-pane fade">

							<div class="row ds-banan">
								<div class="col-md-2 border text-center hienthiban">
									<a href="">Chọn bàn</a>
								</div>
								<div class="col-md-1"></div>
							</div>

						</div> -->
					</div>
					<div class="line"></div>
				</div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
			<script>
				/* $(document).ready(function(){ */
				$(document).ready(function() {
					var so_nguoi = document.getElementsByClassName('so-nguoi');
					$('.so-nguoi').empty();
					for (var i = 1; i < 100; i++) {
						var opt = document.createElement('option');
						opt.innerHTML = i + " người";
						opt.value = i;
						$('.so-nguoi').append(opt);
					}

				});
				$(function() {
					$('#thoigian').qcTimepicker({
						'format' : 'H:mm',
						'minTime' : '7:00:00',
						'maxTime' : '23:30:00',
						'step' : 900,
						'placeholder' : 'halo halo'
					});

					$("#thoigian-qcTimepicker").attr({
						"class" : "chontg form-control",
						"name" : "thoigian"
					});
					$("#ngaythang1").datepicker({
						dateFormat : "dd/mm/yy",
						gotoCurrent : true,
						minDate : $("#ngaythang1").val()
					}).datepicker("setDate", $("#ngaythang1").val());
				});
				/* }); */
			</script>
		</div>
	</div>
</body>

</html>