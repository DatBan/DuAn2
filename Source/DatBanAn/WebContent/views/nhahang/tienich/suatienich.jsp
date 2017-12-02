<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <!DOCTYPE html>
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
				<div class="content-nhe"> --%>
					<div class="row tieudethemtrang">

						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>
					
					<form name=suatienich id="suatienich"
						action="nhahang/tienich/suatienich.html" method="post" enctype="multipart/form-data">
						<input style="display: none" name="idtienich" type="text"
							value="${tienich.id}" id="idtienich">
						<div class="row rthemtrangmoi">
							<input style="display: none" name="idnhahang" type="text"
								value="${sessionScope.idnhahang}">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="td">Tên tiện ích
										:<span style="color: red;">*</span>
									</label> <input type="text" name="tentienich" id="tentienich" value="${tienich.tentienich}"
										placeholder="VD: Wifi" class="form-control">
								</div>
							</div>
						</div>

						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="title">Name:<span
										style="color: red;">*</span>
									</label> <input type="text" name="name" id="name" value="${tienich.name}"
										placeholder="Example : Wifi " class="form-control">
								</div>
							</div>
						</div>
						
						
						
						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld " style="float: left;" for="hinh">Chọn
										icon:<span style="color: red;">*</span>
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="file" name="hinh" id="hinh"
											class="form-control col-md-7 col-xs-12"  style="border: none;"/>
										<img src="${pageContext.servletContext.contextPath }/upload/tienich/${tienich.icon}"
											id="viewhinh" class="img-responsive hinh" />
									</div>
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
								<a href="${btn_back}" class="btn btn-warning btn-block"
									type="button">Huỷ</a>
							</div>
							<div class="col-md-3"></div>

						</div>

					</form>
				<%-- </div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>

</body>

</html> --%>