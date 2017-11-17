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
						<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
						<li><a data-toggle="tab" href="#menu1">Bàn</a></li>
						<li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
						<li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
					</ul>	
					<div class="tab-content">
					 <div id="home" class="tab-pane fade in active">        
   
					<form name="suadondatban" id="suadondatban"
						action="nhahang/quanlydatban/suadondatban.html" method="post"
						enctype="multipart/form-data">
						<input style="display: none" name="idhoadon" type="text"
							value="${idhd}" id="idhoadon">
						<div class="row rthemtrangmoi">

							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Mã hoá
										đơn :<span style="color: red;">*</span>
									</label> <input type="text" name="" id="" value="${hoadon.id}"
										placeholder="VD: 1" class="form-control" readonly="readonly">
								</div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Thời gian
										:<span style="color: red;">*</span>
									</label> <input type="text" name="" id="" value="${hoadon.thoigian}"
										placeholder="" class="form-control" readonly="readonly">
								</div>

							</div>
						</div>
						<div class="row rthemtrangmoi">

							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Ngày
										tháng :<span style="color: red;">*</span>
									</label> <input type="text" name="" id="" value="${hoadon.ngaythang}"
										placeholder="" class="form-control">
								</div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Nhân dịp
										:<span style="color: red;">*</span>
									</label> <select name="trangthai"
										class="optionheight nhan-dip form-control">
										<option value="Kỷ niệm">Kỷ niệm</option>
										<option value="Sinh Nhật">Sinh Nhật</option>
										<option value="Khác">Khác</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row rthemtrangmoi">

							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Họ :<span
										style="color: red;">*</span>
									</label> <input type="text" name="" id="" value="${hoadon.ho}"
										placeholder="" class="form-control">
								</div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Tên :<span
										style="color: red;">*</span>
									</label> <input type="text" name="" id="" value="${hoadon.ten}"
										placeholder="" class="form-control">
								</div>
							</div>
						</div>
						<div class="row rthemtrangmoi">

							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Email :<span
										style="color: red;">*</span>
									</label> <input type="text" name="" id="" value="${hoadon.email}"
										placeholder="" class="form-control">
								</div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Số điện
										thoại :<span style="color: red;">*</span>
									</label> <input type="text" name="" id="" value="${hoadon.dienthoai}"
										placeholder="" class="form-control">
								</div>
							</div>
						</div>
						


						<div class="row rthemtrangmoi">

							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Số người
										:<span style="color: red;">*</span>
									</label> <input type="text" name="" id="" value="${hoadon.songuoi}"
										placeholder="" class="form-control">
								</div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="td">Nhân dịp
										:<span style="color: red;">*</span>
									</label> <select name="nhandip"
										class="optionheight nhan-dip form-control">
										<option value="Kỷ niệm">Kỷ niệm</option>
										<option value="Sinh Nhật">Sinh Nhật</option>
										<option value="Khác">Khác</option>
									</select>
								</div>
							</div>
						</div>

						<div class="row rdbho">
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<textarea name="ghichu" id="ghichu" placeholder="Ghi chú"
									class="form-control"
									style="min-height: 120px; max-height: 120px; min-width: 91%; max-width: 91%;">${hoadon.ghichu}</textarea>
							</div>

							<div class="col-md-1"></div>
						</div>
						<div class="row rthemtrangmoi">
							<div class="col-md-3"></div>
							<div class="col-md-3">
								<input class="btn btn-success btn-block" type="submit"
									value="Sửa">
							</div>
							<div class="col-md-3">
								<a href="nhahang/khuyenmai/index.html"
									class="btn btn-warning btn-block" type="button">Huỷ</a>
							</div>
							<div class="col-md-3"></div>

						</div>

					</form>
					 </div> 
					 <div id="menu1" class="tab-pane fade">
					 <div class="row ds-banan">
					 	<div class="col-md-2 border text-center">
								<a href="nhahang/quanlydatban/chonban.html?idhd=${idhd}"><div class="soban">${hoadon.banan.soban}</div></a>
								<div class="trangthai">${hoadon.thoigian}</div>
								<div class="songuoi">${hoadon.banan.songuoi}</div>
							</div>
							<div class="col-md-1">						
							</div>
							</div>
					 </div>
					 </div>
					<div class="line"></div>
				</div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>