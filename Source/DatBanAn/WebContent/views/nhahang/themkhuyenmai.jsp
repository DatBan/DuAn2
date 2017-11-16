<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

					<form name="themkhuyenmai" id="themkhuyenmai"
						action="nhahang/khuyenmai/themkhuyenmai.html" method="post"
						enctype="multipart/form-data">
						<div class="row rthemtrangmoi text-center">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="mota">Ngày
										bắt đầu: <span style="color: red;">*</span>
									</label> <input type="text" name="ngaybatdau" id="ngaythang1"
										placeholder="Chọn ngày" readonly="readonly"
										style="cursor: pointer; background-color: #FFFFFF">
								</div>
								<div class="col-md-5">
									<label class="control-label  labeld" for="mota">Ngày
										kết thúc : <span style="color: red;">*</span>
									</label> <input type="text" name="ngayketthuc" id="ngaythang2"
										placeholder="Chọn ngày" readonly="readonly"
										style="cursor: pointer; background-color: #FFFFFF">
								</div>
								<div class=" col-md-1"></div>
							</div>
						</div>
						<div class="row rthemtrangmoi">

							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="td">Chủ đề :<span
										style="color: red;">*</span>
									</label> <input type="text" name="chude" id="chude"
										placeholder="VD: Giảm giá hoá đơn" class="form-control">
								</div>
							</div>
						</div>

						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="name">Name:<span
										style="color: red;">*</span>
									</label> <input type="text" name="name" id="name"
										placeholder="Example : Invoice discount " class="form-control">
								</div>
							</div>
						</div>

						<div class="row rthemtrangmoi ">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="mota">Thông
										tin:<span style="color: red;">*</span>
									</label>
									<textarea name="thongtin" id="thongtin"
										placeholder="Giảm giá 25% cho tất cả các hoá đơn trên 1000000 đồng" class="form-control"
										style="min-height: 120px; max-height: 120px; min-width: 100%; max-width: 100%;"></textarea>
								</div>
							</div>
						</div>
						

						








						<div class="row rthemtrangmoi">
							<div class="col-md-3"></div>
							<div class="col-md-3">
								<input class="btn btn-success btn-block" type="submit"
									value="Thêm mới">
							</div>
							<div class="col-md-3">
								<a href="nhahang/khuyenmai/index.html"
									class="btn btn-warning btn-block" type="button">Huỷ</a>
							</div>
							<div class="col-md-3"></div>

						</div>

					</form>
				</div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
			<script>
				$(function() {
					$("#ngaythang1").datepicker({
						dateFormat : "dd/mm/yy",
						gotoCurrent : true,
						minDate : 0
					}).datepicker("setDate", new Date());
					$("#ngaythang2").datepicker({
						dateFormat : "dd/mm/yy",
						gotoCurrent : true,
						minDate : 0
					}).datepicker("setDate", new Date());
				});
			</script>
		</div>
	</div>

</body>

</html>