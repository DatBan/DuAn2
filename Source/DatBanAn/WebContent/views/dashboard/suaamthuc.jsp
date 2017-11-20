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

					<form name="themamthuc" id="themamthuc"
						action="dashboard/amthuc/suaamthuc.html" method="post"
						enctype="multipart/form-data">
						<input style="display: none" name="idamthuc" type="text"
							value="${amthuc.id}" id="idamthuc">
						<div class="row rthemtrangmoi">

							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="td">Tên loại
										:<span style="color: red;">*</span>
									</label> <input type="text" name="tenloai" id="tenloai"
										value="${amthuc.tenloai}" placeholder="VD: Việt Nam"
										class="form-control">
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
										value="${amthuc.name}" placeholder="Example : VietNam "
										class="form-control">
								</div>
							</div>
						</div>

						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="mota">Mô tả:<span
										style="color: red;"></span>
									</label>
									<textarea name="mota" id="mota"
										placeholder="Ẩm thực của Việt Nam" class="form-control"
										style="min-height: 120px; max-height: 120px; min-width: 100%; max-width: 100%;">${amthuc.mota}</textarea>
								</div>
							</div>
						</div>
						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="description">Description:<span
										style="color: red;"></span>
									</label>
									<textarea name="description" id="description"
										placeholder="Culinary of VietNam" class="form-control"
										style="min-height: 120px; max-height: 120px; min-width: 100%; max-width: 100%;">${amthuc.description}</textarea>
								</div>
							</div>
						</div>






						<div class="row rthemtrangmoi">
							<div class="col-md-3"></div>
							<div class="col-md-3">
								<input class="btn btn-success btn-block" type="submit"
									value="Sửa">
							</div>
							<div class="col-md-3">
								<a href="dashboard/amthuc/index.html"
									class="btn btn-warning btn-block" type="button">Huỷ</a>
							</div>
							<div class="col-md-3"></div>

						</div>

					</form>
				</div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>

</body>

</html>