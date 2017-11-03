<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	                			<form:form class="form-label-left clearfix" method="post" action="dashboard/edit-user.html?id=${nguoidung.id}" modelAttribute="nguoidung">
	                				<div class="item form-group col-md-6">
										<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
											Tên đăng nhập <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input path="tendangnhap" cssClass="form-control" disabled="true"/>								
										</div>
									</div>
									
									<div class="item form-group col-md-6">
										<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
											Họ tên <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input path="hoten" cssClass="form-control"/>								
										</div>
									</div>
									
									<div class="item form-group col-md-6">
										<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
											Mật khẩu <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input path="matkhau" cssClass="form-control"/>								
										</div>
									</div>
									
									<div class="item form-group col-md-6">
										<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
											Email <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input path="email" cssClass="form-control"/>								
										</div>
									</div>
									
									<div class="item form-group col-md-6">
										<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
											Điện thoại <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input path="sdt" cssClass="form-control"/>								
										</div>
									</div>
									
									<div class="item form-group col-md-6">
										<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
											Địa chỉ <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:textarea path="diachi" cssClass="form-control" rows="1"/>								
										</div>
									</div>
									
									<div class="item form-group col-md-6">
										<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
											Vai trò <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:select path="quyennd.id" cssClass="form-control"	items="${listquyen}" itemLabel="tenquyen" itemValue="id">
											</form:select>							
										</div>
									</div>
									
									<div class="item form-group col-md-6">
										<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
											Ngày tạo <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" disabled class="form-control"
											placeholder='<fmt:formatDate value="${nguoidung.ngaytao}" pattern="dd/MM/yyyy HH:mm:ss"/>'>										</div>
									</div>
									
									<div class="item form-group col-md-6">
										<form:button class="btn btn-primary">Cập nhật</form:button>
									</div>
	                			</form:form>
	                			<div class="line"></div>
                			</div>
						</div>
						<!------------------- Footer dashboard------------ -->
						<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
					</div>
		</div>
	</body>
</html>