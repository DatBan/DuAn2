<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
								
	                			<form:form id="edit-user-db" class="form-label-left clearfix" method="post" action="dashboard/user-management.html?edit&id=${sessionScope.nd.id}" modelAttribute="nguoidung">
	                				<div class="row">
		                				<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Tên đăng nhập <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<input id="tdn" class="form-control" style="display: none;" value="${sessionScope.nd.tendangnhap}"/>								
											</div>
										</div>
											
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Mật khẩu <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<input type="text" name="matkhau" class="form-control" placeholder="Để trống nếu không thay đổi"/>								
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Họ <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<input  class="form-control"/>								
											</div>
										</div>
										
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Tên <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<input  class="form-control"/>								
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Email <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<input style="display: none;" class="form-control"/>								
											</div>
										</div>
										
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Điện thoại <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<input  class="form-control"/>								
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Địa chỉ <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<input  class="form-control" />							
											</div>
										</div>
										
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Vai trò <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<input  style="display: none;" class="form-control"/>							
											</div>
											
										</div>
									</div>
									
									<div class="row">
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Ngày tạo <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<input type="text" disabled class="form-control"
													placeholder='<fmt:formatDate value="${sessionScope.nd.ngaytao}" pattern="dd/MM/yyyy HH:mm:ss"/>'>										
											</div>
										</div>
										
										<div class="item form-group col-md-6 clearfix">
											<div class="col-md-7 col-sm-6 col-xs-12">
												<button class="btn btn-primary">Cập nhật</button>
												<input type="reset" class="btn btn-default" value="Reset"/>
											</div>
										</div> 
									</div>
	                			</form:form>
	                			<%-- <div class="line"></div>
                			</div>
						</div>
						<!------------------- Footer dashboard------------ -->
						<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
					</div>
		</div>
	</body>
</html> --%>