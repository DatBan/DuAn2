<%@ page pageEncoding="utf-8"%>
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
			<div class="row tieudethemtrang">
				<p class="tdthemtrangmoi">
					<b>Sửa trang</b>
				</p>
				<span style="margin-top: 30px; color: red; ">${message}</span>
			</div>
			
			<form name=themtrangmoi id="themtrangmoi"
				action="trang/suatrang.html" method="post">
				
				<div class="row rthemtrangmoi">
					
					<div class="form-group fullname-custom">
						<div class=" col-md-3"></div>
						<div class="col-md-6">
							<label class="control-label  labeld" for="tieude">Tiêu
								đề:<span style="color: red;">*</span>
							</label> <input type="text" name="tieude" id="tieude" value="${trang.tieude}"
								placeholder="VD : Liên hệ" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-3"></div>
						<div class="col-md-6">
							<label class="control-label  labeld" for="tieude">Title:<span style="color: red;">*</span>
							</label> <input type="text" name="title" id="title"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-3"></div>

						<div class="col-md-6">
							<label class="control-label  labeld" for="slug">Slug:<span
								style="color: red;">*</span>
							</label> <input type="text" name="slug" id="slug" placeholder="Nhập Slug"
								class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-3"></div>
						<div class="col-md-6">
							<label class="control-label  labeld" for="noidung">Nội
								dung:<span style="color: red;">*</span>
							</label>
							<textarea name="noidung" id ="noidung" placeholder="" class="form-control"
								style="margin: 0px; min-height: 92px; min-width: 536px; max-width: 536px;"></textarea>
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-3"></div>
						<div class="col-md-6">
							<label class="control-label  labeld" for="content">Content:<span style="color: red;">*</span>
							</label>
							<textarea name="content" id="content" placeholder="" class="form-control"
								style="margin: 0px; min-height: 92px; min-width: 536px; max-width: 536px;"></textarea>
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
						<a href="trang/index.html" class="btn btn-warning btn-block"
							type="button">Huỷ</a>
					</div>
					<div class="col-md-3"></div>

				</div>

			</form>
		</div>
	</div>
</body>

</html>